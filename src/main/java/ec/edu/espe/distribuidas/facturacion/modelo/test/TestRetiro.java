/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.test;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ControladorMensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRS;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.RetiroRQ;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.TransaccionRQ;

/**
 *
 * @author Carlos
 */
public class TestRetiro {
    public static void main(String []args)
    {

          RetiroRQ cuerpoRQ =new RetiroRQ();
          MensajeRQ mq=new MensajeRQ(cuerpoRQ);
          
          System.out.println(mq.asTexto());
          
          ControladorMensaje controlador=new ControladorMensaje();
          MensajeRS rs=controlador.ejecutarMensaje(mq.asTexto());
          System.out.println(rs.asTexto());
        
    }
}
