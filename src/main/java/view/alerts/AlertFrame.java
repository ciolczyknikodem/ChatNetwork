package view.alerts;

import controller.AlertController;
import controller.MainController;
import utils.FrameManager;

import javax.swing.*;

public class AlertFrame {
    private boolean isSuccessful;
    private JButton acceptButton;
    private JPanel alertPane;
    private JLabel infoLabel;

    public AlertFrame(boolean isSuccessful) {
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
            infoLabel.setText("RegistrationFrame failed!");
        }
    }

    public JPanel getAlertPane() {
        return alertPane;
    }
}
