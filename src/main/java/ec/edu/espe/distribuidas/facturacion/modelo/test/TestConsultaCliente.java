/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.test;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ControladorMensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.Mensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRS;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.ClienteMsjRQ;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.ClienteMsjRespuesta;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.LoginRQ;

/**
 *
 * @author Carlos
 */
public class TestConsultaCliente 
{
    public static void main(String[] args)
    {
          ClienteMsjRQ clienteRQ =new ClienteMsjRQ();
          MensajeRQ mq=new MensajeRQ(clienteRQ);
          
          System.out.println(mq.asTexto());
          
          ControladorMensaje controlador=new ControladorMensaje();
          MensajeRS rs=controlador.ejecutarMensaje(mq.asTexto());
          
          System.out.println(rs.asTexto());
          
          Mensaje respuesta=controlador.construirMensaje(rs.asTexto());
          System.out.println(respuesta.asTexto());
          
          respuesta.getCuerpo().getAtributos("codigo");
          
          System.out.println("---->"+respuesta.getCuerpo().getAtributos("codigo").getDato());
    }   
}
