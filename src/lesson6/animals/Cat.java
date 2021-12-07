package lesson6.animals;

public class Cat extends Animal {

    private final int DEFAULT_RUN = 200;
    private final int DEFAULT_SWIM = 0;

    public Cat(String name, int run, int swim) {
        super(name, run, run);
    }

    public void swim() {
        System.out.println(name + "  swim.cat,не умеет плавать");
    }

    public void run() {
        System.out.println(name + "   run.cat, пробежал 200м");
    }
}
