package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LoginValidator {

    private Socket socket;
    private ObjectOutputStream writer;
    private boolean isRunning;

    public LoginValidator(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        writer = new ObjectOutputStream(socket.getOutputStream());

    }
}
