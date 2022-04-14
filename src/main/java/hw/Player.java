package hw;

import hw.field.CostField;
import hw.field.Field;
import hw.field.Tax;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static hw.Monopoly.MAX;
import static hw.Monopoly.MIN;
import static hw.field.Jail.JAIL_TAX;

public class Player {
    private static final long START_CASH = 1_500_000_000L;
    private static final long SALARY = 200_000_000;
    private final String name;
    Set<Field> listPropertis = new HashSet<>();
    private int countTry = 0;
    private Field field;
    private int position = 0;
    private boolean arrest = false;
    private long money = START_CASH;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

    void rollDice(int first, int second) {
        System.out.println("First: " + first + " Second: " + second);
        boolean bool = rollTwice(first, second);
        int sum = first + second;
        int countTryDouble = 1;
        while (bool) {
            countTryDouble++;
            int f = roll();
            int s = roll();
            System.out.println("f " + f + " s " + s);
            sum = sum + f + s;
            if (countTryDouble == 3 && rollTwice(f, s)) {
                jail();
                return;
            }
            bool = rollTwice(f, s);
        }
        System.out.println(this + " " + getPosition());
        position += sum;
        circle();
        whereIS();
    }

    private void circle() {
        if (position >= 40) {
            position = position % 40;
            money += SALARY;
        }
    }

    private void jail() {
        setPosition(10);
        arrest = true;
    }

    void goToJail() {
        if (getPosition() == 30) {
            jail();
        }
    }

    public void goOutPrison() {
        String answer = askPlayer();
        switch (answer) {
            case "y":
                System.out.println("Вы выбрали заплатить налог");
                money -= JAIL_TAX;
                arrest = false;
                System.out.println("Бросьте кубики и переместитесь на указанное количество ячеек");
                setPosition(position + roll() + roll());
                System.out.println("Own " + listPropertis + " player " + this + " field " + returnField());
                break;
            case "n":
                System.out.println("Выбрали Нет");
                System.out.println("Бросьте кубики если бужет дубль можете выйти бесплатно , у Вас 3 попытки");
                int first = roll();
                int second = roll();
                System.out.println("Выпали значения первое " + first + " Второе " + second + ".Количество попыток: " + countTry + 1);
                if (rollTwice(first, second)) {
                    setPosition(position + 2 * first);
                    arrest = false;
                } else {
                    if (countTry == 2) {
                        money -= JAIL_TAX;
                        setPosition(position + first + second);
                        arrest = false;
                    }
                    System.out.println(countTry);
                    countTry++;
                }
                break;
            default:
                throw new RuntimeException("New Exception");
        }
    }

    private String askPlayer() {
        String answer;
        do {
            System.out.println("Заплатите налог " + this + " или попробуйте бросить кубик? Ответ Y/N");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine().toLowerCase();
            System.out.println(answer);
        } while (!(answer.equals("y") || answer.equals("n")));
        return answer;
    }

    boolean inPrison() {
        return arrest;
    }

    public int roll() {
        return (int) (Math.random() * ((MAX - MIN) + 1)) + MIN;
    }

    public boolean rollTwice(int first, int second) {
        return first == second;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Field returnField() {
        return Monopoly.field[getPosition()];
    }

    public void addProperty(Field fieldPosition) {
        if (fieldPosition instanceof CostField) {
            listPropertis.add(fieldPosition);
        }
    }

    public void buyField(CostField costField) {
        money -= costField.getPrice();
        addProperty(costField);
        costField.setProperty(true);
        costField.setMaster(this);
        System.out.println(this + " количество денег осталось " + money);
        System.out.println("В собственности " + listPropertis);
    }

    private void payRent(CostField costField) {
        System.out.println("Don't buy pay rent ");
        money -= costField.getRent();
        costField.getMaster().money += costField.getRent();
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public void whereIS() {
        field = returnField();
        String nameField = field.getTestName();
        switch (nameField) {
            case "Free":
                System.out.println("Free parking");
                break;
            case "CostField":
                payMoney(this);
                break;
            case "Tax":
                System.out.println("Pay tax");
                ((Tax) field).payRent(this);
                System.out.println("See what happen");
                break;
            case "Jail":
                System.out.println("In jail freely");
                if (this.inPrison()) {
                    System.out.println("Pay money and go away");
                    this.goOutPrison();
                } else {
                    System.out.println("Just watcher");
                }
                break;
            default:
                throw new RuntimeException("New mistake");
        }
    }

    private void payMoney(Player player) {
        CostField costField = (CostField) field;
        if (costField.getMaster() == null) {
            System.out.println("Try buy field");
            player.buyField(costField);
        } else {
            System.out.println("Try pay rent");
            player.payRent(costField);
        }
    }

    boolean bunkrupt() {
        return money < 0;
    }
}
