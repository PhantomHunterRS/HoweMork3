package ru.phantomhunter;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        createEntity(entityManager);
        Client readEntity = readEntity(entityManager,1L);
        readEntity.setNameClient("SpeedyRaser");
        saveEntity(entityManager,readEntity);

    }

    private static void saveEntity(EntityManager entityManager, Client readEntity) {
        System.out.println("Saving start");
        entityManager.getTransaction().begin();
        Client savedEntity = entityManager.merge(readEntity);
        entityManager.getTransaction().commit();
        System.out.println("Saving end");
    }

    private static Client readEntity(EntityManager entityManager, long id) {
        System.out.println("Reading start");
        entityManager.getTransaction().begin();
        Client client = entityManager.find(Client.class,id);
        entityManager.getTransaction().commit();
        System.out.println("Reading end");
        return client;
    }

    private static void createEntity(EntityManager entityManager) {
        System.out.println("Creating Entity");
        Client client = new Client();
        client.setNameClient("BuyerNumberOne");
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        System.out.println("Creating finished");
    }
}
