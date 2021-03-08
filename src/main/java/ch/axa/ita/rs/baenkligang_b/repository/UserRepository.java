package ch.axa.ita.rs.baenkligang_b.repository;

import ch.axa.ita.rs.baenkligang_b.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private int id;
    private List<User> users;

    public UserRepository() {
        super();

        id = 0;
        users = new ArrayList<>();
    }

    public void create(User user) {
        user.setId(id);
        users.add(user);

        id++;
    }

    public Optional<User> readByEmail(String email) {
        return users
                .stream()
                .filter(u -> u
                        .getEmail()
                        .equals(email))
                .findFirst();
    }
}
