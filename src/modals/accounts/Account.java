package modals.accounts;

import modals.interfaces.VisitableAccount;
import modals.interfaces.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Account {

    VisitableAccount[] accounts;
    double[] accountSummary = new double[4];

    public Account() {
        accounts = new VisitableAccount[] {
                new CreditAccount(),
                new CarLoanAccount(),
                new HouseLoanAccount(),
                new SavingsAccount(),
        };
    }

    public double[] accept(Visitor visitor) {
        for(int i = 0; i < accounts.length; i++) {
            accountSummary[i] = accounts[i].accept(visitor);
        }
        return accountSummary;
    }
}
