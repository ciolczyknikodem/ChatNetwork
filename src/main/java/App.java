
import controller.MainController;

public class App {

    public static void main(String[] args) {
        MainController mainController = new MainController("localhost", 9000);
        mainController.runApp();
    }
}
