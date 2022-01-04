import abstracts.AbstractLogger;
import modals.Customer;
import modals.DBConnection;
import modals.loggers.ConsoleLogger;
import modals.loggers.DatabaseLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginFrame extends JFrame implements ActionListener {




    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    //JCheckBox showPassword = new JCheckBox("Show Password");


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {

        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        //showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        //container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
       // showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        DBConnection.DB_CONN.startConnection();
        AbstractLogger<String> logger = new ConsoleLogger();
        int deniz_count = 0;
        int ata_count = 0;

        //MoneyReserve.MONEY_RESERVE.addToReserve(4000, logger);
        //MoneyReserve.MONEY_RESERVE.takeFromReserve(2000, logger);
        try {
            logger = new DatabaseLogger();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("deniz.gunseren@ozu.edu.tr") && pwdText.equalsIgnoreCase("denizpass")) {
                Customer deniz = new Customer.Builder("deniz.gunseren@ozu.edu.tr", "denizpass")
                        .withName("Deniz").withSurname("Gunseren").withAddress("Besiktas").withSalary(3500).withAge(24).build();

                try {
                    deniz.signUp(logger);
                    JOptionPane.showMessageDialog(this, "Login Successful");

                    Menu frame = new Menu();
                    frame.setTitle("Main Menu");
                    frame.setVisible(true);
                    frame.setBounds(10, 10, 370, 600);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            else if(userText.equalsIgnoreCase("ataman.atik@ozu.edu.tr") && pwdText.equalsIgnoreCase("mypass")){

                Customer atakan = new Customer.Builder("ataman.atik@ozu.edu.tr", "mypass")
                        .withName("Atakan").withSurname("Atik").withAddress("Atasehir").withSalary(2400).withAge(24).build();
                try {
                    atakan.signUp(logger);
                    JOptionPane.showMessageDialog(this, "Login Successful");


                    Menu frame = new Menu();
                    frame.setTitle("Main Menu");
                    frame.setVisible(true);
                    frame.setBounds(10, 10, 370, 600);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setResizable(false);

                } catch (SQLException ex) {ex.printStackTrace();}

            }
            else {JOptionPane.showMessageDialog(this, "Invalid Username or Password");}

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox

    }

}

