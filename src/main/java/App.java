
import controller.MainController;
import serverlogic.Server;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        MainController mainController = new MainController("192.168.10.208", 9000);
        mainController.runApp();
    }
}
