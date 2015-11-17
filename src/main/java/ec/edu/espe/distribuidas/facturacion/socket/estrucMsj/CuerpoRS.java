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

/**
 *
 * @author Carlos
 */
public abstract class CuerpoRS extends Cuerpo implements CuerpoInterface
{
    private List<Diccionario> parametros;
    //private List<Map<String,TipoDatoMensaje>> listaParametros;
    public abstract void ejecutar();
    public abstract void definirEstructura();
   

    public CuerpoRS() 
    {
        parametros=new LinkedList<>();
    }
     
    public void agregarParametro(String clave,TipoDatoMensaje dato)
    {
        parametros.add(new Diccionario(clave, dato));
    }
    
    public TipoDatoMensaje getParametro(String clave)
    {
        for (Diccionario parametro : parametros) {
            if(parametro.key.equals(clave))
            {
                return parametro.valor;
            }
        }
        return null;
    }
    
    public void construirAtributos(String trama)
    {
        List<Diccionario>  atributos =parametros;
        String parametroTxt="";
        for (Diccionario atributo : atributos) 
        {
            Integer longitud=atributo.valor.getLongitud();
            if(longitud==-1)
            {
                parametroTxt=trama;
            }
            else
            {
                parametroTxt=trama.substring(0,longitud);
                trama=trama.substring(longitud);
            }
            atributo.valor.setDato(parametroTxt);
        }        

    }
    
    
}
