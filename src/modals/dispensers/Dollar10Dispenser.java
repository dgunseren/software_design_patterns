package modals.dispensers;

import interfaces.DispenseChain;

public class Dollar10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(double cur) {
        if(cur >= 10){
            double num = cur/10;
            double remainder = cur % 10;
            System.out.println("Dispensing "+num+" 10$ note");
            if(remainder !=0) this.chain.dispense(remainder);
        }else{
            this.chain.dispense(cur);
        }
    }

}
