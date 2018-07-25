package view;

import controller.MainController;
import utils.FrameManager;

import javax.swing.*;

public class MainFrame {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton registerButton;
    private JButton exitButton;
    private JPanel panelMain;


    public MainFrame() {
        singInEvent();
        exitEvent();
        registrationEvent();
    }

    private void singInEvent() {
        signInButton.addActionListener(e -> {
            String password = FrameManager.buildPassword(passwordField.getPassword());
            String login = loginField.getText();
        });
    }


    private void exitEvent() {
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void registrationEvent() {
        registerButton.addActionListener(e -> {
            MainController.runRegistration();
            FrameManager.changeFrameDisplay(MainController.getRegistrationFrame(), MainController.getMainFrame());

        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
