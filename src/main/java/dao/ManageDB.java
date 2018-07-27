package dao;

import model.Client;

interface ManageDB {

    boolean add(Client user);
    Client get(String login);
}
