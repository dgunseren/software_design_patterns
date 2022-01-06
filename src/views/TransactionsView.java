package views;

import controllers.TransactionsController;
import modals.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionsView extends JFrame implements ActionListener {
    private final Customer customer;
    private final JFrame frame = new JFrame("frame");
    private final Container container = new Container();
    private final JButton fastTransferButton = new JButton("FAST TRANSFER");
    private final JButton bulkTransferButton = new JButton("BULK TRANSFER");
    private final JLabel toLabel = new JLabel("TO:");
    private final JLabel amountLabel = new JLabel("AMOUNT:");
    private final JTextField toField = new JTextField();
    private final JTextField amountField = new JTextField();

    public TransactionsView(Customer customer) {
        this.customer = customer;
        setLocationAndSize();
        addComponentsToPanel();
        addActionListenersToButtons();
        frame.add(container);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    private void addComponentsToPanel() {
        container.add(toLabel);
        container.add(toField);
        container.add(amountLabel);
        container.add(amountField);
        container.add(fastTransferButton);
        container.add(bulkTransferButton);
    }

    private void setLocationAndSize() {
        toLabel.setBounds(50, 220, 100, 30);
        toField.setBounds(150, 220, 150, 30);
        amountLabel.setBounds(50, 270, 150, 30);
        amountField.setBounds(150, 270, 150, 30);
        fastTransferButton.setBounds(50, 310, 250, 30);
        bulkTransferButton.setBounds(50,340, 250, 30);
    }

    private void addActionListenersToButtons() {
        fastTransferButton.addActionListener(this);
        bulkTransferButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String to = toField.getText();
        int amount = Integer.parseInt(amountField.getText());
        if(e.getSource() == fastTransferButton) {
            TransactionsController controller = new TransactionsController(customer, this);
            if(controller.handleFastTransfer(to, amount)) {
                JOptionPane.showMessageDialog(this, "FAST TRANSACTION SENT.");
            } else {
                JOptionPane.showMessageDialog(this, "TRANSACTION FAILED.");
            }
        }
        else if(e.getSource() == bulkTransferButton) {
            TransactionsController controller = new TransactionsController(customer, this);
            if(controller.handleBulkTransfer(to, amount)){
                JOptionPane.showMessageDialog(this, "FAST TRANSACTION SENT.");
            }else {
                JOptionPane.showMessageDialog(this, "TRANSACTION FAILED.");
            }
        }
    }
}
