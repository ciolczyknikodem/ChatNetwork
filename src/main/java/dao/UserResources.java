package dao;

import model.Client;

public class UserResources extends ConnectionManager implements ManageDB {


    public void add(Client user) {
        initializeFactory();

        session.persist(user);
        transaction.commit();

        closeConnection();
    }

}
