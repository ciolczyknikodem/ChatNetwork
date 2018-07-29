package utils;

public enum EventMessage {
    REGISTER_SUCCESSFUL("Registration successful!"),
    REGISTER_FAILED("Registration failed!"),
    LOGIN_SUCCESSFUL("Login successful!"),
    LOGIN_FAILED("Login failed!")
    ;

    private String message;
    EventMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
