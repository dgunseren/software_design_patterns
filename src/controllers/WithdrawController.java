package controllers;

import modals.Customer;
import modals.abstracts.AbstractLogger;
import modals.loggers.ConsoleLogger;
import modals.money_handler.ATMDispenseChain;
import modals.money_handler.MoneyReserve;
import views.MainMenuView;
import views.WithdrawView;


public class WithdrawController {
    AbstractLogger<String> logger = new ConsoleLogger();
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
        MoneyReserve.MONEY_RESERVE.takeFromReserve(amount, logger);
        withdrawView.updateCustomer(customer);
    }
}
