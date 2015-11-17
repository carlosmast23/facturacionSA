/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Carlos
 */
public class MensajeRQ extends Mensaje
{
    private static final String TIPO_MENSAJE="RQ";
    
    public MensajeRQ() 
    {
        super(TIPO_MENSAJE,ORIGINADOR);
    }

    public MensajeRQ(Cabecera cabecera, Cuerpo cuerpo) 
    {
        super(cabecera,cuerpo);
    }
    
    public MensajeRQ(Cuerpo cuerpo) 
    {
        super(TIPO_MENSAJE,ORIGINADOR);
        setCuerpo(cuerpo);
    }

    @Override
    public String asTexto() 
    {   
        cuerpo.limpiar();
        ((CuerpoRQ)cuerpo).ejecutar();
        return super.asTexto(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
