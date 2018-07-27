package view;

import controller.AlertController;
import controller.MainController;
import controller.RegistrationProcess;
import model.Client;
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
        registerButtonEvent();
    }

    private void registerButtonEvent() {
        registerButton.addActionListener(e -> {
            String login = loginField.getText();
            String password = FrameManager.buildPassword(passwordField.getPassword());

            RegistrationProcess registrationProcess = new RegistrationProcess(
                    MainController.getIpAddress(),
                    MainController.getPort()
            );

            Client user = new Client(login, password);

            if(registrationProcess.run(user)) {
                AlertController.registrationAlert(true);
            }
            else {
                AlertController.registrationAlert(false);
            }
        });
    }

    private void backButtonEvent() {
        backButton.addActionListener(e ->
                FrameManager.changeFrameDisplay(MainController.getMainFrame(), MainController.getRegistrationFrame()));
    }

    public JPanel getRegistrationPanel() { return registrationPanel; }
}
