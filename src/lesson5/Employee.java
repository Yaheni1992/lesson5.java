package lesson5;

public class Employee {
    public Employee() {
    }

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.printf("Employee: %s %s %s %s %d %d\n", name, position, email, phone, salary, age);
    }

    public void print() {
        System.out.println(this);
    }

    public void SetAge(int age) {
        if (age >= 0) {
            System.out.println("Возраст от 40 лет");
            return;
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("\n\tИмя: %s:\t\tДолжность: %s\tEmail: %s\tНомер телефона: %s\tЗарплата: %d\tВозраст: %d\n", name, position, email, phone, salary, age);
    }


    public int getAge() {
        return age;
    }
}
