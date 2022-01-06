package controllers;

import modals.Customer;
import modals.abstracts.AbstractLogger;
import modals.accounts.Account;
import modals.accounts.AccountVisitor;
import modals.interfaces.VisitableAccount;
import modals.loggers.ConsoleLogger;
import modals.money_handler.Capital;
import modals.money_handler.DollarObserver;
import modals.money_handler.EuroObserver;
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
        double[] accountSummary = account.accept(new AccountVisitor(customer, logger));
        Capital capital = new Capital();
        EuroObserver euroObs = new EuroObserver(capital);
        DollarObserver dollarObs = new DollarObserver(capital);
        capital.setAmount(customer.getAccountBalance());
        accountSummary[4] = euroObs.getEuroAmount();
        accountSummary[5] = dollarObs.getDollarAmount();
        return accountSummary;
    }
}
