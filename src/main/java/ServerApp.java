import serverlogic.Server;

import java.io.IOException;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        new Server(9000, "192.168.10.208").startListening();
        //Adam IPAddress = 192.168.11.70
        //Augustyn IPAddress = 192.168.10.114
        //Nikodem IPAddress = 192.168.10.208
    }
}
