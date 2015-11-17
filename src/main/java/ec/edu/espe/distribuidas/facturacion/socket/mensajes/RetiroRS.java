/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRS;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Dec;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Ent;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;

/**
 *
 * @author Carlos
 */
public class RetiroRS extends CuerpoRS{

    @Override
    public void ejecutar() {
        agregarAtributo(new Ent(1,2));
        agregarAtributo(new Dec(150.23f,7,2));
        
    }

    @Override
    public void definirEstructura() {
        agregarParametro("cuenta",new Ent(9));
        agregarParametro("tipoCuenta",new Ent(2));
        agregarParametro("valor",new Dec(7,2));
        agregarParametro("documento",new Text(5));
        agregarParametro("valorDocumento",new Text(15));
        
    }

    @Override
    public String getIdMensaje() {
        return "TRARETIROV";
    }
    
}
