/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.cliente;

import ec.edu.espe.distribuidas.facturacion.exceptions.ExcepcionSocketDesconectado;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.Cabecera;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ControladorMensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRespuesta;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.Mensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;
import ec.edu.espe.distribuidas.facturacion.socket.servidor.SocketComunicacion;

/**
 * Controlador que me permite gestionar el envio y el manejo de mensajes
 * @author Carlos
 */
public class SocketControladorCliente 
{
    private SocketCliente socketCliente;
    private ControladorMensaje controladorMsj;
    
    public SocketControladorCliente(String host,int puerto)
    {
        this.socketCliente=new SocketCliente(host,puerto);
        this.controladorMsj=new ControladorMensaje();
    }
    
    /**
     * Me permite crear una nueva conexion con socketCliente
     */
    public void crearNuevaConexion()
    {
        this.socketCliente.conectar();
    }
    
    /**
     * me permite gestionar el envio y la respuesta de mensajes
     * @param mensajeRQ
     * @return 
     */
    public Mensaje enviarMensaje(MensajeRQ mensajeRQ) throws ExcepcionSocketDesconectado
    {
        boolean resultado=this.socketCliente.salida(mensajeRQ.asTexto());
        //verifica que el mensaje se pudo enviar
        if(resultado)
        {
            String tramaRespuesta=this.socketCliente.leer();
            if(tramaRespuesta.equals(SocketComunicacion.TEXTO_SALIR))
            {
                return null;
            }
            Mensaje mensajeRespuesta=controladorMsj.construirMensaje(tramaRespuesta);
            
            return mensajeRespuesta;
        }
        else
        {
           throw new ExcepcionSocketDesconectado("El socket fue desconectado");
        }
        
    }

    public void setSocketCliente(SocketCliente socketCliente) {
        this.socketCliente = socketCliente;
    }
    
    
}
