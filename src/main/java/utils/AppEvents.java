package utils;

public enum AppEvents {
    REGISTER_SUCCESSFUL("Registration successful!"),
    REGISTER_FAILED("Registration failed!");

    private String message;
    AppEvents(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
