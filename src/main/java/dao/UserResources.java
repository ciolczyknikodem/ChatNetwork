package dao;

import model.Client;

public class UserResources extends ConnectionManager implements ManageDB {


    public void add(Client user) {
        initializeFactory();

        session.save(user);
        transaction.commit();

        closeConnection();
    }

}
