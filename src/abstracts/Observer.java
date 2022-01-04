package abstracts;

import modals.money_handler.Capital;

public abstract class Observer {
    protected Capital capital;
    public abstract void update();
}
