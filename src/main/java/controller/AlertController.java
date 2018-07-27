package controller;

import utils.FrameManager;
import view.alerts.AlertRegistration;

import javax.swing.*;

public class AlertController {

    private static JFrame registrationAlert;

    public static void registrationAlert(boolean isSuccessful) {
        registrationAlert = new JFrame();

        registrationAlert.setContentPane(new AlertRegistration(isSuccessful).getRegistrationAlertPane());
        registrationAlert.pack();

        FrameManager.displayCenter(registrationAlert);
        registrationAlert.setVisible(true);
    }

    public static JFrame getRegistrationAlert() {
        return registrationAlert;
    }
}
