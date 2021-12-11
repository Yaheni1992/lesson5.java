package lesson7;

class Cat {

    private String name;
    private int appetite;
    private int satietyTime;
    private int satiety;

    String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public int getSatietyTime() {
        return satietyTime;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int satietyTime) {

        this.name = name;
        this.appetite = appetite;
        this.satietyTime = satietyTime;
        this.satiety = 0;
    }

    public void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += satietyTime;
    }
}
