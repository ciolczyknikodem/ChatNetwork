package utils;

public enum EventMessage {
    REGISTER_SUCCESSFUL("Registration successful!"),
    REGISTER_FAILED("Registration failed!");

    private String message;
    EventMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
