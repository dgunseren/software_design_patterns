import modals.MoneyReserve;

class runner{
    public static void main(String args[]){
        System.out.println("Hello Java");
        MoneyReserve.MONEY_RESERVE.addToReserve(4000);
        System.out.println("total money in reserve " + MoneyReserve.MONEY_RESERVE.getTotalMoneyInReserve());
        MoneyReserve.MONEY_RESERVE.takeFromReserve(2000);
        System.out.println("total money in reserve " + MoneyReserve.MONEY_RESERVE.getTotalMoneyInReserve());
    }
}
