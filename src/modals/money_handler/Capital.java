package modals.money_handler;

import modals.abstracts.Observer;

import java.util.ArrayList;
import java.util.List;

public class Capital {

    private List<Observer> observers = new ArrayList<Observer>();
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
