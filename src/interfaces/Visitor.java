package interfaces;

import modals.accounts.CreditAccount;
import modals.accounts.DebitAccount;

public interface Visitor {
    public void visit(CreditAccount creditAccount);
    public void visit(DebitAccount debitAccount);
}
