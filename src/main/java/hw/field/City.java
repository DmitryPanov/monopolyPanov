package hw.field;

public class City extends CostField {

    private final String color;

    public City(int numberField, String nameField, int price, int rent, String color) {
        super(numberField, nameField);
        this.price = price;
        this.rent = rent;
        this.color = color;
    }

    @Override
    public String toString() {
        return "City{" +
                "color='" + color + '\'' + '}' + super.toString();
    }

    public String getColor() {
        return color;
    }
}
