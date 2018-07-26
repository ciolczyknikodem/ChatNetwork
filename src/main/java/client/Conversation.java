package client;

import model.Client;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Conversation {
    private ChatSender sender;
    private ChatReciver reciver;
    private Client author;
    private List<Client> userList;
    private Socket socket;
    private ObjectOutputStream writer;

    public Conversation(Socket socket, Client author, List<Client> userList) {
        this.socket = socket;
        this.author = author;
        this.userList = userList;
    }

    public void start() throws IOException {
        writer = new ObjectOutputStream(socket.getOutputStream());
        reciver = new ChatReciver(socket);
        reciver.runListener();
        System.out.println("Please type your message: ");
        sender = new ChatSender(writer, author, new ArrayList<>());
        sender.runSender();
    }
}
