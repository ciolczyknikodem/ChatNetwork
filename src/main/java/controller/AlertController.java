package controller;

import utils.FrameManager;
import view.alerts.AlertFrame;

import javax.swing.*;

public class AlertController {

    private static JFrame registrationAlert;

    public static void registrationAlert(String message) {
        registrationAlert = new JFrame();

        registrationAlert.setContentPane(new AlertFrame(message).getAlertPane());
        registrationAlert.pack();

        FrameManager.displayCenter(registrationAlert);
        registrationAlert.setVisible(true);
    }

    public static JFrame getRegistrationAlert() {
        return registrationAlert;
    }
}
