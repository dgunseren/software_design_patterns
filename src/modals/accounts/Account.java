package modals.accounts;

import interfaces.VisitableAccount;
import interfaces.Visitor;

import java.sql.SQLException;

public class Account implements VisitableAccount {

    VisitableAccount[] accounts;

    public Account() throws SQLException {
        accounts = new VisitableAccount[] {
                new CreditAccount(),
                new CarLoanAccount(),
                new HouseLoanAccount(),
                new SavingsAccount(),
        };
    }

    @Override
    public void accept(Visitor visitor) {
        for(int i = 0; i < accounts.length; i++) {
            accounts[i].accept(visitor);
        }
        visitor.visit(this);
    }
}
