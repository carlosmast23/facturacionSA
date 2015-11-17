/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *Clase que permite realizar el mapeo de los obejtos con la base de datos
 * 
 * esta clase nos permitira establecer referencias de nombres a los objetos
 * y tablas de la base de datos
 * 
 * @author Carlos
 */
public class Mapeo 
{
    private String nombreTabla;
    private ArrayList<Columna> columnas;
    private List<Lista> arrays;
    /**
     * Variable que representa el tipo de clave de la entidad
     * pueden ser:
     * pk=primary key
     * fk=foraning key
     */
    private String typekey;

    public Mapeo() 
    {
        columnas=new ArrayList<Columna>();
        arrays=new LinkedList<Lista>();
    }
    
    /**
     * Agregar columna de mapeo
     * @param columna objeto para agregar a la lista
     */
    
    public Columna getColumaPk()
    {
        for (Columna columna : columnas) 
        {
            if(columna.getTypekey().equals("pk"))
            {
                return columna;
            }
        }
        return null;
    }
    
    /**
     * Agrega un objeto de tipo array que representa los valores necesarios
     * para realizar la carga de datos relacionados con otra tabla
     * @param array 
     */
    public void addArray(Lista array)
    {
        this.arrays.add(array);
    }
    
    /**
     * Agrega la informacion para el mapeo de los campos con la db 
     * @param columna 
     */
    public void addColumna(Columna columna)
    {
        this.columnas.add(columna);
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public ArrayList<Columna> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<Columna> columnas) {
        this.columnas = columnas;
    }

    public String getTypekey() {
        return typekey;
    }

    public void setTypekey(String typekey) {
        this.typekey = typekey;
    }

    public List<Lista> getArrays() {
        return arrays;
    }
    
    
    
    
}
