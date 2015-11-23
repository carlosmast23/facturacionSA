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
public class SqlDMLRQ extends CuerpoRQ
{
    private String query;

    public SqlDMLRQ(String query) 
    {
        this.query = query;
    }    
    
    @Override
    public void ejecutar() {
        agregarAtributo(new Text(query,128));
    }

    @Override
    public String getIdMensaje() {
        return "SQLDML001";
    }
}
