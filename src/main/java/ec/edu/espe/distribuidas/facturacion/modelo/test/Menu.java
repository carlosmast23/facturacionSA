/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.test;

import ec.edu.espe.distribuidas.facturacion.modelo.dao.ClienteFacade;
import ec.edu.espe.distribuidas.facturacion.modelo.entity.Cliente;
import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ValidadorFormato;

/**
 *
 * @author Carlos
 */
public class Menu {
    public static void main(String[] args)
    {
        //ClienteFacade facade=new ClienteFacade();
        //Cliente cliente=facade.findByPrimaryKey("1724218951");
        //System.out.println(cliente);
        System.out.println(ValidadorFormato.fomatoEntero("00001234"));
    }
}
