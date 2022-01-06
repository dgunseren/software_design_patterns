package controllers;

import modals.Customer;
import modals.money_handler.ATMDispenseChain;
import views.WithdrawView;

public class WithdrawController {
    private Customer customer;
    private WithdrawView withdrawView;

    public WithdrawController(Customer customer, WithdrawView withdrawView) {
        this.customer = customer;
        this.withdrawView = withdrawView;
    }

    public void handleWithdraw(int amount) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        atmDispenser.c1.dispense(amount);
        customer.setAccountBalance(customer.getAccountBalance() - amount);
    }
}
