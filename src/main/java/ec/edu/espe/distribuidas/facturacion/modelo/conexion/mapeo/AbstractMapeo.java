/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public abstract class AbstractMapeo 
{
    public abstract void setMapeo();
    public abstract Class getDao();
    protected Mapeo mapeo;

    public AbstractMapeo() 
    {
        this.mapeo = new Mapeo();
        //setMapeo();
    }

    public Mapeo getMapeo() {
        return mapeo;
    }
    
    /**
     * Obtiene una objeto que representa el atributo de la clase
     * 
     * @param name nombre del atributo de la clase para relacionar con el nombre de la tabla
     * @return Field
     */
    
    public Field getField(String name)
    {
        try {
            Class clase=this.getClass();
            Field []atributos=clase.getDeclaredFields();
            for (Field atributo : atributos) {
                if(atributo.getName().equals(name))
                {
                    return atributo;
                }
            }
        } catch (SecurityException ex) {
            Logger.getLogger(AbstractMapeo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
}
