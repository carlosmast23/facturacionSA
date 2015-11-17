/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.ValidadorFormato;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Carlos
 */
public class Dec extends TipoDatoMensaje<Float>
{
    private String txtDecimal;
    private Integer enteros;
    private Integer decimal;

    public Dec(String txtDecimal, Integer enteros, Integer decimal) {
        this.txtDecimal = txtDecimal;
        this.enteros = enteros;
        this.decimal = decimal;
        this.longitud=this.enteros+this.decimal;
    }
    
    public Dec(Float numero, Integer enteros, Integer decimal) {
        this.txtDecimal = numero.toString();
        this.enteros = enteros;
        this.decimal = decimal;
        this.longitud=this.enteros+this.decimal;
    }

    public Dec(Integer enteros, Integer decimal) {
        this.enteros = enteros;
        this.decimal = decimal;
        this.longitud=enteros+decimal;
    }

    
    
    @Override
    public Float getDato() {
        
        String enteroTxt=txtDecimal.substring(0,enteros);
        String decimalTxt=txtDecimal.substring(enteros,enteros+decimal);
        return Float.parseFloat(enteroTxt+"."+decimalTxt);
       
    }

    @Override
    public void setDato(String dato) 
    {
        txtDecimal=dato;
    }

    @Override
    public String asTexto() 
    {
        //String enteroTxt=StringUtils.splitByWholeSeparator(txtDecimal,".")[0];
        //String decimalTxt=StringUtils.splitByWholeSeparator(txtDecimal,".")[1];
        return ValidadorFormato.completarFloat(txtDecimal, enteros,decimal);
        //return enteroTxt+decimalTxt;
    }
    
    
    
}
