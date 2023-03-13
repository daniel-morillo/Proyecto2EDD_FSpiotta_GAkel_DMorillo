/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import Clases.Summary;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Morillo
 */
public class HashTable<T> {
    
    private Lista[] arrayHash;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.arrayHash = new Lista[size];
    }
    
    public String capitalizeTitle(String palabra) {  
        String words[]= palabra.split("\\s");  
        String capitalizeWord="";  
        for(String w:words){  
            String first = w.substring(0,1);  
            String afterfirst = w.substring(1);  
            capitalizeWord += first.toUpperCase() + afterfirst.toLowerCase() + " ";  
        }  
        return capitalizeWord.trim();  
    }
    
    public int getAsciiValue(String name){
        int suma = 0;
        String [] array = name.split(" ");
        for (int i = 0; i < array[0].length(); i++) {
            char character = array[0].charAt(i);
            int ascii = (int) character;
            suma += ascii;
        }
        return suma;
    }
    
    public int hash(String n){
        int clave;
        String palabra = this.capitalizeTitle(n);
        clave = getAsciiValue(palabra) % getSize();
        return clave;
    }
    
    public void insertar(String key, T valor){
        int hashindex = hash(key);
        Lista subLista = new Lista();
        subLista.AppendAtTheEnd(valor);
        Lista valorArreglo = getArrayHash()[hashindex];
        if (valorArreglo != null) {
            valorArreglo.AppendAtTheEnd(valor);
        } else {
            getArrayHash()[hashindex] = subLista;
        }
    } 
    
    public T obtener(String key){
        T valor = null;
        int hashindex = hash(key);
        Lista valorarreglo = getArrayHash()[hashindex];
        Nodo<Summary> aux = valorarreglo.getpFirst();
        if (valorarreglo != null) {
            while(aux != null){
                if (aux.getElemento().getTitulo().equalsIgnoreCase(key)){
                    valor = (T) aux.getElemento();
                    break;
                }
                aux = aux.getpNext();
            }
        }
        return valor;  
    }
    
    public Lista obtenerPorHash(int hash) {
        Lista valorArreglo = getArrayHash()[hash];
        Lista newList = new Lista();
        Nodo<Summary> aux = valorArreglo.getpFirst();
        while(aux != null) {
            newList.AppendAtTheEnd(valorArreglo);
            aux = aux.getpNext();
        }  
        return newList;
    }
    
    public Lista obtenerAutores(String key) {
        int hashindex = hash(key);
        Lista valorArreglo = getArrayHash()[hashindex];
        Lista newList = new Lista();
        if (valorArreglo != null) {
            Nodo<Summary> aux = valorArreglo.getpFirst();
            while(aux != null) {
                Nodo<String> aux2 = aux.getElemento().getAutores().getpFirst();
                for (int i = 0; i < aux.getElemento().getAutores().getSize(); i++) {
                    if (aux2.getElemento().equalsIgnoreCase(key)) {
                        newList.AppendAtTheEnd(aux.getElemento());
                    }
                    aux2 = aux2.getpNext();
                }
                aux = aux.getpNext();
            }
        }
        return newList;
    }
    
    public Lista obtenerPalabraClave(String key) {
        int hashindex = hash(key);
        Lista valorArreglo = getArrayHash()[hashindex];
        Lista newList = new Lista();
        if (valorArreglo!= null) {
            Nodo<Summary> aux = valorArreglo.getpFirst();
            while(aux != null) {
                Nodo<String> aux2 = aux.getElemento().getKeyWords().getpFirst();
                for (int i = 0; i < aux.getElemento().getKeyWords().getSize(); i++) {
                    if (aux2.getElemento().equalsIgnoreCase(key)) {
                        newList.AppendAtTheEnd(aux.getElemento());
                    }
                    aux2 = aux2.getpNext();
                }
                aux = aux.getpNext();
            } 
        }
        return newList;
    }

    /**
     * @return the arrayHash
     */
    public Lista[] getArrayHash() {
        return arrayHash;
    }

    /**
     * @param arrayHash the arrayHash to set
     */
    public void setArrayHash(Lista[] arrayHash) {
        this.arrayHash = arrayHash;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
