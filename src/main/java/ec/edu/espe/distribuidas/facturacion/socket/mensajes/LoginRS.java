/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.modelo.servicio.UsuarioServicio;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ControladorMensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRS;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Dec;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Ent;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;
import ec.edu.espe.distribuidas.facturacion.socket.servidor.SocketComunicacion;

/**
 *
 * @author Carlos
 */
public class LoginRS extends CuerpoRS
{

    public void ejecutar() 
    {
        
        Text usuario=(Text) getParametro("usuario");
        Text clave=(Text) getParametro("clave");              
        
        UsuarioServicio servicio=new UsuarioServicio();
        if(servicio.login(usuario.getDato(),clave.getDato()))
        {
            agregarAtributo(new Text("OK",2));
        }
        else
        {
            agregarAtributo(new Text(SocketComunicacion.TEXTO_SALIR,2));
        }       

    }

    @Override
    public void definirEstructura() 
    {
        agregarParametro("usuario",new Text(10));
        agregarParametro("clave",new Text(10));  
    }

    @Override
    public String getIdMensaje() {
        return "AUTENTIC01";
    }
    
}
