/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.dao;


import ec.edu.espe.distribuidas.facturacion.modelo.conexion.ConexionMysql;
import ec.edu.espe.distribuidas.facturacion.modelo.conexion.InterfaceConexion;
import ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo.AbstractMapeo;
import ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo.Columna;
import ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo.Lista;
import ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo.Mapeo;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase que permite establecer los metodos principales para acceder a la base de datos
 * 
 * @author Carlos
 */
public abstract class AbstractFacade<T extends AbstractMapeo>
{
    /**
     * Referencia para obtener una conexion con la base de datos
     */
    private InterfaceConexion conexion;
    //protected abstract Class getClassEntity();
    private Class<T> entityClass;
    

    /**
     * Lista de objetos que actua como proxy
     * para grabar los objetos que son creados
     * y cuando otro objeto necesite la referencia
     * solo coge de la lista de objetos
     */
    private static List<AbstractMapeo> lista=new LinkedList<>();
    
   // protected Class getClassEntity()
   // {
    //    ;
    //}
    
   // public AbstractFacade() 
   // {
        
    //}
    
    public AbstractFacade(Class<T> entityClass)
    {
        this.entityClass=entityClass;
        this.conexion = ConexionMysql.getConexion();
    }
    
    protected Class<T> getClassEntity()
    {
        return entityClass;
    }
        
    /**
     * Obejto que permite comunicarme con la base de datos
     * 
     * @param i objeto que implemente la interfaz Mapeo 
     */
    public void insert(AbstractMapeo i)
    {
        Mapeo mapeo=i.getMapeo();
        ArrayList<Columna> columnas=mapeo.getColumnas();
        String consulta="INSERT INTO "+mapeo.getNombreTabla()+"(";
        
        for (int j = 0; j < columnas.size(); j++) {
            Columna c=columnas.get(j);
            if(j==(columnas.size()-1))
            {
                consulta=consulta+c.getName();    
            }
            else
            {
                consulta=consulta+c.getName()+",";   
            }
            
        }
        
         consulta=consulta+") VALUES (";
         
        for (int j = 0; j < columnas.size(); j++) 
        {
            Columna c = columnas.get(j);
            if (j == (columnas.size() - 1)) 
            {
                consulta = consulta +"'"+ c.getRefAtributo().toString()+"'";
            } 
            else 
            {
                consulta = consulta +"'"+ c.getRefAtributo().toString()+ "',";
            }

        }
       
        consulta=consulta+");";
        // System.out.println(consulta); 
        this.conexion.ejecutarQuery(consulta);
 
    }
    
    /**
     * Encuentra un valor en la bd y los convierte en objeto
     * con sus referencia y listas de objetos
     * 
     * @param valor parametros que corresponde a la clave principal
     * @return 
     */
    public T findByPrimaryKey(String valor)
    {                  
        T res=findByPrimaryKeyRecursive(valor);
        LimpiarCache();
        return res;
    }
    
    private T findByPrimaryKeyRecursive(String valor)
    {
          T obj=getObjectBlank();
          Columna columna=obj.getMapeo().getColumaPk();
          String query="SELECT * FROM "+obj.getMapeo().getNombreTabla()+" WHERE "+columna.getName()+"='"+valor+"'";
         // System.out.println(query);
          return convertAnObject(this.conexion.ejecutarConsulta(query));
    }
    
    public List<T> findId(String campo,String valor)
    {
          AbstractMapeo obj=getObjectBlank();
          Columna columna=obj.getMapeo().getColumaPk();
          String query="SELECT * FROM "+obj.getMapeo().getNombreTabla()+" WHERE "+campo+"='"+valor+"'";
          System.out.println(query);
          return arrayToObject(this.conexion.ejecutarConsulta(query));
    }
    
    /**
     * Obtiene todos los valores de la tabla
     * @param campo
     * @param valor
     * @return 
     */
    public List<T> findAll()
    {
          AbstractMapeo obj=getObjectBlank();
          Columna columna=obj.getMapeo().getColumaPk();
          String query="SELECT * FROM "+obj.getMapeo().getNombreTabla();
          System.out.println(query);
          return arrayToObject(this.conexion.ejecutarConsulta(query));
    }
    
    private List<T> arrayToObject(ResultSet r)
    {
        List<T> lista=new LinkedList<>();
        //Object []lista = new Object[sizeResulSet(r)];
        
        int i=0;
        try {
            r.beforeFirst();
            while(r.next())
            {
                T o=convertAnObject(r);
                lista.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    private int sizeResulSet(ResultSet r)
    {
        int i=0;
        
        try {
            r.beforeFirst();
            while (r.next()) {
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
        
    /**
     * Funcion que permite realizar la conversion entre tipo
     * de datos de Resulset en Datos
     * 
     * @param one variable para saber si 
     */
    private T convertAnObject(ResultSet r)
    {
       // this.contListaObjRef++;
        try {
            if(r.isBeforeFirst())
                r.next();
           // while(r.next())
           // {
            
                T objBlanco=getObjectBlank();
                ArrayList<Columna> columnas=objBlanco.getMapeo().getColumnas();
                for (Columna columna : columnas) {
                    
                    Field field=columna.getRefAtributo();
                    //System.out.println(columna.getName());
                    
                    //field.set(objBlanco,valor);
                    String nameAtributo=field.getName();
                    char primero=nameAtributo.charAt(0);
                    String texto=nameAtributo;
                    texto = "set"+Character.toUpperCase(primero) + texto.substring(1,texto.length());
                    Method[] metodos=getClassEntity().getMethods();
                    //buscar el metodo que coincida con el nombre del atributo con el metodo set
                    Method metodoEncontrado=findMethod(getClassEntity().getMethods(),texto);
                                      
                    
                    //verificar si el valor es directo o es una referencia fk
                    String tipoClave=columna.getTypekey();
                    if(tipoClave.equals("fk"))
                    {
                        String tipo=field.getType().getName();
                        Object value=r.getString(columna.getName());
                        
                        String nombreClaseReferencia=tipo;
                        Class claseReferencia=Class.forName(nombreClaseReferencia);
                        
                        ///verificar que el objeto exista no exista en la lista
                        Object objReferencia;
                        Object tempReferencia=findLista(newObjectPrimaryKey(claseReferencia,value));
                        if(tempReferencia!=null)
                        {
                            objReferencia=tempReferencia;                            
                        }
                        else
                        {
                            //cuando no existe el objeto
                            Method metodoGetFacade=findMethod(claseReferencia.getMethods(),"getDao");
                            Class claseFacade=(Class) metodoGetFacade.invoke(claseReferencia.newInstance());

                            Method metodoFindPrimaryKey=findMethod(claseFacade.getMethods(),"findByPrimaryKeyRecursive");
                            AbstractFacade facadeReferencia=(AbstractFacade) claseFacade.newInstance();
                            objReferencia=metodoFindPrimaryKey.invoke(facadeReferencia,value);
                            AbstractFacade.addLista((AbstractMapeo) objReferencia);
                        }
                                                                                      
                        //agrega el objeto de referencia al objeto principal
                        metodoEncontrado.invoke(objBlanco,objReferencia);

                    }
                    else
                    {
                    //obtner el valor segun el tipo de dato del atributo
                                        
                        String tipo=field.getType().getSimpleName();
                        String nombreColumna=columna.getName();
                        Object value=r.getObject(nombreColumna);
                        //System.out.println(value.getClass().getTypeName());
                        metodoEncontrado.invoke(objBlanco,value);

                    }

                }
            //agregar el objto a la lista si no se encuentra 
            if(!AbstractFacade.isFindLista(objBlanco))
            {
                AbstractFacade.addLista(objBlanco);
            }
                
            ////consultar los arrays enlazados dentro de cada objeto
            List<Lista> areglos = objBlanco.getMapeo().getArrays();
            for (Lista areglo : areglos) 
            {
                Class claseResultado=areglo.getClase();
                String tabla=areglo.getTablaBusqueda();
                String condicion=areglo.getKeyNameFilter();
                //obtener el valor de la clave principal
                Columna columaPk=objBlanco.getMapeo().getColumaPk();
                String texto=columaPk.getName();
                String nombreMetodo="get"+Character.toUpperCase(texto.charAt(0)) + texto.substring(1,texto.length());;
                Method metodoGetValor=findMethod(objBlanco.getClass().getMethods(),nombreMetodo);
                Object valor=metodoGetValor.invoke(objBlanco);
                String consulta="SELECT * FROM "+tabla+" WHERE "+condicion+"='"+valor.toString()+"'";
                //System.out.println(consulta);
                ResultSet rs=this.conexion.ejecutarConsulta(consulta);
                //recorrer uno por uno para obtner la variable de la columna que necesito

                int tamnioArray=sizeResulSet(r);
                Object arrayResultado=Array.newInstance(claseResultado,tamnioArray);
                r.beforeFirst();
                
                int indice=0;
                while(rs.next())
                {
                    //obtengo el valor de la columna de que corresponde al objeto de la solucion
                    Object valorRespuesta=rs.getObject(areglo.getKeyNameResult());
                    Object objResultado;
                    Object tempReferencia=findLista(newObjectPrimaryKey(claseResultado,valorRespuesta));
                    if (tempReferencia != null) 
                    {
                        objResultado = tempReferencia;
                    } 
                    else 
                    {
                        Object objRes = claseResultado.newInstance();
                        Method metodoGetDao = findMethod(objRes.getClass().getMethods(), "getDao");
                        Class classDao = (Class) metodoGetDao.invoke(objRes);
                        Object objDao = classDao.newInstance();
                        Method metodoFindPrimaryKey = findMethod(classDao.getMethods(), "findByPrimaryKeyRecursive");
                        
                        //ObjectnewObjectPrimaryKey(classDao,valorRespuesta);
                        //encuentro un objeto del tipo respuesta para agregar a la lista de referencias
                        Method metodoGetObjectBlanck=findMethod(classDao.getMethods(),"getObjectBlank");
                        objResultado=metodoGetObjectBlanck.invoke(objDao);
                        objResultado=newObjectPrimaryKey(objResultado.getClass(),valorRespuesta);
                        AbstractFacade.addLista((AbstractMapeo) objResultado);
                        objResultado = metodoFindPrimaryKey.invoke(objDao, valorRespuesta);
                        
                    }
        
                    //Array.set(arrayResultado,indice++,claseResultado.cast(objResultado));                    
                    areglo.copyObj(objResultado);
                }
                
                //////////convertir de array en una lista para asignar
                //List listaResultado=Arrays.asList(arrayResultado);
                //areglo.copyList((Object[]) arrayResultado);
                //areglo.getKeyNameFilter();
               
            }
             
                                  
        return objBlanco;
            //}
        } catch (SQLException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            System.out.println(ex.getCause());
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public T getObjectBlank()
    {
        T obj=null;
        try {
            Class clase=getClassEntity();
            obj=(T) clase.newInstance();  
            obj.setMapeo();
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    private Method findMethod(Method[] vector,String key)
    {
        for (Method vector1 : vector) 
        {
            if(vector1.getName().equals(key))
            {
                return vector1;
            }
        }
        return null;
    }

    
    public static AbstractMapeo findLista(AbstractMapeo obj) 
    {
        List<AbstractMapeo> lista=AbstractFacade.getLista();
        for (AbstractMapeo lista1 : lista) {
            if(lista1.equals(obj))
            {
                return lista1;
            }
        }
        return null;
    }
    
    public static Boolean isFindLista(AbstractMapeo obj) 
    {
        List<AbstractMapeo> lista=AbstractFacade.getLista();
        for (AbstractMapeo lista1 : lista) {
            if(lista1.equals(obj))
            {
                return true;
            }
        }
        return false;
    }


    public static void addLista(AbstractMapeo obj)
    {
        AbstractFacade.lista.add(obj);
//        System.out.println("---------> Variables Estaticas <---------");
//        for (AbstractMapeo lista1 : lista) {
//            System.out.println("    "+lista1);
//        }
//        System.out.println("---------> fin Variables Estaticas <---------");
    }

    public static List<AbstractMapeo> getLista() {
        return lista;
    }
    
    /**
     * Limpia el cache de referencias temporales
     * 
     * Limpia las referencias temporales utilizadas cuando realiza el mapeo
     * de objetos para relacionar todos los datos de la empresa y se crea una
     * lista de objetos para no cargar objetos que ya fueron creados
     */
    public void LimpiarCache()
    {
        lista.clear();
    }
    
    /**
     * Crea un nuevo objeto pasandole como parametro la clase y el valor
     * @param clase objeto de tipo Class que representa la clase
     * @param valor valor de la clave primaria
     * @return 
     */
    private  AbstractMapeo newObjectPrimaryKey(Class clase, Object valor)
    {
        try 
        {
            
            AbstractMapeo obj=(AbstractMapeo) clase.newInstance();
            Method metodoSetMapeo=findMethod(obj.getClass().getMethods(),"setMapeo");
            metodoSetMapeo.invoke(obj);
            
            Mapeo mapeo=obj.getMapeo();
            String nombreCampo=obj.getMapeo().getColumaPk().getName();
            char primero = nombreCampo.charAt(0);
            String texto ="";
            texto = "set" + Character.toUpperCase(primero) + nombreCampo.substring(1, nombreCampo.length());
            Method metodo= findMethod(clase.getMethods(),texto);
            metodo.invoke(obj,valor);
            return obj;
            
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    
    
}
