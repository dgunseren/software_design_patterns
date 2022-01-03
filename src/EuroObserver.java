public class EuroObserver extends Observer{
    private double rate = 0.06523157208;
    public EuroObserver(Capital capital) {
        this.capital = capital;
        this.capital.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "In Euros: " + capital.getAmount() * rate );
    }
}
