/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.facturacion.modelo.conexion.mapeo;

import java.util.List;

/**
 *
 * @author Carlos
 */
public class Lista<T> 
{
    /**
     * Variable que especifica el nombre de la tabla de la relacion
     */
    private String tablaBusqueda;
    
    /**
     * Nombre de la pk mediante la cual se va a filtrar los datos
     */
    private String keyNameFilter;
    
    
    /**
     * Nombre del campo pk, mediante el cual se va a obtner el resultado
     */
    private String keyNameResult;
    
    /**
     * Lista del tipo de dato que se va a obtener el resultado
     */
    
    private  List<T> lista;
    
    /**
     * Objeto que representa la clase del tipo de dato que se necesita el resutado
     */
    private Class<T> clase;

    public Lista(String tablaBusqueda, String keyNameFilter, String keyNameResult, List<T> lista, Class<T> clase) {
        this.tablaBusqueda = tablaBusqueda;
        this.keyNameFilter = keyNameFilter;
        this.keyNameResult = keyNameResult;
        this.lista = lista;
        this.clase = clase;
    }

    

    public String getTablaBusqueda() {
        return tablaBusqueda;
    }

    public void setTablaBusqueda(String tablaBusqueda) {
        this.tablaBusqueda = tablaBusqueda;
    }

    public String getKeyNameFilter() {
        return keyNameFilter;
    }

    public void setKeyNameFilter(String keyNameFilter) {
        this.keyNameFilter = keyNameFilter;
    }

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public Class<T> getClase() {
        return clase;
    }

    public void setClase(Class<T> clase) {
        this.clase = clase;
    }

    public String getKeyNameResult() {
        return keyNameResult;
    }

    public void setKeyNameResult(String keyNameResult) {
        this.keyNameResult = keyNameResult;
    }


    public void copyList(T[] lista)
    {
        for (T lista1 : lista) {
            this.lista.add(lista1);
        }
    }
    
    public void copyObj(T obj)
    {
        
            this.lista.add(obj);
        
    }
    
    
}
