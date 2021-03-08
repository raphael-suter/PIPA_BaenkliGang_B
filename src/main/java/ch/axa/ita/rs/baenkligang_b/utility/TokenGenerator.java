package ch.axa.ita.rs.baenkligang_b.utility;

import java.util.UUID;

public class TokenGenerator {
    public static String token() {
        return UUID
                .randomUUID()
                .toString();
    }
}
