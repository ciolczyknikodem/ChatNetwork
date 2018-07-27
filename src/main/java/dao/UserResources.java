package dao;

import model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class UserResources extends ConnectionManager implements ManageDB {


    public boolean add(User user) {
        try {
            initializeFactory();
            session.persist(user);
            transaction.commit();
        }
        catch (Exception e) {
            System.out.println(e.getClass().getName() + " --> " + e.getMessage());
            return false;
        }
        finally {
            closeConnection();
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
