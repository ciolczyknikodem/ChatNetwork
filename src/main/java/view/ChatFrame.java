package view;

import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {

    public ChatFrame() {
        super("SlackLike");
        LoginListener loginListener = new LoginListener(this);
        JPanel loginPanel = new LoginPanel(loginListener);

        add(loginPanel);

        setSize(new Dimension(860, 640));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
