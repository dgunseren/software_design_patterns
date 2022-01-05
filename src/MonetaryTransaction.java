import modals.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonetaryTransaction extends JFrame implements ActionListener {
    public static Customer atakanLogsIn;
    public static Customer denizLogsIn;



    Container container = getContentPane();
    JLabel toLabel = new JLabel("TO");
    JLabel userLabel = new JLabel("FROM");
    //JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField toTextField = new JTextField();
    JTextField fromTextField = new JTextField();
    //JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    //JCheckBox showPassword = new JCheckBox("Show Password");




    MonetaryTransaction() {
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

        //passwordLabel.setBounds(50, 220, 100, 30);
        //userTextField.setBounds(150, 150, 150, 30);
        //passwordField.setBounds(150, 220, 150, 30);
        //showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);

        container.add(loginButton);
        container.add(resetButton);

    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {



        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {


        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {

        }
        //Coding Part of showPassword JCheckBox

    }

}


