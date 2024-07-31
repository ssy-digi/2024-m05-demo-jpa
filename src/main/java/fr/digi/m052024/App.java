package fr.digi.m052024;

import fr.digi.m052024.dal.Connection;
import fr.digi.m052024.entites.Fournisseur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class App {
    public static void main(String[] args) {

        EntityManager em = Connection.getEntityManager();
        em.getTransaction().begin();

        //C -> Crud création d'un nouveau fournisseur
        Fournisseur fournisseurACreer = new Fournisseur("Sebsy Corp", "12345");
        em.persist(fournisseurACreer);


        //R -> CRUD : récupération du fournisseur dont l'id est : 3
        Fournisseur fournisseur = em.find(Fournisseur.class, 3);
        if (null != fournisseur) {
            System.out.println(fournisseur);
        }

        //R -> CRUD : récupération de l'ensemble des fournisseurs
        TypedQuery<Fournisseur> query = em.createQuery("SELECT f FROM Fournisseur f", Fournisseur.class);
        List<Fournisseur> fournisseurs = query.getResultList();
        for (Fournisseur item : fournisseurs) {
            System.out.println(item);
        }

        //U -> CRUD : Modification du fournisseur 2
        Fournisseur fournisseurAModifier = em.find(Fournisseur.class, 2);
        if (null != fournisseurAModifier) {
            fournisseurAModifier.setRaisonSociale("TOTO");
        }

        //D -> CRUD : Suppression du fournisseur 4
        Fournisseur fournisseurASupp = em.find(Fournisseur.class, 4);
        if (null != fournisseurASupp) {
            em.remove(fournisseurASupp);
        }

        em.getTransaction().commit();
        em.close();

        Connection.closeConnections();
    }
}