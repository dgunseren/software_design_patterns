package modals.money_handler;

import interfaces.DispenseChain;
import modals.dispensers.Dollar10Dispenser;
import modals.dispensers.Dollar20Dispenser;
import modals.dispensers.Dollar50Dispenser;

public class ATMDispenseChain {

    public DispenseChain c1;

    public ATMDispenseChain() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }



}
