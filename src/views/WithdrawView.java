package views;

import controllers.MainMenuController;
import controllers.TransactionsController;
import controllers.WithdrawController;
import modals.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class WithdrawView extends JFrame implements ActionListener {
    private final Customer customer;
    private final JFrame frame = new JFrame("frame");
    private final Container container = new Container();
    private final JButton withdrawButton = new JButton("WITHDRAW");
    private final JButton backButton = new JButton("BACK");
    private final JLabel amountLabel = new JLabel("AMOUNT:");
    private final JTextField amountField = new JTextField();

    public WithdrawView(Customer customer) {
        this.customer = customer;
        setLocationAndSize();
        addComponentsToPanel();
        addActionListenersToButtons();
        frame.add(container);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    private void addComponentsToPanel() {
        container.add(amountLabel);
        container.add(amountField);
        container.add(withdrawButton);
        container.add(backButton);
    }

    private void setLocationAndSize() {
        amountLabel.setBounds(50, 270, 150, 30);
        amountField.setBounds(150, 270, 150, 30);
        withdrawButton.setBounds(50,340, 250, 30);
        backButton.setBounds(50,380, 250, 30);
    }

    private void addActionListenersToButtons() {
        withdrawButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int amount = Integer.parseInt(amountField.getText());
        if(e.getSource() == withdrawButton) {
            WithdrawController withdrawController = new WithdrawController(customer, this);
            withdrawController.handleWithdraw(amount);
            JOptionPane.showMessageDialog(this, amountField.getText() + " WITHDRAWED FROM YOUR ACCOUNT SUCCESSFULLY.");
        }
        else if(e.getSource() == backButton) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            new MainMenuView(customer);
        }
    }
}
