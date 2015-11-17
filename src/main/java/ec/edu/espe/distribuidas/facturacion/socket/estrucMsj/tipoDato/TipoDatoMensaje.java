/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.socket.estrucMsj.tipoDato;

/**
 *
 * @author Carlos
 */
public abstract class TipoDatoMensaje <T>
{
    public abstract T getDato();
    public abstract void setDato(String dato);
    public abstract String asTexto();
    
    protected int longitud;
    public T cast( Object o)
    {
        return (T) o;
    }

    public int getLongitud() {
        return longitud;
    }
    
    
}
