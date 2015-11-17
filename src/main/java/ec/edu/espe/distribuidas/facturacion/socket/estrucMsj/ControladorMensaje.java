/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato.TipoDatoMensaje;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.ClienteMsjRS;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.ClienteMsjRespuesta;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.ListadoClienteRS;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.ListadoClienteRespuesta;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.LoginRS;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.RetiroRS;
import ec.edu.espe.distribuidas.facturacion.socket.mensajes.TransaccionRS;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Carlos
 */
public class ControladorMensaje 
{
    private static final int tamanioCabecera=85;
    
    private List<CuerpoRS> listaRS;
    private List<CuerpoRespuesta> listaRespuestas;

    public ControladorMensaje() 
    {
        this.listaRS=new LinkedList<>();
        this.listaRespuestas=new LinkedList<>();
        mensajesDefault();
    }            
    
    /**
     * Metodo que se encarga de gestionar la respuesta de una peticion
     * @param txt
     * @return 
     */
    
    public MensajeRS ejecutarMensaje(String txt)
    {
        String txtCabecera=txt.substring(0,tamanioCabecera);
        String txtCuerpo=txt.substring(tamanioCabecera);
        
        Cabecera cabecera=getCabecera(txtCabecera);        
        CuerpoRS cuerpoRS=findCuerpoRs(cabecera.getIdMensaje());
        cuerpoRS.definirEstructura();
        cuerpoRS.construirAtributos(txtCuerpo);
        //cuerpoRS.ejecutar();
        
                
        
        return responderMsj(cabecera);
    }
    
    /**
     * Envia un trama respuesta para procesar el mensaje y tener
     * la estructura como objeto de tipo mensaje
     * @param trama
     * @return 
     */
    public Mensaje construirMensaje(String trama)
    {
        String txtCabecera=trama.substring(0,tamanioCabecera);
        String txtCuerpo=trama.substring(tamanioCabecera);
        
        Cabecera cabecera=getCabecera(txtCabecera);   
        CuerpoRespuesta respuesta=findCuerpoRespuesta(cabecera.getIdMensaje());
        respuesta.definirEstructura();
        respuesta.construirAtributos(txtCuerpo);
        Mensaje msjRespuesta=new Mensaje(cabecera, respuesta);
        return msjRespuesta;
        
    }
    
    /**
     * Busca un objeto que contenga la definicion para obtener la respuesta
     * en ese contenedor del cuerpo
     * @param id
     * @return 
     */
    private CuerpoRespuesta findCuerpoRespuesta(String id)
    {
        for (CuerpoRespuesta respuesta : listaRespuestas) 
        {
            if(respuesta.getIdMensaje().equals(id))
            {
                return respuesta;
            }
        }
        return null;
    }
    
    private MensajeRS responderMsj(Cabecera cabeceraRQ)
    {
        MensajeRS mensajeRS=new MensajeRS();
        
        CuerpoRS cuerpoRs=findCuerpoRs(cabeceraRQ.getIdMensaje());
        cuerpoRs.ejecutar();
        mensajeRS.setCuerpo(cuerpoRs);
       return mensajeRS;
    }
    
    private CuerpoRS findCuerpoRs(String idMensaje)
    {
        for (CuerpoRS rs : listaRS) 
        {
            //System.err.println(rs.getIdMensaje());
            if(rs.getIdMensaje().equals(idMensaje))
            {
                return rs;
            }
        }
        return null;
    }
    
    /**
     * Obtiene un objeto de tipo Cuerpo enviado un texto
     * @param txtCuerpo
     * @return 
     */
    
    
    /**
     * Genera un objeto tipo cabezera enviando una cadena de texto
     * @param txtCabecera 
     * @return 
     */
    private Cabecera getCabecera(String txtCabecera)
    {
        String param;
        Cabecera cabezera=new Cabecera();
        //tipo mensaje
        param=txtCabecera.substring(0,2);
        txtCabecera=txtCabecera.substring(2);
        cabezera.setTipoMensaje(ValidadorFormato.quitarEspaciosBlanco(param));
        //originador
        param=txtCabecera.substring(0,20);
        txtCabecera=txtCabecera.substring(20);
        cabezera.setOriginador(ValidadorFormato.quitarEspaciosBlanco(param));
        //fecha
        param=txtCabecera.substring(0,17);
        txtCabecera=txtCabecera.substring(17);
        cabezera.setFecha(param);
        //id_mensaje
        param=txtCabecera.substring(0,10);
        txtCabecera=txtCabecera.substring(10);
        cabezera.setIdMensaje(ValidadorFormato.quitarEspaciosBlanco(param));
        
        //longituCuerpo
        param=txtCabecera.substring(0,4);
        txtCabecera=txtCabecera.substring(4);
        cabezera.setLongitudCuerpo(ValidadorFormato.fomatoEntero(param));
        
        //verificacion
        param=txtCabecera.substring(0,32);
        txtCabecera=txtCabecera.substring(32);
        cabezera.setVerificacion(param);
        
        return cabezera;
        
   }
    
    /**
     * Agrega mensaje para responder segun la peticion
     * @param mensajeRS 
     */
    public void agregarCuerpoRS(CuerpoRS cuerpoRS)
    {
        this.listaRS.add(cuerpoRS);
    }
    
    private void mensajesDefault()
    {
        this.agregarCuerpoRS(new ClienteMsjRS());
        this.agregarCuerpoRS(new LoginRS());
        this.agregarCuerpoRS(new ListadoClienteRS());
        this.agregarCuerpoRS(new TransaccionRS());
        this.agregarCuerpoRS(new RetiroRS());
        //
        
        this.listaRespuestas.add(new ClienteMsjRespuesta());
        this.listaRespuestas.add(new ListadoClienteRespuesta());
    }
    
    
}
