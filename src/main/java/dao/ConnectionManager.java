package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

class ConnectionManager {

    protected StandardServiceRegistry standardServiceRegistry;
    protected SessionFactory sessionFactory;
    protected Transaction transaction;
    protected Metadata metadata;
    protected Session session;


    protected void initializeFactory() {
        standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

    }

    protected void closeConnection() {
        sessionFactory.close();
        session.close();
    }
}
