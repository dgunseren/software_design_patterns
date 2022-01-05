package controllers;

import modals.Customer;
import modals.abstracts.AbstractLogger;
import modals.loggers.ConsoleLogger;
import modals.loggers.DatabaseLogger;
import views.LoginView;

public class LoginController {
    AbstractLogger<String> logger = new ConsoleLogger();
    private LoginView loginView;
    private Customer customer;

    public LoginController(LoginView loginView, Customer customer) {
        this.loginView = loginView;
        this.customer = customer;
    }

    public Customer SignInHandler() {
        logger = new DatabaseLogger();
        return customer.signIn(logger);
    }
}
