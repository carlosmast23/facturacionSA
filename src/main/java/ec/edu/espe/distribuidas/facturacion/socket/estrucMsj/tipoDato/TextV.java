/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRsCodificar;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Carlos
 */
public class TextV extends TipoDatoMensaje<String[]>
{
    public List<String> datos;
    private static final String limitador="|";
    private String trama;
    private Ent numeroGrupos;


    public TextV(String trama) {
        this.trama = trama;
        this.longitud=-1;
        datos=new LinkedList<>();
    }
    
    
    
     public TextV(Ent ent) 
     {
        this.numeroGrupos = ent;
        this.longitud=-1;
        datos=new LinkedList<>();
    }
    
    public void agregarCantidadGrupos(Ent grupos)
    {
        this.numeroGrupos=grupos;
    }
    
    public TextV() 
    {
        datos=new LinkedList<>();
        this.longitud=-1;
    }
    
    public void agregarDato(String dato)
    {
        datos.add(dato);
    }

    @Override
    public String[] getDato() 
    {
        return StringUtils.splitByWholeSeparator(trama,limitador);
    }

    @Override
    public void setDato(String dato) {
        this.longitud=dato.length();
        String datos[]=StringUtils.splitByWholeSeparator(dato,limitador);
        for (String resultado : datos) 
        {
            this.datos.add(resultado);
        }
        
    }

    @Override
    public String asTexto() 
    {
        StringBuilder sb=new StringBuilder();
        for (String dato : datos) {
            sb.append(dato);
            sb.append(limitador);
        }
        String resultado=validarTrama(sb.toString());
        return resultado;
    }
    
    
    public void agregarObjCodificado(MensajeRsCodificar mensajeCodificado)
    {
        String msj=validarTrama(mensajeCodificado.asTexto(limitador));
        String datos[]=StringUtils.splitByWholeSeparator(msj,limitador);
        for (String dato : datos) 
        {
            agregarDato(dato);
        }
    }
    
        
    public String validarTrama(String trama)
    {
        if(trama.length()>1)
        {
            //String resultado="";
            if(trama.charAt(trama.length()-1)==limitador.charAt(0))
            {
                trama=trama.toString().substring(0,trama.toString().length()-1);
                
            }
            
            if(!(trama.charAt(0)==limitador.charAt(0)))
            {
                trama=limitador+trama;
            }
            //return trama;
        }
        
        return trama;
    }
    
    public String get(int i)
    {
        return datos.get(i);
    }
    
    /**
     * Funcion que obtiene un subgrupo de la cantidad total de datos
     * segun una variable que me permite saber la cantidad de cada grupo
     * @param numeroSubGrupo numero del subgrupo que desea obtener
     * @param numeroGrupos  numero de la cantidad de grupos contenidos
     * @return 
     */
    public List<String> getGrupo(int numeroSubGrupo)
    {
        List<String> resultado=new LinkedList<>();
        int longitudGrupo=datos.size()/numeroGrupos.getDato();
        int inicio=numeroSubGrupo*longitudGrupo;
        
        for (int i = inicio; i < inicio+longitudGrupo; i++) 
        {
            resultado.add(datos.get(i));
        }
        return resultado;
    }
    
}
