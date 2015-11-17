/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRespuesta;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TextV;

/**
 *
 * @author Carlos
 */
public class ClienteMsjRespuesta extends CuerpoRespuesta
{
    @Override
    public void definirEstructura() {
        agregarAtributo("resultado",new Text(3));
        agregarAtributo("codigo",new Text(9));
        agregarAtributo("datos",new TextV());
    }

    @Override
    public String getIdMensaje() {
         return "CLIBUSSIMP";
    }
    
}
