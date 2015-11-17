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
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Ent;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TextV;

/**
 *
 * @author Carlos
 */
public class ClienteMsjRS extends CuerpoRS 
{

    @Override
    public void ejecutar() 
    {
        Text documento=(Text) getParametro("documento");
        Text cedula=(Text) getParametro("cedula");
        
        
        ClienteServicio servicio=new ClienteServicio();
        Cliente cliente=servicio.obtnerCliente(documento.getDato(),cedula.getDato());
        
        agregarAtributo(new Text("OKO",3));
        agregarAtributo(new Text(cliente.getValorDocumento(),9));
        
        TextV textoVariable=new TextV();        
        textoVariable.agregarObjCodificado(cliente);
        agregarAtributo(textoVariable);

        
    }

    @Override
    public String getIdMensaje() 
    {
        return "CLIBUSSIMP";
    }

    @Override
    public void definirEstructura() 
    {
        agregarParametro("documento",new Text(5));
        agregarParametro("cedula",new Text(15));
        
    }

    
    
}
