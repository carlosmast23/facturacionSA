/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.dao;

import ec.edu.espe.distribuidas.facturacion.modelo.entity.Cliente;

/**
 *
 * @author Carlos
 */
public class ClienteFacade extends AbstractFacade<Cliente>
{
    public ClienteFacade() 
    {
        super(Cliente.class);
    }    
}
