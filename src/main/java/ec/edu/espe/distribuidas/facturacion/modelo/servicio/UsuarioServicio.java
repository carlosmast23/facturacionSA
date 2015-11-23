/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.servicio;

import ec.edu.espe.distribuidas.facturacion.modelo.dao.ClienteFacade;
import ec.edu.espe.distribuidas.facturacion.modelo.dao.UsuarioFacade;
import ec.edu.espe.distribuidas.facturacion.modelo.entity.Cliente;
import ec.edu.espe.distribuidas.facturacion.modelo.entity.Usuario;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class UsuarioServicio 
{
    private UsuarioFacade facade;

    public UsuarioServicio() 
    {
        this.facade=new UsuarioFacade();
    }
       
    
    public boolean login(String nick,String clave)
    {        
        
        Usuario usuario=facade.findByPrimaryKey(nick);
        if(usuario.getClave().equals(clave))
        {
            return true;
        }
        return false;
       
    }
    
    public List<Usuario> obtenerTodos()
    {
        List<Usuario> todos=facade.findAll();
        return todos;
    }
    
    public void insertar(Usuario usuario)
    {
        facade.insert(usuario);
    }
        
}   
