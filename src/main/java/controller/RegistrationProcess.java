package controller;

import model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RegistrationProcess {

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private boolean isRunning;
    private User userResponse;

    public RegistrationProcess(String ipAddress, int port) {
        try {
            this.socket = new Socket(ipAddress, port);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean run(User user) {
        serverRequest(user);

        isRunning = true;
        while(isRunning) {
            try {
                userResponse = (User) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (userResponse != null) {
                MainController.setUser(userResponse);

                isRunning = false;
                return true;
            }
        }
        return false;
    }

    private void serverRequest(User user) {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(user);

            in = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
