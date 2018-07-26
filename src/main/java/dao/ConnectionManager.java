package dao;

import model.Client;
import model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ConnectionManager {

    protected SessionFactory sessionFactory;
    protected Transaction transaction;
    protected Session session;


    protected void initializeFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Message.class)
                .buildSessionFactory();

        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();

    }

    protected void closeConnection() {
        session.close();
        sessionFactory.close();
    }
}
