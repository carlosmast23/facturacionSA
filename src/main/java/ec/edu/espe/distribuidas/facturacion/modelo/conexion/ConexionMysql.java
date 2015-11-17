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


public class ConexionMysql extends AbstractConexion
{

    @Override
    public void conectar() {
         try {
            
            Class.forName("com.mysql.jdbc.Driver"); //busca el driver para realizar la conexion con mysql
            conexion=  (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/facturadb","root", "1234");//datos de la conexio
           // System.out.println("conexion ok");
            //JOptionPane.showMessageDialog(null,"conectado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
   
}
