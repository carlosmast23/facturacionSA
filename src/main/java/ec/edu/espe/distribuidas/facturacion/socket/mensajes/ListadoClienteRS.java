/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajes;

import ec.edu.espe.distribuidas.facturacion.modelo.entity.Cuenta;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRS;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Dec;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Ent;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Text;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TextV;

/**
 *
 * @author Carlos
 */
public class ListadoClienteRS extends CuerpoRS{

    @Override
    public void ejecutar() 
    {
        Integer codigo=(Integer) getParametro("codigo").getDato();
        //System.out.println(codigo);
        agregarAtributo(new Text("OKO",3));
        agregarAtributo(new Ent(codigo,9));
        agregarAtributo(new Ent(2,2));
        //agregarAtributo(new Dec("12.3",5,2));
        Cuenta cuenta=new Cuenta("17123213","ahorro",12.34f);
        Cuenta cuenta2=new Cuenta("19143512","ahorro",102.34f);
                
        TextV textv=new TextV();
        textv.agregarObjCodificado(cuenta);
        textv.agregarObjCodificado(cuenta2);
        agregarAtributo(textv);
        
    }

    @Override
    public void definirEstructura() {
        agregarParametro("codigo",new Ent(9));
        
    }

    @Override
    public String getIdMensaje() {
        return "CLIBUSCUEN";
    }
    
}
