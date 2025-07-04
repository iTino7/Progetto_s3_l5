package Sabatino.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "elemento_bibliografico_isbn")
    private Elemento_bibliografico eb;

    @Column(name = "inizio_prestito", nullable = false)
    private LocalDate inizio_prestito;

    @Column(name = "restituzione_prevista", nullable = false)
    private LocalDate restituzione_prevista;

    @Column(name = "restituzione_effettiva")
    private LocalDate restituzione_effettiva;

    public Prestito() {
    }

    public Prestito(Utente utente, Elemento_bibliografico eb, LocalDate inizio_prestito) {
        this.utente = utente;
        this.eb = eb;
        this.inizio_prestito = inizio_prestito;
        this.restituzione_prevista = inizio_prestito.plusDays(30);
    }

    public LocalDate getRestituzione_effettiva() {
        return restituzione_effettiva;
    }

    public void setRestituzione_effettiva(LocalDate restituzione_effettiva) {
        this.restituzione_effettiva = restituzione_effettiva;
    }

    public LocalDate getRestituzione_prevista() {
        return restituzione_prevista;
    }

    public void setRestituzione_prevista(LocalDate restituzione_prevista) {
        this.restituzione_prevista = restituzione_prevista;
    }

    public LocalDate getInizio_prestito() {
        return inizio_prestito;
    }

    public void setInizio_prestito(LocalDate inizio_prestito) {
        this.inizio_prestito = inizio_prestito;
    }

    public Elemento_bibliografico getEb() {
        return eb;
    }

    public void setEb(Elemento_bibliografico eb) {
        this.eb = eb;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", eb=" + eb +
                ", inizio_prestito=" + inizio_prestito +
                ", restituzione_prevista=" + restituzione_prevista +
                ", restituzione_effettiva=" + restituzione_effettiva +
                '}';
    }
}
