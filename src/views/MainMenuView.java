package views;

import modals.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame("frame");
    private final Container container = getContentPane();
    private final JLabel welcomeText = new JLabel("");
    private final JLabel address = new JLabel("");
    private final JLabel age = new JLabel("");
    private final JButton balance_button = new JButton("Balance Check");
    private final JButton transfer_button = new JButton("Monetary Transactions");
    private final JButton withdraw = new JButton("Withdraw Cash");

    MainMenuView() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        frame.add(container);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        welcomeText.setBounds(100, 150, 200, 30);
        address.setBounds(100, 200, 200, 30);
        age.setBounds(100, 250, 200, 30);
        balance_button.setBounds(100, 300, 200, 30);
        transfer_button.setBounds(100, 350, 200, 30);
        withdraw.setBounds(100, 400, 200, 30);
    }

    public void addComponentsToContainer() {
        container.add(welcomeText);
        container.add(address);
        container.add(age);
        container.add(balance_button);
        container.add(transfer_button);
        container.add(withdraw);
    }

    public void addActionEvent() {
        balance_button.addActionListener(this);
        transfer_button.addActionListener(this);
        withdraw.addActionListener(this);
    }

    public void updateCustomerInformation(Customer customer) {
       welcomeText.setText("Welcome " + customer.getName() + " " + customer.getSurname());
       address.setText("ADDRESS: " + customer.getAddress());
       age.setText("AGE: " + Integer.toString(customer.getAge()));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == balance_button) {

        }
        else if (e.getSource() == transfer_button) {

        }
        else if (e.getSource() == withdraw) {

        }
    }
}





