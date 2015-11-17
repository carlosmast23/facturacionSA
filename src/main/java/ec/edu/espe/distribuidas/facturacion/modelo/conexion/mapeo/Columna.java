/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo;

import java.lang.reflect.Field;

/**
 *
 * @author Carlos
 */
public class Columna {
    private String name;
    private Field refAtributo;
    /**
     * Variable que representa el tipo de clave de la entidad pueden ser:
     * pk=primary key fk=foraning key
     */
    private String typekey;


    public Columna(String name,Field refAtributo,String typeKey) {
        this.name = name;
        this.refAtributo = refAtributo;
        this.typekey=typeKey;
    }

    
    
    public String getName() {
        return name;
    }

    public Field getRefAtributo() {
        return refAtributo;
    }
    
    /**
     * Devuelve el tipo de clave
     * ejemplo: pk,fk;
     * @return 
     */
    public String getTypekey() {
        return typekey;
    }

    public void setTypekey(String typekey) {
        this.typekey = typekey;
    }

    public void setRefAtributo(Field refAtributo) {
        this.refAtributo = refAtributo;
    }
    
    
    
}
