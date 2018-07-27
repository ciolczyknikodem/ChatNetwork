package view.alerts;

import controller.AlertController;
import controller.MainController;
import utils.FrameManager;

import javax.swing.*;

public class AlertRegistration {
    private boolean isSuccessful;
    private JButton acceptButton;
    private JPanel registrationAlertPane;
    private JLabel infoLabel;

    public AlertRegistration(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
        setContextForAlert();
        acceptButtonEvent();
    }

    private void acceptButtonEvent() {
        acceptButton.addActionListener(e -> {
                if(isSuccessful) {
                    FrameManager.changeFrameDisplay(
                            MainController.getMainFrame(), MainController.getRegistrationFrame());
                }
                else {
                    FrameManager.changeFrameDisplay(
                            MainController.getRegistrationFrame(), AlertController.getRegistrationAlert());
                }
        });
    }

    private void setContextForAlert() {
        if(isSuccessful) {
            infoLabel.setText("Register successful!");
        }
        else {
            infoLabel.setText("Registration failed!");
        }
    }

    public JPanel getRegistrationAlertPane() {
        return registrationAlertPane;
    }
}
