package modals.dispensers;

import interfaces.DispenseChain;

public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(double cur) {
        if(cur >= 50){
            double num = cur/50;
            double remainder = cur % 50;
            System.out.println("Dispensing "+num+" 50$ note");
            if(remainder !=0) this.chain.dispense(remainder);
        }else{
            this.chain.dispense(cur);
        }
    }

}
