import view.ChatFrame;

import java.awt.*;

public class App {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatFrame();
            }
        });
    }
}
