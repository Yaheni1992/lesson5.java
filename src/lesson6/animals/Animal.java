package lesson6.animals;

public class Animal {
    protected String name;
    protected int run;
    protected int swim;


    public Animal(String name, int run, int swim) {
        this.name = name;
        this.run = run;
        this.swim = swim;
    }

    public void run() {
        System.out.println(name +"   run");
    }

    public void swim() {
        System.out.println(name +"  swim");
    }

}

