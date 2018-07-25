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
}
