package view;

import controller.MainController;
import utils.FrameManager;

import javax.swing.*;

public class Registration {
    private JTextField loginTextField;
    private JPasswordField passwordTextField;
    private JButton registerButton;
    private JButton backButton;
    private JLabel loginField;
    private JLabel passwordField;
    private JPanel registrationPanel;

    public Registration() {
        backButtonEvent();
    }

    public JPanel getRegistrationPanel() {
        return registrationPanel;
    }

    private void registerButtonEvent() {
        registerButton.addActionListener(e -> {
            String login = loginField.getText();
            String password;
                }
        );
    }

    private void backButtonEvent() {
        backButton.addActionListener(e ->
                FrameManager.changeFrameDisplay(MainController.getMainFrame(), MainController.getRegistrationFrame()));
    }
}
