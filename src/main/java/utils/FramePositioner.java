package utils;

import javax.swing.*;
import java.awt.*;

public class FramePositioner {

    public static void display(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }
}
