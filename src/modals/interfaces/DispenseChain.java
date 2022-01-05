package modals.interfaces;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(double cur);
}
