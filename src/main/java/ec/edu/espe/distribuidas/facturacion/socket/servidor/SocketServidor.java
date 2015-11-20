/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class SocketServidor {
    
    private int puerto;
    ServerSocket sc;
    
    public SocketServidor() 
    {
        try {
            this.puerto=9999;
            sc=new ServerSocket(puerto);
        } catch (IOException ex) {
            Logger.getLogger(SocketServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Socket conectar()
    {
        try {
            
            System.out.println("Esperando conexiones");
            return sc.accept();
           // System.out.println("Conexion Establecida");
                       
        } catch (IOException ex) {
            Logger.getLogger(SocketServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
