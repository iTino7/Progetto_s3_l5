package Sabatino.entities;

import jakarta.persistence.Entity;

@Entity
public class Libro extends Elemento_bibliografico {

    private String autore;
    private String genere;

    public Libro() {
    }

    public Libro(String isbn, String titolo, int anno_pubblicazione, int numero_pagine, String autore, String genere) {
        super(isbn, titolo, anno_pubblicazione, numero_pagine);
        this.autore = autore;
        this.genere = genere;
    }


    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    
}
