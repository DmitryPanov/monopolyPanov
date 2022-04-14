package hw.field;

import hw.Player;

public class Railways extends CostField implements PayRentImpl<Player> {
    static final int RENT_RAILWAY = 25_000_000;

    public Railways(int numberField, String nameField, int price, int rent) {
        super(numberField, nameField);
        this.price = price;
        this.rent = rent;
    }

    @Override
    public void payRent(Player player) {
        player.setMoney(master.getMoney() - RENT_RAILWAY);
        master.setMoney(master.getMoney() + RENT_RAILWAY);
    }
}
