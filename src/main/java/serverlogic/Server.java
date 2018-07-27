package serverlogic;

import dao.UserResources;
import model.User;
import model.Message;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final int port;
    private final String address;

    private static final List<IncomingRequestHandler> clients = new ArrayList<>(); //Todo Change this to Clients?

    public Server(int port, String address) {
        this.port = port;
        this.address = address;
    }

    public void startListening() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port, 50, InetAddress.getByName(address))) {

            while (true) {
                new IncomingRequestHandler(serverSocket.accept()).start();
            }

        }
    }

    private static class IncomingRequestHandler extends Thread {

        private final Socket socket;
        private int ID;
        private ObjectInputStream in;
        private ObjectOutputStream out;

        public IncomingRequestHandler(Socket socket) {
            this.socket = socket;
            this.ID = socket.getPort();
        }

        @Override
        public void run() {
            try {
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());

                synchronized (clients) {
                    clients.add(this); // Todo Check if client in database?
                }

                while (true) {
                    Object object = in.readObject();

                    if (requestIsUser(object)) {
                        handleUserRequest(object);
                    }
                    else {
                        Message message = (Message) object;
                        for (IncomingRequestHandler element : clients) {

                            try {
                                element.getOutputStream().writeObject(message); //Todo Write message to database
                                System.out.println(message);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }


            } catch (EOFException e) {
                String userAddress = socket.getInetAddress() + ":" + socket.getPort();
                System.out.println("User with adress: " + userAddress + " has been disconnected.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void handleUserRequest(Object object) throws IOException {
            User user = (User) object;

            if(user.isToRegistration()) {
                registerUser(user);
            }
            user = find(user);
            out.writeObject(user);
        }

        private void registerUser(User user) {
            UserResources userResources = new UserResources();
            userResources.add(user);
        }

        private boolean requestIsUser(Object object) {
            return object instanceof User;
        }

        private User find(User user) {
            UserResources userResources = new UserResources();
            return userResources.get(user.getLogin());
        }

        public ObjectOutputStream getOutputStream() {
            return out;
        }
    }
}
