package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] Employees = new Employee[6];
        Employees[0] = new Employee("Andrey Zhimko Stepanovich", "mechanic", "andrey@mail.ru", "+375297418520", 2000, 32);
        Employees[1] = new Employee("Svetlana Karduk Stepanovna", "accountant", "Svetik@mail.ru", "+375255234555", 600, 32);
        Employees[2] = new Employee("Nikita Slizh Nikolaevich", "driver", "NIkit@mail.ru", "+375255324121", 800, 20);
        Employees[3] = new Employee("Stepan Rakovich Evgenievich", "Director", "Stepa@mail.ru", "+375298907760", 5000, 27);
        Employees[4] = new Employee("Yulia Tur Nikolaevna", "vice president", "Julia@mail.ru", "+375337805670", 4000, 50);
        Employees[5] = new Employee("Daria Rak Yurievna", "secretary", "Dasha2mail.ru", "+375335603490", 1000, 45);

        for (int i = 0; i < Employees.length; i++)
            if (Employees[i].getAge() > 40) Employees[i].print();
    }
}
