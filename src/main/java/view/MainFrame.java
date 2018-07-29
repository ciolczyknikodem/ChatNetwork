package view;

import controller.AlertController;
import controller.MainController;
import controller.RequestServerProcess;
import model.User;
import utils.EventMessage;
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

            handleLoginUser(login, password);
            // TODO: open chat frame with User instance
        });
    }


    private void registrationEvent() {
        registerButton.addActionListener(e -> {
            MainController.runRegistration();
            FrameManager.changeFrameDisplay(MainController.getRegistrationFrame(), MainController.getMainFrame());

        });
    }

    private synchronized void handleLoginUser(String login, String password) {
        RequestServerProcess requestServer = new RequestServerProcess();
        User user = new User(login, password);

        requestServer.setUserRequest(user);

        if(requestServer.getUserResponse() != null) {
            AlertController.alertFrame(EventMessage.LOGIN_SUCCESSFUL.getMessage());
            // TODO: Action --> open chat Frame for user
        }
        else {
            AlertController.alertFrame(EventMessage.LOGIN_FAILED.getMessage());
            // TODO: Import user from DB went wrong!
        }
    }

    private void exitEvent() {
        exitButton.addActionListener(e -> System.exit(0));
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
