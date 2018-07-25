package view;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton registerButton;
    private JButton exitButton;
    private JPanel panelMain;

    public JPanel getPanelMain() {
        return panelMain;
    }
}
