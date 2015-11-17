/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Carlos
 */
public class ValidadorFormato 
{
    public static String completarEspaciosIzquierda(String cadena,int tamanio)
    {
        return StringUtils.leftPad(cadena, tamanio);
    }
    
    public static String completarEspaciosIzquierda(String cadena,int tamanio,String caracter)
    {
        return StringUtils.leftPad(cadena, tamanio,caracter);
    }
    
    public static String completarEspaciosDerecha(String cadena,int tamanio)
    {
        return StringUtils.rightPad(cadena, tamanio);
    }
    
    public static String completarEspaciosDerecha(String cadena,int tamanio,String caracter)
    {
        return StringUtils.rightPad(cadena, tamanio,caracter);
    }
    
    public static String completarFloat(float numero,int entero, int decimales)
    {
        String numeroTxt=numero+"";
        String enteroTxt=StringUtils.splitByWholeSeparator(numeroTxt,".")[0];
        String decimalTxt=StringUtils.splitByWholeSeparator(numeroTxt,".")[1];
        enteroTxt=StringUtils.leftPad(enteroTxt, entero,"0");
        decimalTxt=StringUtils.rightPad(enteroTxt, entero,"0");
        return enteroTxt+decimalTxt;
        
    }
    
        public static String completarFloat(String numero,int entero, int decimales)
    {
        String numeroTxt=numero+"";
        String enteroTxt=StringUtils.splitByWholeSeparator(numeroTxt,".")[0];
        String decimalTxt=StringUtils.splitByWholeSeparator(numeroTxt,".")[1];
        enteroTxt=StringUtils.leftPad(enteroTxt, entero,"0");
        decimalTxt=StringUtils.rightPad(decimalTxt,decimales,"0");
        return enteroTxt+decimalTxt;
        
    }
    
    public static String completarEntero(String numero,int longitud)
    {
        String numeroTxt=numero+"";
        String enteroTxt=StringUtils.splitByWholeSeparator(numeroTxt,".")[0];
        enteroTxt=StringUtils.leftPad(enteroTxt,longitud,"0");
        return enteroTxt;
        
    }
    
    public static String quitarEspaciosBlanco(String texto)
    {
        return StringUtils.trimToNull(texto);
    }
    
    public static String fomatoEntero(String numero)
    {
        Number number=Integer.parseInt(numero);
        return number.toString();
    }

}
