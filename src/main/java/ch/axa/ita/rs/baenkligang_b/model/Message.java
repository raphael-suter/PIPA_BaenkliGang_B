package ch.axa.ita.rs.baenkligang_b.model;

public class Message {
    private String message;

    public Message() {
        super();
    }

    public Message(String message) {
        this();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
