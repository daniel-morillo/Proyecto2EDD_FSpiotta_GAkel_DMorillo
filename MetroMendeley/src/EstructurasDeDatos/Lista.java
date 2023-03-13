/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Clases.Summary;


/**
 * Estra clase contiene las listas que serán de utilidad para todo el proyecto
 * @author Fabrizio Spiotta, Georgina Akel, Daniel Morillo
 * @param <T>
 */
public class Lista<T> {
    
    private Nodo pFirst;
    private Nodo pLast;
    private int size;
    
    /**
     * Constructor de la clase Lista
     */
    public Lista() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
        
    /**
     * Método que verifica si la lista está vacía
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Método que agrega un elemento al final de la lista
     * @param element elemento que quiere ser agregado
     */
    public void AppendAtTheEnd(T element) {
        Nodo pNew = new Nodo (element);
        if (!isEmpty()) {
            pLast.setpNext(pNew);
            pLast = pNew;
            size ++;
        } else {
        pLast = pNew;
        pFirst = pNew;
        size ++;
        }
    }
    
    /**
     * Método que agrega un elemento al principio de la lista
     * @param element elemento que quiere ser agregado
     */
    public void AppendAthTheBeginning(T element) {
        Nodo pNew = new Nodo(element);
        if (!isEmpty()) {
            pNew.setpNext(pFirst);
            pFirst = pNew;
            size ++;
        }else {
        pLast = pNew;
        pFirst = pNew;
        size ++;
        }
    }
    
    /**
     * Método que agrega un elemento en una posición dada, contando de izquierda a derecha
     * @param index posición en la que quiere agregarse el elemento
     * @param element elemento a ser agregado
     */
    public void AppendAtThePosition_LeftToRight(int index, T element) {
        if (!isEmpty()) {
            Nodo pNew = new Nodo(element);
            Nodo aux = this.getpFirst();
            for (int i = 1; i <= this.getSize(); i++) {
                if (i == index-1) {
                    pNew.setpNext(aux.getpNext());
                    aux.setpNext(pNew);
                }
                aux = aux.getpNext();
            }  
        }
    }
    
    public void AppendOrdenadoStrings(T element) {
        Nodo<Summary> pNew = new Nodo(element);
        if (!isEmpty()) {
            Nodo<Summary> aux = pFirst;
            for (int i = 0; i < size; i++) {
                if (aux.getElemento().getTitulo().compareToIgnoreCase(pNew.getElemento().getTitulo()) > 0) {
                    pNew.setpNext(pFirst);
                    pFirst = pNew;
                    break;
                }
                else if (aux.getElemento().getTitulo().compareToIgnoreCase(pNew.getElemento().getTitulo()) < 0 &&  aux.getpNext() == null) {
                    aux.setpNext(pNew);
                    pLast = pNew; 
                    break;
                }
                else if (aux.getElemento().getTitulo().compareToIgnoreCase(pNew.getElemento().getTitulo()) > 0 &&  aux.getpNext() == null) {
                    pFirst = pNew;
                    pNew.setpNext(aux);
                    break;
                }
                else if (aux.getElemento().getTitulo().compareToIgnoreCase(pNew.getElemento().getTitulo()) < 0 && String.class.cast(Summary.class.cast(aux.getpNext().getElemento()).getTitulo()).compareToIgnoreCase(pNew.getElemento().getTitulo()) > 0) {
                    pNew.setpNext(aux.getpNext());
                    aux.setpNext(pNew);
                    break;
                }
                aux = aux.getpNext();
            }
            size ++;
        } else {
        pFirst = pNew;
        pLast = pNew;
        size ++;
        }
    }
    
    /**
     * Método que elimina un elemento
     * @param element elemento que quiere ser eliminado
     */
    public void Delete(T element){
        if (!isEmpty()) {
            if (pFirst.getElemento() == element) {
                if (pFirst.getpNext() == null) {
                    pFirst = null;
                    pLast = null;
                } else {
                    pFirst = pFirst.getpNext();
                }
                size -=1;
            } else {
                Nodo aux = pFirst;
                while(aux != null){
                    if (aux.getpNext() != null) {
                        if (aux.getpNext().getElemento() == element && aux.getpNext().getpNext() == null) {
                            pLast = aux;
                            pLast.setpNext(null);
                            size -= 1;
                        } else {
                            if (aux.getpNext().getElemento() == element) {
                            aux.setpNext(aux.getpNext().getpNext());
                            size -= 1;
                            }
                        }
                    }    
                    aux = aux.getpNext();
                }    
            }
        }
    }
    
    
    /**
     * Elimina un objeto dentro de la lista
     * @param element el objeto a ser eliminado
     */
    public void DeleteObjeto(T element){
        if (!isEmpty()) {
            if (pFirst == element) {
                if (pFirst.getpNext() == null) {
                    pFirst = null;
                    pLast = null;
                } else {
                    pFirst = pFirst.getpNext();
                }
                size -=1;
            } else {
                Nodo aux = pFirst;
                while(aux != null){
                    if (aux.getpNext() != null) {
                        if (aux.getpNext() == element && aux.getpNext().getpNext() == null) {
                            pLast = aux;
                            pLast.setpNext(null);
                            size -= 1;
                        } else {
                            if (aux.getpNext() == element) {
                            aux.setpNext(aux.getpNext().getpNext());
                            size -= 1;
                            }
                        }
                    }    
                    aux = aux.getpNext();
                }    
            }
        }
    }
        
    /**
     * Método que copia la lista actual
     */
    public Lista copiarLista() {
        Lista listaCopia = new Lista();
        if (this.isEmpty()) {
            return listaCopia;
        } else {
            Nodo aux = this.getpFirst();
            for (int i = 0; i < this.getSize(); i++) {
                listaCopia.AppendAtTheEnd(aux.getElemento());
                aux = aux.getpNext();
            }
            return listaCopia;
        }
    }
    
        
    /**
     * Obtiene el primer nodo de la lista
     * @return el primero nodo de la lista
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista
     * @param pFirst el nodo a ser establecido como primero
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Retorna el último nodo de la lista
     * @return el último nodo de la lista
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * Establece el último nodo de la lista
     * @param pLast el último nodo a ser establecido
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * Obtiene el tamaño de la lista
     * @return tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista
     * @param size el tamaño a ser establecido
     */
    public void setSize(int size) {
        this.size = size;
    }

   
    
}