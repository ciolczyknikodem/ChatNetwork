package client;


import model.Client;

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
        Client client = new Client("Adam", "Kruk");
        Conversation conversation = new Conversation(socket, client, new ArrayList<>());
        conversation.start();
    }
}
