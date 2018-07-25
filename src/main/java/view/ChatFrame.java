package view;

import javax.swing.*;

public class ChatFrame extends JFrame {

    public ChatFrame() {
        super("SlackLike");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(100, 100);
        setSize(860, 640);

        add(new JButton("Send"));
        add(new JButton("Exit"));
    }

}
