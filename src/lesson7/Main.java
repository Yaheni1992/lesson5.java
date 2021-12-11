package lesson7;


public class Main {
    private static int TIME = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Вискас", 30, 1);
        cat[1] = new Cat("бурый", 20, 2);
        cat[2] = new Cat("белый", 10, 3);
        Plate plate = new Plate(100);
        System.out.println("У Нас есть три кота: " + cat[0].getName() + ", " + cat[1].getName() + " и " + cat[2].getName() + ", которые хотят есть " + cat[0].getSatietyTime() + ", " + cat[1].getSatietyTime() + " и " + cat[2].getSatietyTime() + " час(а) соответственно.");
        System.out.println("Кто-то из них более прожорлив, кто-то менее. Сейчас в миске " + plate.getFood() + "\n");

        do {
            for (Cat i : cat) {

                if (i.getSatiety() == 0) {


                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }

                    i.eat(plate);
                    System.out.println("Кот " + i.getName() + " съел " + i.getAppetite() + " граммов корма и проголодается через " + (i.getSatiety()) + " часа(ов)");
                }

                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС момента начала кормежки прошел(ло) " + TIME + " час(а). В миске осталось " + plate.getFood() + " граммов корма.\n");
            TIME++;

        } while (TIME <= 3);
    }
}
