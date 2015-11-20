/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRespuesta;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;

/**
 *
 * @author Carlos
 */
public class LoginRespuesta extends CuerpoRespuesta
{

    @Override
    public void definirEstructura() {
        agregarAtributo("respuesta",new Text(2));
 
    }

    @Override
    public String getIdMensaje() {
        return "AUTENTIC01";
    }
    
}
