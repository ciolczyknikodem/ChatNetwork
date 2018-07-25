package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Client {

    @Id @GeneratedValue
    @Column(name = "id")
    private int ID;

    @Column(name = "name")
    private String login;

    @Column(name = "password")
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
