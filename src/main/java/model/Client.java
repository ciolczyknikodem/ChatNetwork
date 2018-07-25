package model;

public class Client {

    private int ID;
    private String login;
    private String password;
    private boolean status;

    public Client(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Client(int ID, String login, String password) {
        this.ID = ID;
        this.login = login;
        this.password = password;
    }
}
