/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Cabecera 
{
    public static final int tamanioCabecera=85;
    
    private String tipoMensaje;
    private String originador;
    private String fecha;
    private String idMensaje;
    private String longitudCuerpo;
    private String verificacion;

    public Cabecera() 
    {
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        this.fecha=df.format(new Date());
    }

    
    
    public Cabecera(String tipoMensaje, String originador) 
    {
        //this.idMensaje=idMensaje;
        this.tipoMensaje = tipoMensaje;
        this.originador = originador;
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        this.fecha=df.format(new Date());
    }   

    public String getTipoMensaje() {
       return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getOriginador() {
        return originador;
    }

    public void setOriginador(String originador) {
        this.originador = originador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(String idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getLongitudCuerpo() {
        return longitudCuerpo;
    }

    public void setLongitudCuerpo(String longitudCuerpo) {
        this.longitudCuerpo = longitudCuerpo;
    }

    public String getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(String verificacion) {
        this.verificacion = verificacion;
    }
    
    public String asTexto()
    {
        validarFormatoMensaje();
        StringBuilder sb=new StringBuilder();
        sb.append(tipoMensaje);
        sb.append(originador);
        sb.append(fecha);
        sb.append(idMensaje);
        sb.append(longitudCuerpo);
        sb.append(verificacion);
        return sb.toString();
    }
    
    private void validarFormatoMensaje()
    {
        tipoMensaje=ValidadorFormato.completarEspaciosDerecha(tipoMensaje,2);
        originador=ValidadorFormato.completarEspaciosDerecha(originador,20);
        idMensaje=ValidadorFormato.completarEspaciosDerecha(idMensaje,10);
        longitudCuerpo=ValidadorFormato.completarEntero(longitudCuerpo,4);
    }
    

}
