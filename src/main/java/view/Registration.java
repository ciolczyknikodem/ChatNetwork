package view;

import controller.MainController;
import utils.FrameManager;

import javax.swing.*;

public class Registration {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton backButton;
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
