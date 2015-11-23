/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajesDB;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;

/**
 *
 * @author Carlos
 */
public class LoginRQ extends CuerpoRQ{

    @Override
    public void ejecutar() 
    {
        agregarAtributo(new Text("root",10));
        agregarAtributo(new Text("1234",10));
    }

    @Override
    public String getIdMensaje() 
    {
        return "LOGINDB001";
    }
    
}
