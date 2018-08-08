package dao;

import model.User;
import org.hibernate.exception.ConstraintViolationException;

public class UserResources extends ConnectionManager implements ManageDB {

    public boolean add(User user) {
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println(user);
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
            initializeFactory();
            Criteria criteria = session.createCriteria(User.class);
            user = (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();
        }
        catch (Exception e) {
            System.out.println(e.getClass().getName() + " --> " + e.getMessage());
        }
        finally {
            closeConnection();
        }
        return user;
    }

}
