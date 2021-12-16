package lesson7;

class Plate {

    private int food;

    public int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

     public void increaseFood() {
        this.food += 100;
        System.out.println("В миску добавили 100 грамм корма");
    }

    public boolean checkFood(int n) {
        return (food - n) >= 0;
    }

}
