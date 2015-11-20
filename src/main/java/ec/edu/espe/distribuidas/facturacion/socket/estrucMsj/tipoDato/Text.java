/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ValidadorFormato;

/**
 *
 * @author Carlos
 */
public class Text extends TipoDatoMensaje<String>
{
    private String texto;

    public Text(Integer longitud) 
    {
        this.longitud = longitud;
    }

    
    
    public Text(String texto, Integer longitud) 
    {
        this.texto = texto;
        this.longitud = longitud;
    }

    @Override
    public String getDato() {
        return texto.substring(0,longitud).trim();
    }

    @Override
    public void setDato(String dato) {
        texto=dato;
    }

    @Override
    public String asTexto() 
    {
        if(texto.length()>longitud)
        {
            texto=texto.substring(0,longitud);
        }
        
        return ValidadorFormato.completarEspaciosDerecha(texto, longitud);
    }
    
}
