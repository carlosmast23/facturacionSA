/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.mensajesDB;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRespuesta;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.Ent;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TextV;

/**
 *
 * @author Carlos
 */
public class SqlDMLRespuesta extends CuerpoRespuesta
{

    @Override
    public void definirEstructura() 
    {
        Ent numColumna=new Ent(6);
        agregarAtributo("numColumnas",numColumna);
        agregarAtributo("datos",new TextV(numColumna));
    }

    @Override
    public String getIdMensaje() 
    {
        return "SQLDML001";
    }
    
}
