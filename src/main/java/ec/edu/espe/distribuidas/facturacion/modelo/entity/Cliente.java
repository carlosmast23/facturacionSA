/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.entity;

import ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo.AbstractMapeo;
import ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo.Columna;
import ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo.Lista;
import ec.edu.espe.distribuidas.facturacion.modelo.dao.ClienteFacade;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRsCodificar;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Carlos
 */
public class Cliente extends AbstractMapeo implements MensajeRsCodificar{
    private String valorDocumento;
    private String tipoDocumento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String numeroTelefonico;
    private String numeroMovil;
    private String correElectronico;
    private Date fechaNacimiento;

    public Cliente() {
    }

    public String getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(String valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public String getCorreElectronico() {
        return correElectronico;
    }

    public void setCorreElectronico(String correElectronico) {
        this.correElectronico = correElectronico;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    @Override
    public void setMapeo() {
        mapeo.setNombreTabla("cliente");
        mapeo.addColumna(new Columna("valor_documento",getField("valorDocumento"),"pk"));
        mapeo.addColumna(new Columna("tipo_documento",getField("tipoDocumento"),""));
        mapeo.addColumna(new Columna("nombre",getField("nombre"),""));
        mapeo.addColumna(new Columna("apellido",getField("apellido"),""));
        mapeo.addColumna(new Columna("direccion",getField("direccion"),""));
        mapeo.addColumna(new Columna("numero_telefonico",getField("numeroTelefonico"),""));
        mapeo.addColumna(new Columna("numero_movil",getField("numeroMovil"),""));
        mapeo.addColumna(new Columna("correo_electronico",getField("correElectronico"),""));
        mapeo.addColumna(new Columna("fecha_nacimiento",getField("fechaNacimiento"),""));
        
        /////////////mapeo para los arreglos ///////////////////////
      
        
    }

    @Override
    public Class getDao() {
        //return EmpresaFacade.class;
        return ClienteFacade.class;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.valorDocumento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.valorDocumento, other.valorDocumento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "valorDocumento=" + valorDocumento + ", tipoDocumento=" + tipoDocumento + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", numeroTelefonico=" + numeroTelefonico + ", numeroMovil=" + numeroMovil + ", correElectronico=" + correElectronico + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    @Override
    public String asTexto(String c) 
    {
        StringBuilder sb=new StringBuilder();
        sb.append(tipoDocumento);sb.append(c);
        sb.append(valorDocumento);sb.append(c);
        sb.append(nombre);sb.append(c);
        sb.append(apellido);sb.append(c);
        sb.append(direccion);sb.append(c);
        sb.append(numeroTelefonico);sb.append(c);
        sb.append(numeroMovil);sb.append(c);
        sb.append(correElectronico);sb.append(c);
        sb.append(fechaNacimiento);sb.append(c);
        return sb.toString();
        
    }
    
}
