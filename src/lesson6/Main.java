package lesson6;

import lesson6.animals.*;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Myrzik", 200, 0);
        Dog dog = new Dog("Blackie", 10, 500);

        cat.run();
        cat.swim();
        dog.run();
        dog.swim();
    }
}
