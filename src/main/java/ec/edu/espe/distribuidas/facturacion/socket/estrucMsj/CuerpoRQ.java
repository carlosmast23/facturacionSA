/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj;

/**
 *
 * @author Carlos
 */
public abstract class CuerpoRQ extends Cuerpo implements CuerpoInterface
{    
    public abstract void ejecutar(); 
    
}
