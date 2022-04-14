package hw.field;

import hw.Player;

public class Utility extends CostField implements PayRentImpl<Player> {

    public Utility(int numberField, String nameField, int price) {
        super(numberField, nameField);
        this.price = price;
    }

    @Override
    public void payRent(Player player) {
        long KOEF_RENT = 4;
        long COST = 1_000_000;
        long rent = KOEF_RENT * (player.roll() + player.roll()) * COST;
        player.setMoney(player.getMoney() - rent);
        master.setMoney(master.getMoney() + rent);
    }
}
