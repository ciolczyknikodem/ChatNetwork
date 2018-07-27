package client;


import model.User;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientController {

    private final String ipAddress;
    private final int port;
    private Socket socket;

    public ClientController(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public void start() throws IOException {
        socket = new Socket(ipAddress, port);
        User user = new User("Adam", "Kruk");
        Conversation conversation = new Conversation(socket, user, new ArrayList<>());
        conversation.start();
    }
}
