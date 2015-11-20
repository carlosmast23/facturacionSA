/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.servidor;


import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.Cabecera;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ControladorMensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRS;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.CuerpoRespuesta;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRS;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.LoginRS;
import ec.edu.espe.distribuidas.facturacion.vista.socket.InterfaceVistaComunicacion;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class SocketComunicacion implements Runnable
{
   
    private Socket sc;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private Thread hilo; //me permite realizar un hilo para realizar una escucha permanente
    private boolean condicionHilo;
    public static final String TEXTO_SALIR="EXIT";
    public static final String CODIGO_LOGIN="AUTENTIC01";
    public static final String CODIGO_LOGOUT="LOGOUT0001";
    
    private InterfaceVistaComunicacion interfaceComunicacion;
    /***
     * Areglo que me permite saber cuantos usuarios
     * estan conectados con el servidor de aplicacione
     */
    private ArrayList<SocketComunicacion> listaConexiones;
    
    /**
     * EL controlador del mensaje
     */
    private ControladorMensaje controladorMensajes;
    
        /***
     * Mensaje que me permite establecer saber si estoy logueado o no
     */
    private boolean logueado;

        /**
     * Cuerpo principal mediante el cual va a iniciar sesion para conectarme
     * o desconectarme
     */
    private CuerpoRS cuerpoIngreso;
    

    
    public SocketComunicacion(Socket sc,ArrayList<SocketComunicacion> listaConexiones) 
    {
        this.sc=sc;
        this.listaConexiones=listaConexiones;
        this.controladorMensajes=new ControladorMensaje();
        this.logueado=false;
        this.cuerpoIngreso=controladorMensajes.getMensajeLogin();
        conectar();
        
    }
    
    public void escuchar()
    {
        hilo=new Thread(this);
        condicionHilo=true;
        hilo.start();
    }
    

    public void conectar()
    {
        try {
            
            //System.out.println("conexion establecida");
            entrada=new DataInputStream(sc.getInputStream());
            salida=new DataOutputStream(sc.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(SocketComunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconectar()
    {
        try {
            condicionHilo=false;
            entrada.close();
            salida.close();
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketComunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String leer() throws IOException
    {
        
            return entrada.readUTF();
        
    }
    
    public void salida(String mensaje)
    {
        try {
            salida.writeUTF(mensaje);
           // addMensajeConsola("RSP: "+mensaje);
        } catch (IOException ex) {
            Logger.getLogger(SocketComunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getDireccion()
    {
        return this.sc.getLocalAddress().toString();
    }

    @Override
    public void run() 
    {
        while(condicionHilo)
        {
            try
            {
                String mensaje=this.leer();
                addMensajeConsola("Peticion:"+mensaje.toString());
                //System.out.println("mensaje: "+entrada);
                
                /// comprobar si el controlador se encuentra logeado
                if (!logueado) 
                {
                    Cabecera cabecera=controladorMensajes.getCabeceraTrama(mensaje);
                    if(cabecera.getIdMensaje().equals(CODIGO_LOGIN))
                    {
                        MensajeRS rsp = controladorMensajes.ejecutarMensaje(mensaje);
                        if(rsp.getCuerpo().getAtributo(0).equals(TEXTO_SALIR))
                        {
                            salir();
                        }
                        else
                        {
                             //cuando el logueo es correcto
                            this.logueado=true;
                            this.salida(rsp.asTexto());
                            addMensajeConsola("Nuevo cliente logueado");
                            
                        }
                        
                    }
                    else
                    {
                        salir();
                    }
                } 
                else 
                {
                    Cabecera cabecera=controladorMensajes.getCabeceraTrama(mensaje);
                    if(cabecera.getIdMensaje().equals(CODIGO_LOGOUT))
                    {
                        MensajeRS rsp = controladorMensajes.ejecutarMensaje(mensaje);
                        if(rsp.getCuerpo().getAtributo(0).equals(TEXTO_SALIR))
                        {
                            salir();
                        }
                        else
                        {
                            this.salida(rsp.asTexto());
                            addMensajeConsola("RSP=>"+rsp.getCabecera().getIdMensaje()+" ("+rsp.asTexto()+")");
 
                        }
                        
                    }
                    else
                    {
                        MensajeRS rsp = controladorMensajes.ejecutarMensaje(mensaje);
                        this.salida(rsp.asTexto());
                        addMensajeConsola("RSP=>"+rsp.getCabecera().getIdMensaje()+" ("+rsp.asTexto()+")");                        
                    }
                }
                
            }
            catch(Exception e)
            {
                eliminarLista();
                addMensajeConsola("El usuario abandono la conexion");   
                actualizarListaVista();
                break;
            }
        }
    }
    
    private void salir()
    {
        this.logueado = false;
        this.condicionHilo = false;
        this.listaConexiones.remove(this);
        this.salida(TEXTO_SALIR);
        addMensajeConsola("Logueo de usuario rechasado");
        
    }
    
    private void eliminarLista()
    {
        listaConexiones.remove(this);
        
    }
    
        /**
     * Metodo que verifica que el mensaje de logueado y la ejcucion
     * establesca el logueo para pode accerder a los otros servicios
     * del servidor de aplicaciones
     * 
     * @param txt trama del mensaje de peticion
     * @return 
     */

    public boolean isLogueado() {
        return logueado;
    }

    @Override
    public String toString() {
        return this.getDireccion()+":"+this.sc.getPort();
    }

    public void setInterfaceComunicacion(InterfaceVistaComunicacion interfaceComunicacion) {
        this.interfaceComunicacion = interfaceComunicacion;
    }    
   
    private void addMensajeConsola(String mensaje)
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

}
