/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EstructurasDeDatos.Lista;

/**
 *
 * @author fabriziospiotta
 */
public class Summary {
    
    private String titulo;
    private Lista autores;
    private String cuerpoResumen;
    private Lista keyWords;

    public Summary(String titulo, Lista autores, String cuerpoResumen, Lista keyWords) {
        this.titulo = titulo;
        this.autores = autores;
        this.cuerpoResumen = cuerpoResumen;
        this.keyWords = keyWords;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autores
     */
    public Lista getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(Lista autores) {
        this.autores = autores;
    }

    /**
     * @return the cuerpoResumen
     */
    public String getCuerpoResumen() {
        return cuerpoResumen;
    }

    /**
     * @param cuerpoResumen the cuerpoResumen to set
     */
    public void setCuerpoResumen(String cuerpoResumen) {
        this.cuerpoResumen = cuerpoResumen;
    }

    /**
     * @return the keyWords
     */
    public Lista getKeyWords() {
        return keyWords;
    }

    /**
     * @param keyWords the keyWords to set
     */
    public void setKeyWords(Lista keyWords) {
        this.keyWords = keyWords;
    }
    
    
    
           
    
}
