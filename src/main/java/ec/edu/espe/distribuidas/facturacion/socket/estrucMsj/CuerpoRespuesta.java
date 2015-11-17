/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj;

import java.util.List;

/**
 *
 * @author Carlos
 */
public abstract class CuerpoRespuesta extends Cuerpo implements CuerpoInterface
{
    public abstract void definirEstructura();
    
    
    public void construirAtributos(String trama)
    {
        List<Diccionario>  atributos =getAtributos();
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
