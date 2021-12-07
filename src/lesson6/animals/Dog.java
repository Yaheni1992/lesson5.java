package lesson6.animals;

public class  Dog extends Animal {

    private final int DEFAULT_RUN = 500;
    private final int DEFAULT_SWIM = 10;

    public Dog(String name,int run, int swim) {
        super(name,run, swim);


    }
    public void run() {
        System.out.println(name +"   run.dog,пробежал 500м");
    }

    public void swim() {
        System.out.println(name +"  swim.dog,проплыл 10м");
    }

}
