/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TipoDatoMensaje;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Carlos
 */
public abstract class CuerpoRS extends Cuerpo implements CuerpoInterface
{
    private Map<String,TipoDatoMensaje> parametros;
    public abstract void definirEstructura();

    public CuerpoRS() 
    {
        
        parametros=new HashMap<String,TipoDatoMensaje>();
    }
     
    public void agregarParametro(String clave,TipoDatoMensaje dato)
    {
        parametros.put(clave, dato);
    }
    
    public TipoDatoMensaje getParametro(String clave)
    {
        return parametros.get(clave);
    }
    
    public void construirAtributos(String trama)
    {
        Map<String,TipoDatoMensaje> atributos =getAtributos();
        Iterator it = atributos.keySet().iterator();
        String parametroTxt;
        while (it.hasNext()) 
        {
            String key = (String) it.next();
            TipoDatoMensaje dato=atributos.get(key);
            
            parametroTxt=trama.substring(0,dato.getLongitud());
            trama=trama.substring(dato.getLongitud());
            
            dato.setDato(parametroTxt);
            
        }
    }
    
}
