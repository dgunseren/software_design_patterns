package views;

import controllers.LoginController;
import controllers.SignUpController;
import modals.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class SignUpView extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame("frame");
    private final Container container = new Container();
    private final JButton signUpButton = new JButton("SignUp");
    private final JLabel userLabel = new JLabel("USERNAME");
    private final JLabel passwordLabel = new JLabel("PASSWORD");
    private final JLabel addressLabel = new JLabel("ADDRESS");
    private final JLabel ageLabel = new JLabel("AGE");
    private final JLabel nameLabel = new JLabel("NAME");
    private final JLabel surnameLabel = new JLabel("SURNAME");
    private final JTextField userTextField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField(50);
    private final JTextField addressField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField surnameField = new JTextField();
    private final JTextField ageField = new JTextField();

    public SignUpView() {
        addComponentsToPanel();
        setLocationAndSize();
        addActionListenersToButtons();
        frame.add(container);
        frame.setSize(500,800);
        frame.setVisible(true);
    }

    private void addComponentsToPanel() {
        container.add(userLabel);
        container.add(userTextField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(nameLabel);
        container.add(nameField);
        container.add(surnameLabel);
        container.add(surnameField);
        container.add(addressLabel);
        container.add(addressField);
        container.add(ageLabel);
        container.add(ageField);
        container.add(signUpButton);
    }

    private void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        nameLabel.setBounds(50, 290, 100, 30);
        surnameLabel.setBounds(50, 360, 100, 30);
        addressLabel.setBounds(50, 430, 100, 30);
        ageLabel.setBounds(50, 500, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        nameField.setBounds(150, 290, 150, 30);
        surnameField.setBounds(150, 360, 150, 30);
        addressField.setBounds(150, 430, 150, 30);
        ageField.setBounds(150, 500, 150, 30);
        signUpButton.setBounds(50, 600, 100, 30);
    }

    private void addActionListenersToButtons() {
        signUpButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signUpButton) {
            String email = userTextField.getText();
            String name = nameField.getText();
            String surname = surnameField.getText();
            String address = addressField.getText();
            String age = ageField.getText();
            String password = passwordField.getText();
            Customer customer = new Customer.Builder(email, password).withName(name).withSurname(surname)
                    .withAge(Integer.parseInt(age)).withAddress(address).build();
            SignUpController signUpController = new SignUpController(this, customer);
            if(signUpController.SignUpHandler()) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                new LoginView();
            }
        }
    }
}
