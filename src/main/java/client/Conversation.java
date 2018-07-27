package client;

import model.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Conversation {
    private ChatSender sender;
    private ChatReciver reciver;
    private User author;
    private List<User> userList;
    private Socket socket;
    private ObjectOutputStream writer;

    public Conversation(Socket socket, User author, List<User> userList) {
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
