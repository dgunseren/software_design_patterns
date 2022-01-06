package views;

import controllers.LoginController;
import controllers.MainMenuController;
import modals.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class LoginView extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame("Bank");
    private final Container container = new Container();
    private final JButton loginButton = new JButton("Login");
    private final JButton signUpButton = new JButton("Sign Up");
    private final JLabel userLabel = new JLabel("USERNAME");
    private final JLabel passwordLabel = new JLabel("PASSWORD");
    private final JTextField userTextField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField(50);

    public LoginView() {
        setLocationAndSize();
        addComponentsToPanel();
        addActionListenersToButtons();
        frame.add(container);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    private void addComponentsToPanel() {
        container.add(userLabel);
        container.add(userTextField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(loginButton);
        container.add(signUpButton);
    }

    private void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        signUpButton.setBounds(50,350, 100, 30);
    }

    private void addActionListenersToButtons() {
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            String email = userTextField.getText();
            String password = passwordField.getText();
            Customer customer = new Customer.Builder(email, password).build();
            LoginController loginController = new LoginController(this, customer);
            customer = loginController.SignInHandler();
            if(customer == null) {
                JOptionPane.showMessageDialog(this, "Authentication FAILED.");
            } else {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                MainMenuView mainMenuView = new MainMenuView(customer);
                new MainMenuController(customer, mainMenuView);
            }
        }
        else if(e.getSource() == signUpButton) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            new SignUpView();
        }
    }
}
