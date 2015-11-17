/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRS;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Dec;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Ent;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;

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
                
        agregarAtributo(new Text("OK",2));

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
