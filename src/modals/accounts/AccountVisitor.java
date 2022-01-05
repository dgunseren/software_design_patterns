package modals.accounts;

import modals.abstracts.AbstractLogger;
import modals.interfaces.Visitor;
import modals.Customer;

public class AccountVisitor implements Visitor {
    private AbstractLogger<String> logger;
    private Customer customer;

    public AccountVisitor(Customer customer, AbstractLogger<String> logger) {
        this.logger = logger;
        this.customer = customer;
    }

    @Override
    public double visit(CreditAccount creditAccount) {
        return creditAccount.displayCreditAccount(this.customer, this.logger);
    }

    @Override
    public double visit(CarLoanAccount carLoanAccount) {
        return carLoanAccount.displayCarLoan(this.customer, this.logger);
    }

    @Override
    public double visit(HouseLoanAccount houseLoanAccount) {
        return houseLoanAccount.displayHouseLoan(this.customer, this.logger);
    }

    @Override
    public double visit(SavingsAccount savingsAccount) {
        return savingsAccount.displaySaving(this.customer, this.logger);
    }
}
