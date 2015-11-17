/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Ent;

/**
 *
 * @author Carlos
 */
public class CuentasClienteRQ extends CuerpoRQ
{

    @Override
    public void ejecutar() 
    {
        agregarAtributo(new Ent("123",9));
    }

    @Override
    public String getIdMensaje() {
        return "CLIBUSCUEN";
    }
    
}
