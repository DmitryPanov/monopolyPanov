package hw.field;

import hw.Player;

public class Tax extends Field implements PayRentImpl<Player> {
    public static final int TAXES = 200_000_000;
    public static final int SUPER_TAXES = 100_000_000;

    public Tax(int numberField, String nameField) {
        super(numberField, nameField);
    }

    @Override
    public void payRent(Player player) {
        if (getNameField().equals("Сверхналог")) {
            player.setMoney(player.getMoney() - SUPER_TAXES);
        }
        player.setMoney(player.getMoney() - TAXES);
    }

    @Override
    public String getTestName() {
        return "Tax";
    }
}
