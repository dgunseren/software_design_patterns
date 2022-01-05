package controllers;

import modals.Customer;
import modals.abstracts.AbstractLogger;
import modals.accounts.Account;
import modals.accounts.AccountVisitor;
import modals.interfaces.VisitableAccount;
import modals.loggers.ConsoleLogger;
import views.MainMenuView;

import java.util.List;

public class MainMenuController {
    AbstractLogger<String> logger = new ConsoleLogger();
    private Customer customer;
    private MainMenuView mainMenuView;

    public MainMenuController(Customer customer, MainMenuView mainMenuView) {
        this.customer = customer;
        this.mainMenuView = mainMenuView;
        updateView();
    }

    public void updateView() {
        mainMenuView.updateCustomerInformation(customer);
        mainMenuView.updateCustomerAccountSummary(collectCustomerBalanceSummary());
    }

    private double[] collectCustomerBalanceSummary() {
        Account account = new Account();
        return account.accept(new AccountVisitor(customer, logger));
    }
}
