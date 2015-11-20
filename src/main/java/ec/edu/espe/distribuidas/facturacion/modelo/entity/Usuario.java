/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.entity;

import ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo.AbstractMapeo;
import ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo.Columna;
import ec.edu.espe.distribuidas.facturacion.modelo.dao.UsuarioFacade;
import java.util.Objects;

/**
 *
 * @author Carlos
 */
public class Usuario extends AbstractMapeo
{
    private String nick;
    private String clave;

    public Usuario() {
    }

    
    
    public Usuario(String nick, String clave) {
        this.nick = nick;
        this.clave = clave;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nick);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nick, other.nick)) {
            return false;
        }
        return true;
    }

    @Override
    public void setMapeo() {
        mapeo.setNombreTabla("usuario");
        mapeo.addColumna(new Columna("nick",getField("nick"),"pk"));
        mapeo.addColumna(new Columna("clave",getField("clave"),""));
    }

    @Override
    public Class getDao() 
    {
        return UsuarioFacade.class;
    }
    
    
    
}
