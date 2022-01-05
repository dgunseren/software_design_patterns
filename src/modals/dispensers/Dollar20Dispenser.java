package modals.dispensers;

import modals.interfaces.DispenseChain;

public class Dollar20Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(double cur) {
        if(cur >= 20){
            double num = cur/20;
            double remainder = cur % 20;
            System.out.println("Dispensing "+num+" 20$ note");
            if(remainder !=0) this.chain.dispense(remainder);
        }else{
            this.chain.dispense(cur);
        }
    }

}
