package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int ID;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Transient
    private boolean status;

    @Transient
    private boolean toRegistration;

    public User() { }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.toRegistration = true;
    }

    public User(int ID, String login, String password) {
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

    public boolean isToRegistration() { return toRegistration; }

    public void setToRegistration(boolean toRegistration) { this.toRegistration = toRegistration; }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", toRegistration=" + toRegistration +
                '}';
    }
}
