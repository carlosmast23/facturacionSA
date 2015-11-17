/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRS;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TipoDatoMensaje;

/**
 *
 * @author Carlos
 */
public class LoginRQ extends CuerpoRQ
{

    @Override
    public void ejecutar() {
         agregarAtributo(new Text("carlosmast", 10) );
         agregarAtributo(new Text("1234",10));         
         
    }

    @Override
    public String getIdMensaje() 
    {
        return "AUTENTIC01";
    }  

}
