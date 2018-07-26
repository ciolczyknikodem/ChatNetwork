package serverlogic;

import model.Message;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final int port;
    private final String address;

    private static final List<ObjectOutputStream> clients = new ArrayList<>(); //Todo Change this to Clients?

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

        public IncomingRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                synchronized (clients) {
                    clients.add(out); // Todo Check if client in database?
                }

                while (true) {
                    Message message = (Message) in.readObject();
                    clients.forEach(objectOutputStream -> {
                        try {
                            objectOutputStream.writeObject(message); //Todo Write message to database
                            System.out.println(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }


            } catch (EOFException e) {
                String userAddress = socket.getInetAddress() + ":" + socket.getPort();
                System.out.println("User with adress: " + userAddress + " has been disconnected.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
