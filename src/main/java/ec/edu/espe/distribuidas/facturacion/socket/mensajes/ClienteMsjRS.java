/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.modelo.entity.Cliente;
import ec.edu.espe.distribuidas.facturacion.modelo.servicio.ClienteServicio;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.Cuerpo;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRS;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRS;

/**
 *
 * @author Carlos
 */
public class ClienteMsjRS extends CuerpoRS 
{

    @Override
    public void ejecutar() 
    {
        ClienteServicio servicio=new ClienteServicio();
        Cliente cliente=servicio.obtnerCliente("ced","1812323");
       // agregarParametro(null, null);
       // String tipoDocumento=mensajeRQ.getCuerpo().getDatos(0);
       // String valor=mensajeRQ.getCuerpo().getDatos(1);
       // ClienteServicio servicio=new ClienteServicio();
       // Cliente cliente=servicio.obtnerCliente(tipoDocumento, valor);
       // this.agregarDatoCadena(cliente);
        
    }

    @Override
    public String getIdMensaje() 
    {
        return "CLIBUSSIMP";
    }

    @Override
    public void definirEstructura() 
    {
        //agregarEstructParametro(new );
    }

    
    
}
