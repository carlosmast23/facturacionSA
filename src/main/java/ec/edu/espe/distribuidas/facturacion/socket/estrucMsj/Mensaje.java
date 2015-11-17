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
public class Mensaje 
{    
    public static final String ORIGINADOR="carlosmast";
    protected Cabecera cabecera;
    protected Cuerpo cuerpo;

    public Mensaje(Cabecera cabecera, Cuerpo cuerpo) {
        this.cabecera = cabecera;
        this.cuerpo = cuerpo;
    }
    
      
    public Mensaje(String tipoMensaje,String originador) 
    {
        cabecera=new Cabecera(tipoMensaje,originador);        
    }
    
    

    public Cabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }

    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(Cuerpo cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    public String asTexto()
    {
        completarMensaje();
        return cabecera.asTexto()+cuerpo.asTexto();
    }
    
    private void completarMensaje()
    {
        cabecera.setIdMensaje(((CuerpoInterface)cuerpo).getIdMensaje());
        cabecera.setLongitudCuerpo(cuerpo.asTexto().length()+"");
        cabecera.setVerificacion(DigestUtils.md5Hex(cabecera.asTexto()));
    }

  
    
}
