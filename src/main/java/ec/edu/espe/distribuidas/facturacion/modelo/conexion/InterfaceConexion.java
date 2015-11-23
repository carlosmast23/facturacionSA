/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.conexion;

import java.sql.ResultSet;

/**
 *
 * @author Carlos
 */
public interface InterfaceConexion 
{
    public abstract int ejecutarQuery(String consulta);
    public abstract ResultSet ejecutarConsulta(String consulta);
}
