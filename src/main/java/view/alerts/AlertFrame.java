package view.alerts;

import controller.AlertController;
import controller.MainController;
import utils.AppEvents;
import utils.FrameManager;

import javax.swing.*;

public class AlertFrame {
    private String message;
    private JButton acceptButton;
    private JPanel alertPane;
    private JLabel infoLabel;

    public AlertFrame(String message) {
        this.message = message;
        setContextForAlert();
        acceptButtonEvent();
    }

    private void acceptButtonEvent() {
        acceptButton.addActionListener(e -> {
                registerEvent();
        });
    }

    private void setContextForAlert() {
        if(message.equals(AppEvents.REGISTER_SUCCESSFUL.getMessage())) {
            infoLabel.setText("Register successful!");
        }
        else {
            infoLabel.setText("RegistrationFrame failed!");
        }
    }

    private void registerEvent() {
        if(message.equals(AppEvents.REGISTER_SUCCESSFUL.getMessage())) {
            FrameManager.changeFrameDisplay(
                    MainController.getMainFrame(), MainController.getRegistrationFrame());
        }
        else {
            FrameManager.changeFrameDisplay(
                    MainController.getRegistrationFrame(), AlertController.getRegistrationAlert());
        }
    }


    public JPanel getAlertPane() {
        return alertPane;
    }
}
