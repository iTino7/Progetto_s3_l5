package Sabatino;

import Sabatino.entities.Libro;
import Sabatino.entities.Periodicita;
import Sabatino.entities.Rivista;
import Sabatino.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettobibliografico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Libro libro = new Libro("ISBN1234", "Il signore degli anelli", 1954, 1200, "J.R.R. Tolkien", "Fantasy");

        Rivista rivista = new Rivista("ISBN27827", "National Geographic", 2024, 100, Periodicita.SEMESTRALE);

        Utente utente = new Utente("Sabatino", "Borrelli", LocalDate.of(1998, 3, 18), "Tessera2343");

        em.persist(libro);
        em.persist(rivista);
        em.persist(utente);

        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.println("dati salvati correttamente");
    }
}
