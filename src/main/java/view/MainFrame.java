package view;

import javax.swing.*;

public class MainFrame extends JFrame{

    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton registerButton;
    private JButton exitButton;
    private JPanel panelMain;

    public MainFrame() {
        singInEvent();
        exitEvent();
        registrationEvent();
    }

    private void singInEvent() {
        signInButton.addActionListener(e -> {
            String password = buildPassword(passwordField.getPassword());
            String login = loginField.getText();
        });
    }

    private String buildPassword(char[] letters) {
        StringBuilder sb = new StringBuilder();
        for (char letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }

    private void exitEvent() {
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void registrationEvent() {
        registerButton.addActionListener(e -> {
            JFrame registrationFrame = new JFrame("Registration");
            registrationFrame.setContentPane(new Registration().getRegistrationPanel());

            registrationFrame.pack();
            registrationFrame.setVisible(true);

        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
