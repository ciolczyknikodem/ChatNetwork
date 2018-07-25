
import utils.FramePositioner;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;

public class App {
    private static JFrame mainFrame;

    public static void main(String[] args) {
        mainFrame = new JFrame("SlackLike");

        mainFrame.setContentPane(new MainFrame().getPanelMain());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.pack();
        FramePositioner.display(mainFrame);
        mainFrame.setVisible(true);
    }
}
