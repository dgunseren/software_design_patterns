import abstracts.AbstractLogger;
import interfaces.VisitableAccount;
import modals.accounts.Account;
import modals.accounts.AccountVisitor;
import modals.loggers.ConsoleLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame implements ActionListener {


    Container container = getContentPane();
    //JLabel userLabel = new JLabel("USERNAME");
    //JLabel passwordLabel = new JLabel("PASSWORD");
    //JTextField userTextField = new JTextField();
    //JPasswordField passwordField = new JPasswordField();
   // JButton loginButton = new JButton("LOGIN");
   // JButton resetButton = new JButton("RESET");

    JButton balance_button = new JButton("Balance Check");
    JButton transfer_button = new JButton("Monetary Transactions");
    JButton withdraw = new JButton("Withdraw Cash");






    //JCheckBox showPassword = new JCheckBox("Show Password");


    Menu() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {

        container.setLayout(null);
    }

    public void setLocationAndSize() {
        //userLabel.setBounds(50, 150, 100, 30);
        //passwordLabel.setBounds(50, 220, 100, 30);
        //userTextField.setBounds(150, 150, 150, 30);
        // passwordField.setBounds(150, 220, 150, 30);
        ////showPassword.setBounds(150, 250, 150, 30);
      //  loginButton.setBounds(50, 300, 100, 30);
        //resetButton.setBounds(200, 300, 100, 30);

        balance_button.setBounds(100, 300, 200, 30);
        transfer_button.setBounds(100, 350, 200, 30);
        withdraw.setBounds(100, 400, 200, 30);






    }

    public void addComponentsToContainer() {


        container.add(balance_button);
        container.add(transfer_button);
        container.add(withdraw);

    }

    public void addActionEvent() {
        //loginButton.addActionListener(this);
        //resetButton.addActionListener(this);
        balance_button.addActionListener(this);
        transfer_button.addActionListener(this);
        withdraw.addActionListener(this);
        // showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        //MoneyReserve.MONEY_RESERVE.addToReserve(4000, logger);
        //MoneyReserve.MONEY_RESERVE.takeFromReserve(2000, logger);


        //Coding Part of LOGIN button
        if (e.getSource() == balance_button) {
            try {
                AbstractLogger<String> logger = new ConsoleLogger();

                VisitableAccount   account = new Account();
                account.accept(new AccountVisitor(LoginFrame.atakanLogsIn, logger));
                String string = new String("derj");
                JOptionPane.showMessageDialog(this, string);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else {
        }


        //Coding Part of RESET button
        if (e.getSource() == transfer_button) {
            MonetaryTransaction monet = new MonetaryTransaction();
            monet.setTitle("Login Form");
            monet.setVisible(true);
            monet.setBounds(10, 10, 370, 600);
            monet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            monet.setResizable(false);
        } else {
        }

        if (e.getSource() == withdraw) {
        } else {
        }


    }
}





