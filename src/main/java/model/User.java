package model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String surname;
    private String password;
    private String birthday;

    public User() {}

    public User(String email, String name, String surname, String password, String birthday) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
    }

    public User(long id, String email, String name, String surname, String password, String birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + " " + email + " " + name + " " + surname + " " + password + " " + birthday;
    }
}
















