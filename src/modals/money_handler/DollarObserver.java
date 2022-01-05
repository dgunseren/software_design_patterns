package modals.money_handler;

import modals.abstracts.Observer;

public class DollarObserver extends Observer {
    private double rate = 0.074;
    public DollarObserver(Capital capital) {
        this.capital = capital;
        this.capital.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "In USD: " + capital.getAmount() * rate );
    }
}
