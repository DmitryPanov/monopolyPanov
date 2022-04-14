package hw;

import hw.field.*;

public class Monopoly {
    protected static final String KREMLIN = "Kremlin";
    protected static final String COSMONAUT = "Cosmonaut";
    protected static final String POINTE = "Pointe";
    protected static final String BEAR = "Bear";
    protected static final String MATRYOSHKA = "Matryoshka";
    protected static final String BALALAIKA = "Balalaika";
    protected static final String BROWN = "brown_square";
    protected static final String BLACK = "black_large_square";
    protected static final String PURPLE = "purple_square";
    protected static final String ORANGE = "orange_square";
    protected static final String RED = "red_square";
    protected static final String YELLOW = "yellow_square";
    protected static final String GREEN = "green_square";
    protected static final String BLUE = "blue_square";
    static final byte MIN_PLAYER = 2;
    static final byte MAX_PLAYER = 6;
    static final byte MIN = 1;
    static final byte MAX = 6;
    static final int RENT_RAILWAY = 25_000_000;
    static final int PRICE_RAILWAY = 200_000_000;
    //    static Map<String,Integer> colorCity = new HashMap<>();
//    protected static int brownCount = 0;
//    protected static int blackCount = 0;
//    protected static int purpleCount = 0;
//    protected static int orangeCount = 0;
//    protected static int redCount = 0;
//    protected static int yellowCount = 0;
//    protected static int greenCount = 0;
//    protected static int blueCount = 0;
//
//
//    static void putElement(){
//        colorCity.put(BROWN,brownCount);
//        colorCity.put(BLACK,blackCount);
//        colorCity.put(PURPLE,purpleCount);
//        colorCity.put(ORANGE,orangeCount);
//        colorCity.put(RED,redCount);
//        colorCity.put(YELLOW,yellowCount);
//        colorCity.put(GREEN,greenCount);
//        colorCity.put(BLUE,blueCount);
//    }
    static Field[] field = {
            new Field(0, "Вперед"),
            new City(1, "Тюмень", 60_000_000, 2_000_000, BROWN),
            new Field(2, "Бесплатная_стоянка"),
            new City(3, "Самара", 60_000_000, 4_000_000, BROWN),
            new Tax(4, "Подоходный_налог"),
            new Railways(5, "Рижская_железная_дорога", PRICE_RAILWAY, RENT_RAILWAY),
            new City(6, "Калуга", 100_000_000, 6_000_000, BLACK),
            new Field(7, "Бесплатная_стоянка"),
            new City(8, "Пермь", 100_000_000, 6_000_000, BLACK),
            new City(9, "Томск", 120_000_000, 8_000_000, BLACK),
            new Jail(10, "В_тюрьме"),
            new City(11, "Уфа", 140_000_000, 10_000_000, PURPLE),
            new Utility(12, "Электростанция", 150_000_000),
            new City(13, "Казань", 140_000_000, 10_000_000, PURPLE),
            new City(14, "Краснодар", 160_000_000, 12_000_000, PURPLE),
            new Railways(15, "Курская_железная_дорога", PRICE_RAILWAY, RENT_RAILWAY),
            new City(16, "Архангельск", 180_000_000, 14_000_000, ORANGE),
            new Field(17, "Бесплатная_стоянка"),
            new City(18, "Челябинск", 180_000_000, 14_000_000, ORANGE),
            new City(19, "Нижний Новгород", 200_000_000, 16_000_000, ORANGE),
            new Field(20, "Бесплатная_стоянка"),
            new City(21, "Омск", 220_000_000, 18_000_000, RED),
            new Field(22, "Бесплатная_стоянка"),
            new City(23, "Волгоград", 220_000_000, 18_000_000, RED),
            new City(24, "Белгород", 240_000_000, 20_000_000, RED),
            new Railways(25, "Казанская_железная_дорога", PRICE_RAILWAY, RENT_RAILWAY),
            new City(26, "Ставрополь", 260_000_000, 22_000_000, YELLOW),
            new City(27, "Ростов", 260_000_000, 22_000_000, YELLOW),
            new Utility(28, "Водопровод", 150_000_000),
            new City(29, "Хабаровск", 280_000_000, 24_000_000, YELLOW),
            new Jail(30, "Отправляйтесь_в_тюрьму"),
            new City(31, "Екатеринбург", 300_000_000, 26_000_000, GREEN),
            new City(32, "Владивосток", 300_000_000, 26_000_000, GREEN),
            new Field(33, "Бесплатная_стоянка"),
            new City(34, "Санкт-Петербург", 320_000_000, 28_000_000, GREEN),
            new Railways(35, "Ленинградская_железная_дорога", PRICE_RAILWAY, RENT_RAILWAY),
            new Field(36, "Бесплатная_стоянка"),
            new City(37, "Москва", 350_000_000, 35_000_000, BLUE),
            new Tax(38, "Сверхналог"),
            new City(39, "Новосибирск", 400_000_000, 50_000_000, BLUE)
    };
}
