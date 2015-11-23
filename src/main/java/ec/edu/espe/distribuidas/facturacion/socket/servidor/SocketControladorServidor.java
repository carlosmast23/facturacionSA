/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.servidor;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ControladorMensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRS;
import ec.edu.espe.distribuidas.facturacion.vista.socket.InterfaceVistaComunicacion;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *Clase que gestiona las nuevas conexiones al servidor
 * @author Carlos
 */
public class SocketControladorServidor implements Runnable
{
     
    private SocketServidor socketServidor;
    private Thread hiloConexiones;
    private boolean estadoHilo;
    private String mensajeConsola;
    private ArrayList<SocketComunicacion> listaConexiones;
    private ControladorMensaje controladorMensaje;
    
  //  private InterfaceConsola interfazConsola;
    
    private InterfaceVistaComunicacion interfaceComunicacion;

    public SocketControladorServidor(int puerto) 
    {
        //this.listaClientes=listaClientes;
        estadoHilo=true;
        this.mensajeConsola="";
        this.listaConexiones=new ArrayList<SocketComunicacion>();
        hiloConexiones=new Thread(this);
        socketServidor=new SocketServidor(puerto);
        this.controladorMensaje=new ControladorMensaje();
    }
    
    
    /**
     * Activar el metodo para empezar a aceptar conexiones
     */   
    public void conectar()
    {
        hiloConexiones.start();
    }
    
    @Override
    public void run() {
        while(estadoHilo)
        {
            //obtener una conexion de tipo socket con el cliente
            addMensajeConsola("Esperando una nueva conexion ...");
            Socket socket=socketServidor.conectar();
            System.out.println("Puerto: "+socket.getPort());
            addMensajeConsola("!Nueva conexion establecida con el cliente!");
            SocketComunicacion sc=new SocketComunicacion(socket,listaConexiones);
            sc.setInterfaceComunicacion(interfaceComunicacion);
            sc.escuchar();
            listaConexiones.add(sc);
            actualizarListaVista();
        }
    }
    
    public void addMensajeConsola(String mensaje)
    {
        if(interfaceComunicacion!=null)
            interfaceComunicacion.mensajeConsola(mensaje);
    }
    
    public void actualizarListaVista()
    {
        if(interfaceComunicacion!=null)
        {
            interfaceComunicacion.actualizarLista(listaConexiones);
        }
    }

    public void setInterfaceComunicacion(InterfaceVistaComunicacion interfaceComunicacion) {
        this.interfaceComunicacion = interfaceComunicacion;
    }

    
    
    
}
