/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato;

import ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.MensajeRsCodificar;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Carlos
 */
public class TextV extends TipoDatoMensaje<String[]>
{
    private List<String> datos;
    private static final String limitador="|";
    private String trama;

    public TextV(String trama) {
        this.trama = trama;
    }
    
    
    
    public TextV() 
    {
        datos=new LinkedList<>();
    }
    
    public void agregarDato(String dato)
    {
        datos.add(dato);
    }

    @Override
    public String[] getDato() 
    {
        return StringUtils.splitByWholeSeparator(trama,limitador);
    }

    @Override
    public void setDato(String dato) {
        trama=dato;
    }

    @Override
    public String asTexto() {
        return "";
    }
    
    
}
