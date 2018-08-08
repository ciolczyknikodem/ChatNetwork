package dao;

import model.User;
import org.hibernate.exception.ConstraintViolationException;

public class UserResources extends ConnectionManager implements ManageDB {

    public boolean add(User user) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (ConstraintViolationException e){
            return false;
        }
        return true;
    }

    public User get(String login) {
        User user = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            user = (User) session.createQuery("FROM User where login = :login")
                                 .setParameter("login", login)
                                 .getSingleResult();
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getClass().getName() + " --> " + e.getMessage());
        }
        return user;
    }

}
