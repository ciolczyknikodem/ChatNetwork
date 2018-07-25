package controller;

import utils.FrameDisplay;
import view.MainFrame;
import view.Registration;

import javax.swing.*;

public class MainController {
    private static JFrame mainFrame;
    private static JFrame registrationFrame;

    public static void runApp() {
        mainFrame = new JFrame("SlackLike");

        mainFrame.setContentPane(new MainFrame().getPanelMain());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.pack();
        FrameDisplay.displayCenter(mainFrame);
        mainFrame.setVisible(true);
    }

    public static void runRegistration() {
        registrationFrame = new JFrame("User registration");
        registrationFrame.setContentPane(new Registration().getRegistrationPanel());

        registrationFrame.pack();
        FrameDisplay.displayCenter(registrationFrame);
        registrationFrame.setVisible(true);
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static JFrame getRegistrationFrame() {
        return registrationFrame;
    }
}