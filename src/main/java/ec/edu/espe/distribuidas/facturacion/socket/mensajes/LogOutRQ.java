/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRQ;

/**
 *
 * @author Carlos
 */
public class LogOutRQ extends CuerpoRQ
{

    @Override
    public void ejecutar() 
    {
        
    }

    @Override
    public String getIdMensaje() {
        return "LOGOUT0001";
    }
    
}
