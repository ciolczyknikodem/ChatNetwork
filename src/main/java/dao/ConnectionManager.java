package dao;

import model.User;
import model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ConnectionManager {

    protected SessionFactory sessionFactory;
    protected Transaction transaction;
    protected Session session;


    protected void initializeFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
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
