package Sabatino;

import Sabatino.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettobibliografico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Libro libro = new Libro("ISBN1221", "Il signore degli anelli", 1954, 1200, "J.R.R. Tolkien", "Fantasy");

        Rivista rivista = new Rivista("ISBN27837", "National Geographic", 2024, 100, Periodicita.SEMESTRALE);

        Utente utente = new Utente("Sabatino", "Borrelli", LocalDate.of(1998, 3, 18), "Tessera2343");


        em.persist(libro);
        em.persist(rivista);
        em.persist(utente);


        em.getTransaction().commit();

        //Utente utenteDb = em.find(Utente.class, utente.getId());

        Utente utenteDb = em.createQuery(
                        "SELECT u FROM Utente u WHERE u.numero_tessera = :tessera", Utente.class)
                .setParameter("tessera", "Tessera2343")
                .getSingleResult();

        Elemento_bibliografico libroDb = em.find(Libro.class, libro.getIsbn());

        Prestito prestito = new Prestito(utenteDb, libroDb, LocalDate.now());

        em.getTransaction().begin();
        em.persist(prestito);
        em.getTransaction().commit();

        System.out.println(prestito);

        em.getTransaction().begin();

        Long lastId = em.createQuery("SELECT MAX(p.id) FROM Prestito p", Long.class).getSingleResult();

        int mod = em.createQuery(
                        "UPDATE Prestito p SET p.restituzione_effettiva = :nuova_data WHERE p.id = :id_prestito")
                .setParameter("nuova_data", LocalDate.now().plusDays(31))
                .setParameter("id_prestito", lastId)
                .executeUpdate();

        em.getTransaction().commit();

        Prestito prestito_update = em.find(Prestito.class, lastId);
        System.out.println("Restituito il: " + prestito_update.getRestituzione_effettiva());


        em.close();
        emf.close();

        System.out.println("dati salvati correttamente");
    }
}
