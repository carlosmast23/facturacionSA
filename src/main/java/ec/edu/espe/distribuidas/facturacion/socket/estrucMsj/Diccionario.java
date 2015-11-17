/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TipoDatoMensaje;
import java.util.Map;

/**
 *
 * @author Carlos
 */
public class Diccionario 
{
    public static int contador=0;
    public String key;
    public TipoDatoMensaje valor;

    public Diccionario(String key, TipoDatoMensaje valor) {
        this.key = key;
        this.valor = valor;
    }

    public Diccionario(TipoDatoMensaje valor) {
        this.valor = valor;
        this.key=(contador++)+"";
    }
    
    
    
}
