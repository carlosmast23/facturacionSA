/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Dec;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Ent;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;

/**
 *
 * @author Carlos
 */
public class TransaccionRQ extends CuerpoRQ{

    @Override
    public void ejecutar() {
        agregarAtributo(new Ent(171233,15));
        agregarAtributo(new Ent(1,2));
        agregarAtributo(new Dec(182.34f,7,2));
        agregarAtributo(new Text("PASSP",5));
        agregarAtributo(new Text("234234sd",15));
        
    }

    @Override
    public String getIdMensaje() {
        return "TRADEPOSIT";
    }
    
}
