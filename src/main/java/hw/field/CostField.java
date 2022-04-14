package hw.field;

import hw.Player;

public class CostField extends Field {
    protected int price;
    protected Player master;
    protected int rent;
    protected boolean property = false;

    public CostField(int numberField, String nameField) {
        super(numberField, nameField);
    }

    public int getPrice() {
        return price;
    }

    public Player getMaster() {
        return master;
    }

    public void setMaster(Player master) {
        this.master = master;
    }

    public boolean isProperty() {
        return property;
    }

    public void setProperty(boolean property) {
        this.property = property;
    }

    public int getRent() {
        return rent;
    }

    @Override
    public String getTestName() {
        return "CostField";
    }
}
