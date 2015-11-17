/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.Cuerpo;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRS;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;

/**
 *
 * @author Carlos
 */
public class ClienteMsjRQ extends CuerpoRQ
{

    @Override
    public String getIdMensaje() 
    {
        return "CLIBUSSIMP";
    }

    @Override
    public void ejecutar() 
    {
      //  agregarDato("CEDUL");
      //  agregarDato("1724218951");
        
    }
    
}
