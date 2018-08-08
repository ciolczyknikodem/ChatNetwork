package dao;

import model.User;
import model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionManager {

    protected SessionFactory sessionFactory;
    protected Session session;

    public ConnectionManager() {
        initializeFactory();
    }

    protected void initializeFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Message.class)
                .buildSessionFactory(); // todo find a way to close connection
    }
}
