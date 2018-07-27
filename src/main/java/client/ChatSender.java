package client;

import model.User;
import model.Message;

import java.io.*;
import java.net.SocketException;
import java.util.List;
import java.util.Scanner;

public class ChatSender {

    private ObjectOutputStream writer;
    private User user;
    private List<User> userList;

    public ChatSender(ObjectOutputStream writer, User user, List<User> userList) {
        this.user = user;
        this.writer = writer;
        this.userList = userList;
    }

    public void runSender() throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            Message message = new Message(user.getID(), scanner.nextLine());
            try {
                writer.writeObject(message);
            } catch (SocketException e) {
                System.err.println("Server is not working ...");
                break;
            }
        }
    }
}
