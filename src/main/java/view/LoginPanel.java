package view;

import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JPanel {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JButton exitButton;
    private LoginListener listener;


    public ChatFrame() {
    }

    public String getLogin() {
        return loginField.getText();
    }

    public String getPassword() {
        char[] pass = passwordField.getPassword();
        return buildWord(pass);
    }
    

    private String buildWord(char[] letters) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < letters.length; i++) {
            sb.append(letters[i]);
        }
        return sb.toString();
    }
}
