package interfaces;

import interfaces.Visitor;
import modals.Customer;

public interface VisitableAccount {
    void accept(Visitor visitor);

}




