package dao;

import model.User;

interface ManageDB {

    boolean add(User user);
    User get(String login);
}
