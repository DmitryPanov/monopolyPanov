package hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hw.Monopoly.*;

public class Main {
    static List<Player> listPlayer = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.start(BEAR, BALALAIKA);

        while (true) {
            System.out.println("Добро пожаловать в игру монополия." + "\n");
            for (int j = 0; j < listPlayer.size(); j++) {
                System.out.println("Игрок номер " + (j + 1) + " бросайте кубик");

                int first = (int) (Math.random() * ((MAX - MIN) + 1)) + MIN;
                int second = (int) (Math.random() * ((MAX - MIN) + 1)) + MIN;
                if (listPlayer.get(j).inPrison()) {
                    listPlayer.get(j).goOutPrison();
                } else {
                    listPlayer.get(j).rollDice(first, second);
                }
                System.out.println("Количество денег у игрока " + listPlayer.get(j).getMoney());
                if (listPlayer.get(j).bunkrupt()) {
                    listPlayer.remove(j);
                    return;
                }
                listPlayer.get(j).goToJail();
                System.out.println("---------------------------------------------");
            }
        }
    }

    void start(String... chips) {
        if (!doubleValue(chips) || !isThrownBy(chips)) {
            throw new RuntimeException("MISTAKE");
        }
        for (String chip : chips) {
            listPlayer.add(new Player(chip));
        }
    }

    boolean doubleValue(String... value) {
        return Arrays.stream(value).distinct().count() == value.length;
    }

    public boolean isThrownBy(String... chips) {
        return chips.length >= MIN_PLAYER && chips.length <= MAX_PLAYER;
    }
}
