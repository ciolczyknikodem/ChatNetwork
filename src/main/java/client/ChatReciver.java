package client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ChatReciver {
    private Socket socket;
    private ObjectInputStream inputStream;

    public ChatReciver(Socket socket) {
        this.socket = socket;
    }

    public void runListener() throws IOException {
        inputStream = new ObjectInputStream(socket.getInputStream());
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(inputStream.readObject());
                    System.out.println("Please type your message: ");
                } catch (EOFException e) {
                    break;
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
