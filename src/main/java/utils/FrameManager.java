package utils;

import controller.RegistrationProcess;
import dao.UserResources;
import model.Client;

import javax.swing.*;
import java.awt.*;

public class FrameManager {

    public static void displayCenter(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }

    public static void changeFrameDisplay(JFrame frameToShow, JFrame frameToHide) {
        frameToHide.setVisible(false);
        frameToShow.setVisible(true);

    }

    public static String buildPassword(char[] letters) {
        StringBuilder sb = new StringBuilder();
        for (char letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }

    public static boolean registerNewUser(String login, String password) {
        UserResources userResources = new UserResources();

        Client user = new Client(login, password);
        return userResources.add(user);
    }

    public static boolean validatePassword(String firstInput, String secondInput) {
        return firstInput.equals(secondInput);
    }
}
