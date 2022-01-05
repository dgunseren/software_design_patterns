package controllers;

import modals.Customer;
import views.MainMenuView;

public class MainMenuController {
    private Customer customer;
    private MainMenuView mainMenuView;

    public MainMenuController(Customer customer, MainMenuView mainMenuView) {
        this.customer = customer;
        this.mainMenuView = mainMenuView;
        updateView();
    }

    private void updateView() {
        mainMenuView.updateCustomerInformation(customer);
    }
}
