package view;

import controller.AlertController;
import controller.MainController;
import controller.RequestServerProcess;
import model.User;
import utils.EventMessage;
import utils.FrameManager;

import javax.swing.*;

public class RegistrationFrame {
    private final int LOGIN_INDEX = 0;
    private final int PASSWORD_INDEX = 1;
    private final int REPEATED_PASSWORD_INDEX = 2;

    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton backButton;
    private JPanel registrationPanel;
    private JPasswordField passwordField1;

    public RegistrationFrame() {
        backButtonEvent();
        registerButtonEvent();
    }

    public JPanel getRegistrationPanel() { return registrationPanel; }

    private void registerButtonEvent() {
        registerButton.addActionListener(e -> {
            String[] logs = getLogsFromFrame();

            if (FrameManager.validatePassword(logs[PASSWORD_INDEX], logs[REPEATED_PASSWORD_INDEX])) {
                requestServerRegisterUser(logs);
            }
            else {
                AlertController.alertFrame(EventMessage.REGISTER_FAILED.getMessage());
            }
        });
    }

    private void backButtonEvent() {
        backButton.addActionListener(e ->
                FrameManager.changeFrameDisplay(MainController.getMainFrame(), MainController.getRegistrationFrame()));
    }

    private String[] getLogsFromFrame() {
        String login = loginField.getText();
        String password = FrameManager.buildPassword(passwordField.getPassword());
        String repeatedPassword = FrameManager.buildPassword(passwordField1.getPassword());

        return new String[] {login, password, repeatedPassword};
    }

    private void requestServerRegisterUser(String[] logs) {
        RequestServerProcess requestServerProcess = new RequestServerProcess();

        User user = new User(logs[LOGIN_INDEX], logs[PASSWORD_INDEX]);

        requestServerProcess.setUserRequest(user);
        requestServerProcess.run();

        if(requestServerProcess.getUserResponse() != null) {
            AlertController.alertFrame(EventMessage.REGISTER_SUCCESSFUL.getMessage());
        }
        else {
            AlertController.alertFrame(EventMessage.REGISTER_FAILED.getMessage());

        }
    }
}
