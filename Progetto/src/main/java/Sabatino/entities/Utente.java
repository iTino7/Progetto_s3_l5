package Sabatino.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private LocalDate data_nascita;

    @Column(unique = true)
    private String numero_tessera;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate data_nascita, String numero_tessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.numero_tessera = numero_tessera;
    }

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(String numero_tessera) {
        this.numero_tessera = numero_tessera;
    }


}
