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

    private List<Diccionario> atributos;
    private int claveAutomatica;

    public Cuerpo() 
    {

        atributos=new LinkedList<>();
    }

        

     
    public void agregarAtributo(String clave,TipoDatoMensaje dato)
    {
        atributos.add(new Diccionario(clave, dato));

    }
    
    public void agregarAtributo(TipoDatoMensaje dato)
    {
        atributos.add(new Diccionario(dato));
    }
    
    public TipoDatoMensaje getAtributos(String clave)
    {
        for (Diccionario atributo : atributos) {
            if(atributo.key.equals(clave))
            {
                return atributo.valor;
            }
        }
        return null;
    }

    public List<Diccionario> getAtributos() 
    {
        return atributos;
    }
   
    public String asTexto()
    {
        StringBuilder sb=new StringBuilder();
        for (Diccionario atributo : atributos) 
        {
            sb.append(atributo.valor.asTexto());
        }
        
        return sb.toString();
    }
    
    public void limpiar()
    {
        atributos.clear();        
    }
    
    public String getAtributo(int indice)
    {
        return atributos.get(indice).valor.getDato().toString();
    }

    
}
