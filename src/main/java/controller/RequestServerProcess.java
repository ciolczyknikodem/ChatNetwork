package controller;

import model.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestServerProcess implements Runnable {

    private static String ipAddress;
    private static int port;

    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private boolean isRunning;
    private User userResponse;
    private User userRequest;

    public RequestServerProcess() {
        try {
            this.socket = new Socket(ipAddress, port);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void run() {
        serverRequest(userRequest);

        isRunning = true;
        while (isRunning) {
            try {
                userResponse = (User) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (userResponse != null) {
                MainController.setUser(userResponse);
                isRunning = false;
            }
        }
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

    public void setUserRequest(User userRequest) {
        this.userRequest = userRequest;
    }

    public User getUserRequest() {
        return userRequest;
    }

    public static void setIpAddress(String ipAddress) {
        RequestServerProcess.ipAddress = ipAddress;
    }

    public static void setPort(int port) {
        RequestServerProcess.port = port;
    }
}
