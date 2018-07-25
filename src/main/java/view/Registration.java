package view;

import controller.MainController;
import utils.FrameDisplay;

import javax.swing.*;

public class Registration {
    private JTextField loginTextField;
    private JTextField passwordTextField;
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

    private void backButtonEvent() {
        backButton.addActionListener(e ->
                FrameDisplay.changeFrameDisplay(MainController.getMainFrame(), MainController.getRegistrationFrame()));
    }
}
