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
public class Ent extends TipoDatoMensaje<Integer>
{   
    private String txtEntero;
     
    public Ent(String txtEntero, Integer longitud) {
        this.txtEntero = txtEntero;
        this.longitud = longitud;
    }
    
    public Ent(Integer entero, Integer longitud) {
        this.txtEntero = entero.toString();
        this.longitud = longitud;
    }

    public Ent(Integer longitud) {
        this.longitud = longitud;
    }

    
    
    @Override
    public Integer getDato() 
    {
        return Integer.parseInt(txtEntero);
    }

    
    @Override
    public void setDato(String dato) {
        txtEntero=dato;
    }

    @Override
    public String asTexto() {
        if(txtEntero.length()>longitud)
        {
            txtEntero=txtEntero.substring(0,longitud);
        }
        return ValidadorFormato.completarEspaciosIzquierda(txtEntero,longitud,"0");
    }
    
}
