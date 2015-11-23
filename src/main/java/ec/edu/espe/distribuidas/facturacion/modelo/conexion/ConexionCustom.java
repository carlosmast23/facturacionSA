/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.conexion;

import ec.edu.espe.distribuidas.facturacion.exceptions.ExcepcionSocketDesconectado;
import ec.edu.espe.distribuidas.facturacion.socket.cliente.SocketCliente;
import ec.edu.espe.distribuidas.facturacion.socket.cliente.SocketControladorCliente;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ControladorMensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.Mensaje;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRQ;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRS;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TextV;
import ec.edu.espe.distribuidas.facturacion.socket.mensajesDB.SqlDDLRQ;
import ec.edu.espe.distribuidas.facturacion.socket.mensajesDB.SqlDMLRQ;
import ec.edu.espe.distribuidas.facturacion.socket.servidor.SocketControladorServidor;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ConexionCustom implements InterfaceConexion
{
    private String host;
    private String db;
    private int puerto;
    private SocketControladorCliente socketCliente;

    public ConexionCustom(String host, String db, int puerto) 
    {
        this.host = host;
        this.db = db;
        this.puerto = puerto;
        this.socketCliente=new SocketControladorCliente(host,puerto);
        conectar();
    }
    
    
    @Override
    public int ejecutarQuery(String consulta) 
    {
        try {
            MensajeRQ mensajeRQ=new MensajeRQ();
            SqlDDLRQ cuerpo=new SqlDDLRQ(consulta);
            mensajeRQ.setCuerpo(cuerpo);
                        
            Mensaje msj=socketCliente.enviarMensaje(mensajeRQ);
            
            String respuesta=(String) msj.getCuerpo().getAtributos("respuesta").getDato();
            
        } catch (ExcepcionSocketDesconectado ex) {
            Logger.getLogger(ConexionCustom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    @Override
    public ResultSet ejecutarConsulta(String consulta) 
    {
        MensajeRQ mensajeRQ=new MensajeRQ();
        SqlDMLRQ cuerpo=new SqlDMLRQ(consulta);
        mensajeRQ.setCuerpo(cuerpo);
        
        try {
            Mensaje respuesta=socketCliente.enviarMensaje(mensajeRQ);
            int numColumnas=(int) respuesta.getCuerpo().getAtributos("numColumnas").getDato();
            TextV textv= (TextV) respuesta.getCuerpo().getAtributos("datos").getDato();
            
            ResultCustom rs=new ResultCustom();
            for (int i = 0; i < textv.sizeGrupos(); i++) 
            {
                List<String> lista=textv.getGrupo(i);
                if(i==0)
                {
                    //agrega la estructura de los nombres de columna
                    rs.agregarColumnas(lista);
                }
                else
                {
                    //agrega la estructura de los datos
                    rs.agregarFila(lista);
                }
            }

            return rs;
        } catch (ExcepcionSocketDesconectado ex) {
            Logger.getLogger(ConexionCustom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private void conectar()
    {
        this.socketCliente.crearNuevaConexion();
    }
    
    
}
