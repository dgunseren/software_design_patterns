import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CreditAccount implements VisitableAccount {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void CashAccountBalance() {}
    public void SavingAccountBalance() {}
    public void CarLoanAccountBalance() {}
    public void HouseLoanAccountBalance() {}

}
