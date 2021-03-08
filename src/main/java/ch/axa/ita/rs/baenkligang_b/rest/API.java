package ch.axa.ita.rs.baenkligang_b.rest;

import ch.axa.ita.rs.baenkligang_b.model.SignInData;
import ch.axa.ita.rs.baenkligang_b.model.SignUpData;
import ch.axa.ita.rs.baenkligang_b.model.User;
import ch.axa.ita.rs.baenkligang_b.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static ch.axa.ita.rs.baenkligang_b.utility.HashGenerator.hash;
import static ch.axa.ita.rs.baenkligang_b.utility.ResponseGenerator.*;
import static ch.axa.ita.rs.baenkligang_b.utility.TokenGenerator.token;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class API {
    private final UserRepository userRepository = new UserRepository();

    @PostMapping("/sign_up")
    private ResponseEntity<?> signUp(@RequestBody SignUpData signUpData) {
        String email = signUpData.getEmail();
        String password = signUpData.getPassword();
        String repPassword = signUpData.getRepPassword();

        if (isEmpty(email)) {
            return badRequest("E-Mail-Adresse darf nicht leer sein.");
        }

        if (userRepository
                .readByEmail(email)
                .isPresent()) {
            return badRequest("Diese E-Mail-Adresse wird bereits verwendet.");
        }

        if (isEmpty(password)) {
            return badRequest("Passwort darf nicht leer sein.");
        }

        if (!password.equals(repPassword)) {
            return badRequest("Passwörter stimmen nicht überein.");
        }

        userRepository.create(new User(email, password));
        return ok("Erfolgreich registriert.");
    }

    @PostMapping("/sign_in")
    private ResponseEntity<?> signIn(@RequestBody SignInData signInData) {
        Optional<User> userFromDB = userRepository.readByEmail(signInData.getEmail());

        if (userFromDB.isPresent()) {
            User user = userFromDB.get();

            String passwordFromDB = user.getPassword();
            String passwordFromSignInData = hash(signInData.getPassword());

            if (passwordFromDB.equals(passwordFromSignInData)) {
                String token = token();
                user.setToken(token);

                return ok(token);
            }

            return badRequest("Falsches Passwort.");
        }

        return notFound("Dieser Benutzer wurde nicht gefunden.");
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
