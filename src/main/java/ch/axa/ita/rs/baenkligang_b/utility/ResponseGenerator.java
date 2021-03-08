package ch.axa.ita.rs.baenkligang_b.utility;

import ch.axa.ita.rs.baenkligang_b.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ResponseGenerator {
    private static ResponseEntity<?> response(HttpStatus httpStatus, String message) {
        return ResponseEntity
                .status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Message(message));
    }

    public static ResponseEntity<?> notFound(String message) {
        return response(HttpStatus.NOT_FOUND, message);
    }

    public static ResponseEntity<?> badRequest(String message) {
        return response(HttpStatus.BAD_REQUEST, message);
    }

    public static ResponseEntity<?> ok(String message) {
        return response(HttpStatus.OK, message);
    }
}
