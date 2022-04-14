package hw.field;

import hw.Player;

public class Field {
    protected Player player;
    private final int numberField;
    private final String nameField;

    public Field(int numberField, String nameField) {
        this.numberField = numberField;
        this.nameField = nameField;
    }

    @Override
    public String toString() {
        return "Field{" +
                "numberField=" + numberField +
                ", nameField='" + nameField + '\'' +
                '}' + "\n";
    }

    public String getTestName() {
        return "Free";
    }

    public String getNameField() {
        return nameField;
    }

    public Player getPlayer() {
        return player;
    }
}
