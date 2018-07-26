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
    private JPasswordField passwordField1;

    public Registration() {
        backButtonEvent();
        registerButtonEvent();
    }

    public JPanel getRegistrationPanel() { return registrationPanel; }

    private void registerButtonEvent() {
        registerButton.addActionListener(e -> {
            String login = loginField.getText();
            String password = FrameManager.buildPassword(passwordField.getPassword());
            String repeatedPassword = FrameManager.buildPassword(passwordField1.getPassword());

            boolean isPasswordCorrect = FrameManager.validatePassword(password, repeatedPassword);
            boolean isRegisterSuccessful = FrameManager.registerNewUser(login, password);

            if (isRegisterSuccessful && isPasswordCorrect) {
                // TODO: connect with DB logic
            }
        });
    }

    private void backButtonEvent() {
        backButton.addActionListener(e ->
                FrameManager.changeFrameDisplay(MainController.getMainFrame(), MainController.getRegistrationFrame()));
    }
}
