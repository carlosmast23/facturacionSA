/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.test;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ControladorMensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRS;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.ClienteMsjRQ;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.ClienteMsjRS;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.LoginRQ;

/**
 *
 * @author Carlos
 */
public class TestMensajes 
{
    public static void main(String []args)
    {
//        ClienteMsjRQ cuerpo=new ClienteMsjRQ();
//        MensajeRQ mq=new MensajeRQ(cuerpo);
//        
//        System.out.println(mq.asTexto());
//        
//        
//        ControladorMensaje  controlador=new ControladorMensaje();
//        MensajeRS rs=controlador.ejecutarMensaje(mq.asTexto());
//        System.out.println(rs.asTexto());
        
          LoginRQ loginRQ =new LoginRQ();
          MensajeRQ mq=new MensajeRQ(loginRQ);
          
          System.out.println(mq.asTexto());
          
          ControladorMensaje controlador=new ControladorMensaje();
          MensajeRS rs=controlador.ejecutarMensaje(mq.asTexto());
          System.out.println(rs.asTexto());
        
    }
}   
