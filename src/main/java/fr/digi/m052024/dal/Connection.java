package fr.digi.m052024.dal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

    private Connection() {}

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeConnections() {
        if (null != emf) {
            emf.close();
        }
    }
}
