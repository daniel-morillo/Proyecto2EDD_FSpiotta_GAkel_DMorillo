/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * En esta clase se almacenan los nodos que componen a las listas, colas y pilas
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 * @param <T>
 */
public class Nodo<T> {
    
    private T elemento;
    private Nodo pNext;

    /**
     * Constructor de la clase Nodo
     * @param elemento Corresponde al valor del nodo
     * @param pNext Es el nodo que se ubica en la posición siguiente al nodo señalado
     */
    public Nodo(T elemento, Nodo pNext) {
        this.elemento = elemento;
        this.pNext = pNext;
    }
    
    /**
     * Constructor de la clase Nodo
     * @param elemento Corresponde al valor del nodo
     */
    public Nodo(T elemento) {
        this.elemento = elemento;
        this.pNext = null;
    }

    /**
     * Método que retorna el valor del Nodo (el elemento)
     * @return el valor del nodo
     */
    public T getElemento() {
        return elemento;
    }

    /**
     * Método qe establece el valor del nodo
     * @param elemento el valor que se le quiere dar a ese nodo
     */
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    /**
     * Devuelve el próximo nodo del cual se llama a este método
     * @return El siguiente nodo
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * Establece el siguiente nodo del nodo del cual se llama a este método
     * @param pNext Nodo que se quiere establecer como siguiente
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
        
}
