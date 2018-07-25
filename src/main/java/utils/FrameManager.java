package utils;

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
}
