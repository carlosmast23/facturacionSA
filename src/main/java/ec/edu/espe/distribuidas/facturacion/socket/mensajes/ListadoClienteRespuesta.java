/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRespuesta;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Ent;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TextV;

/**
 *
 * @author Carlos
 */
public class ListadoClienteRespuesta extends CuerpoRespuesta
{

    @Override
    public void definirEstructura() {
        agregarAtributo("resultado",new Text(3));
        agregarAtributo("codigo",new Ent(9));
        Ent cuenta=new Ent(2);
        agregarAtributo("cuenta",cuenta);
        agregarAtributo("variable",new TextV(cuenta));
    }

    @Override
    public String getIdMensaje() {
        return "CLIBUSCUEN";
    }
    
}
