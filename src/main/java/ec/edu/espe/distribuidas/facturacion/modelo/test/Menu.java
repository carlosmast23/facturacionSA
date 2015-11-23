/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.test;

import ec.edu.espe.distribuidas.facturacion.modelo.dao.ClienteFacade;
import ec.edu.espe.distribuidas.facturacion.modelo.dao.UsuarioFacade;
import ec.edu.espe.distribuidas.facturacion.modelo.entity.Cliente;
import ec.edu.espe.distribuidas.facturacion.modelo.entity.Usuario;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ValidadorFormato;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Carlos
 */
public class Menu {
    public static void main(String[] args)
    {
        UsuarioFacade facade=new UsuarioFacade();
       // Usuario usuario=facade.findByPrimaryKey("juan");
        
        //ClienteFacade facade2=new ClienteFacade();
       
        //Usuario usuario2=new Usuario("pepe","1234");
        //facade.insert(usuario2);
                
        List<Usuario> lista=facade.findAll();
        
        for (Usuario lista1 : lista) {
            System.out.println(lista1);
        }
        //System.err.println(usuario.getClave());
       // Usuario usuario=new Usuario("henry","distri");
        
       // facade.insert(usuario);        
        
    }
}
