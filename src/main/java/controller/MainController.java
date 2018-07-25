package controller;

import utils.FramePositioner;
import view.MainFrame;

import javax.swing.*;

public class MainController {
    private static JFrame mainFrame;

    public void runApp() {
        mainFrame = new JFrame("SlackLike");

        mainFrame.setContentPane(new MainFrame().getPanelMain());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.pack();
        FramePositioner.display(mainFrame);
        mainFrame.setVisible(true);
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }
}
