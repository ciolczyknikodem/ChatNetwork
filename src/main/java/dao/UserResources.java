package dao;

import model.Client;

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

}
