/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.entity;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRsCodificar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Cuenta implements MensajeRsCodificar
{
    private String numeroCuenta;
    private String tipoCuenta;
    private float saldoActual;
    private String fechaHora;

    public Cuenta(String numeroCuenta, String tipoCuenta, float saldoActual) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoActual = saldoActual;
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        this.fechaHora=df.format(new Date()).toString();
        
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public float getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(float saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String asTexto(String limitador) {
        
        StringBuilder sb=new StringBuilder();
        sb.append(numeroCuenta);sb.append(limitador);
        sb.append(tipoCuenta);sb.append(limitador);
        sb.append(saldoActual);sb.append(limitador);
        sb.append(fechaHora);
        return sb.toString();
    }
    
    
    
    
}
