package Sabatino.entities;

import jakarta.persistence.Entity;

@Entity
public class Rivista extends Elemento_bibliografico {

    private String periodicita;

    public Rivista() {
    }

    public Rivista(String isbn, String titolo, int anno_pubblicazione, int numero_pagine, String periodicita) {
        super(isbn, titolo, anno_pubblicazione, numero_pagine);
        this.periodicita = periodicita;
    }

    public String getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(String periodicita) {
        this.periodicita = periodicita;
    }
}
