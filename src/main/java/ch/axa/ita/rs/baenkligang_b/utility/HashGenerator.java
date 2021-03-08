package ch.axa.ita.rs.baenkligang_b.utility;

import org.apache.commons.codec.digest.DigestUtils;

public class HashGenerator {
    public static String hash(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
