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
public class MensajeRS extends Mensaje
{
     private static final String TIPO_MENSAJE="RS";

    public MensajeRS() 
    {
        super(TIPO_MENSAJE,ORIGINADOR);
    }

    @Override
    public String asTexto() 
    {
        //cuerpo.limpiar();
        cabecera.setIdMensaje(((CuerpoRS)cuerpo).getIdMensaje());
        return super.asTexto();
    }    
    
}
