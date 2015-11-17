/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.servicio;

import ec.edu.espe.distribuidas.facturacion.modelo.dao.ClienteFacade;
import ec.edu.espe.distribuidas.facturacion.modelo.entity.Cliente;

/**
 *
 * @author Carlos
 */
public class ClienteServicio 
{
    private ClienteFacade facade;

    public ClienteServicio() 
    {
        this.facade=new ClienteFacade();
    }
    
    public Cliente obtnerCliente(String tipoDocumento,String valor)
    {
        return facade.findByPrimaryKey(valor);
    }
    
    
}
