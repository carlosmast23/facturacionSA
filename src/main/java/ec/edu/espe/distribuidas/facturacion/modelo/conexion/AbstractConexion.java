/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.conexion;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public abstract class AbstractConexion 
{
    private static ConexionMysql conexionSingleton;//variable estatica para almacenar la conexion
    protected Connection  conexion;
    
    protected Statement s;
    protected ResultSet rs;

    public AbstractConexion() {
        conexion=null;
        conectar();
    }
    
    //patron singleton para devolver un objeto de conexion unico para toda la aplicacion
    public static ConexionMysql getConexion()
    {
        if(conexionSingleton==null)
        {
            conexionSingleton=new ConexionMysql();
            return conexionSingleton;
        }
        return conexionSingleton;
    }
    
   
    
    abstract public void conectar();
    
    public void desconectar()
    {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //TE DEVUELVE datos de la bases
    public ResultSet ejecutarConsulta(String consulta)
    {
        //conectar();
        try {
            s = conexion.createStatement();
            rs = s.executeQuery (consulta);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
       // desconectar();
        return null;
    }
    
    //ejecutar update,insert,delete
     public void ejecutarQuery(String consulta)
    {
        //conectar();
        try {
            s = conexion.createStatement();
            s.execute(consulta);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
       // desconectar();
       // desconectar();
        
    }
    
     public static void main(String[] args) {
         ConexionMysql conexion=new ConexionMysql();
         conexion.conectar(); 
     }

    public Connection getConexionDB() {
        return conexion;
    }

     
}
