package hw.field;

import hw.Player;

public class Jail extends Field implements PayRentImpl<Player> {
    public static final int JAIL_TAX = 50_000_000;

    public Jail(int numberField, String nameField) {
        super(numberField, nameField);
    }

    @Override
    public void payRent(Player player) {
        player.setMoney(player.getMoney() - JAIL_TAX);
    }

    @Override
    public String getTestName() {
        return "Jail";
    }
}
