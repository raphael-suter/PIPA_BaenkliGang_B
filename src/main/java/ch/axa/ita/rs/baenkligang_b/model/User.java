package ch.axa.ita.rs.baenkligang_b.model;

import static ch.axa.ita.rs.baenkligang_b.utility.HashGenerator.hash;

public class User {
    private int id;
    private String email;
    private String password;
    private String token;

    public User() {
        super();
    }

    public User(String email, String password) {
        this();

        this.email = email;
        this.password = hash(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
