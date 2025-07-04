package Sabatino.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class elemento_bibliografico {
    @Id
    private String isbn;
    private String titolo;
    private int anno_pubblicazione;
    private int numero_pagine;

    public elemento_bibliografico() {
    }

    public elemento_bibliografico(String isbn, String titolo, int anno_pubblicazione, int numero_pagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(int anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    @Override
    public String toString() {
        return "elemento_bibliografico{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
