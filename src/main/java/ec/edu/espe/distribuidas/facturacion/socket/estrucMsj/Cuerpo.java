/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TipoDatoMensaje;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Carlos
 */
public class Cuerpo 
{    

    private Map<String,TipoDatoMensaje> atributos;
    private int claveAutomatica;

    public Cuerpo() 
    {

        atributos=new HashMap<String,TipoDatoMensaje>();
    }

        

     
    public void agregarAtributo(String clave,TipoDatoMensaje dato)
    {
        atributos.put(clave,dato);
    }
    
    public void agregarAtributo(TipoDatoMensaje dato)
    {
        atributos.put((claveAutomatica++)+"",dato);
    }
    
    public TipoDatoMensaje getAtributos(String clave)
    {
        return atributos.get(clave);
    }

    public Map<String, TipoDatoMensaje> getAtributos() {
        return atributos;
    }
   
    public String asTexto()
    {
        StringBuilder sb=new StringBuilder();
        Iterator it=atributos.keySet().iterator();
        while(it.hasNext())
        {
            String clave=(String) it.next();
            TipoDatoMensaje dato= atributos.get(clave);
            sb.append(dato.asTexto());
        }
        return sb.toString();
    }
    
    public void limpiar()
    {
        atributos.clear();        
    }
    
    
}
