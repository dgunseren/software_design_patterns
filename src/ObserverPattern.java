public class ObserverPattern {

    public static void main(String[] args) {
        Capital capital = new Capital();
        new EuroObserver(capital);
        new DollarObserver(capital);

        System.out.println("Your Balance :");
        capital.setAmount(1000);

    }
}
