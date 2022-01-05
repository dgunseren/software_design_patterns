package controllers;

import modals.Customer;
import modals.abstracts.AbstractLogger;
import modals.loggers.ConsoleLogger;
import modals.loggers.DatabaseLogger;
import views.LoginView;
import views.SignUpView;

public class SignUpController {
    AbstractLogger<String> logger = new ConsoleLogger();
    private SignUpView signUpView;
    private Customer customer;

    public SignUpController(SignUpView signUpView, Customer customer) {
        this.signUpView= signUpView;
        this.customer = customer;
    }

    public boolean SignUpHandler() {
        return customer.signUp(logger);
    }
}
