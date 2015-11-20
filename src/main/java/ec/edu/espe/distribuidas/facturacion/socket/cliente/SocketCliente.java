/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class SocketCliente
{
    private String host;
    private int puerto;
    private Socket sc;
    private DataOutputStream salida;
    private DataInputStream entrada;

    public SocketCliente() 
    {
        this.host="localhost";
        this.puerto=9999;
        
    }
    
    public SocketCliente(String host, int puerto)
    {
        this.host=host;
        this.puerto=puerto;
    }
    
    public void conectar()
    {
        try {
            sc=new Socket(host,puerto);
            System.out.println("conexion establecida");
            entrada=new DataInputStream(sc.getInputStream());
            salida=new DataOutputStream(sc.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconectar()
    {
        try {
            entrada.close();
            salida.close();
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo que me permite leer una mensaje enviado por el socket
     * @return 
     */
    public String leer()
    {
        try {
            return entrada.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    /**
     * Me permite enviar un mensaje por el socket
     * @param mensaje 
     */
    public boolean salida(String mensaje)
    {
        try {
            salida.writeUTF(mensaje);
            return true;
        } catch (IOException ex) {
            //Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    
    
    
    
}
