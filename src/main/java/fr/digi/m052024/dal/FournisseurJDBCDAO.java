package fr.digi.m052024.dal;

import fr.digi.m052024.entites.Fournisseur;
import jakarta.persistence.EntityManager;

public class FournisseurJDBCDAO implements FournisseurDAO {

    @Override
    public Fournisseur creer(Fournisseur fournisseur) {

        try(EntityManager em = Connection.getEntityManager()) {
            em.persist(fournisseur);
        }
        return fournisseur;
    }
}
