package controller;

import utils.FrameManager;
import view.alerts.AlertFrame;

import javax.swing.*;

public class AlertController {

    private static JFrame alertFrame;

    public static void alertFrame(String message) {
        alertFrame = new JFrame();

        alertFrame.setContentPane(new AlertFrame(message).getAlertPane());
        alertFrame.pack();

        FrameManager.displayCenter(alertFrame);
        alertFrame.setVisible(true);
    }

    public static JFrame getAlertFrame() {
        return alertFrame;
    }
}
