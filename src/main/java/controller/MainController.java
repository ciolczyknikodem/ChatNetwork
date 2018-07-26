package controller;

import client.ClientController;
import model.Client;
import utils.FrameManager;
import view.MainFrame;
import view.Registration;

import javax.swing.*;
import java.io.IOException;

public class MainController {
    private static JFrame mainFrame;
    private static JFrame registrationFrame;

    private static String ipAddress;
    private static int port;
    private static Client user;

    public MainController(String ipAddress, int port) {
        MainController.ipAddress = ipAddress;
        MainController.port = port;
    }

    public static void runApp() {
        mainFrame = new JFrame("SlackLike");

        mainFrame.setContentPane(new MainFrame().getPanelMain());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.pack();
        FrameManager.displayCenter(mainFrame);
        mainFrame.setVisible(true);
    }

    public static void runRegistration() {
        registrationFrame = new JFrame("User registration");
        registrationFrame.setContentPane(new Registration().getRegistrationPanel());

        registrationFrame.pack();
        FrameManager.displayCenter(registrationFrame);
        registrationFrame.setVisible(true);
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static JFrame getRegistrationFrame() {
        return registrationFrame;
    }

    public static String getIpAddress() {
        return ipAddress;
    }

    public static int getPort() {
        return port;
    }

    public static void setUser(Client user) {
        MainController.user = user;
    }
}
