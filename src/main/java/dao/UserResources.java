package dao;

import model.Client;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class UserResources extends ConnectionManager implements ManageDB {


    public boolean add(Client user) {
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

    public Client get(String login) {
        Client user = null;

        try {
            initializeFactory();
            Criteria criteria = session.createCriteria(Client.class);
            user = (Client) criteria.add(Restrictions.eq("login", login)).uniqueResult();
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
