package model;

import ui.Utilities;

public class Waiter extends Employee {
    private static double annualRaise = 5;

    public Waiter(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void raiseSalary() {
        double salary = this.getSalary();
        this.setSalary(salary*(annualRaise/100+1));
    }

    @Override
    public String toString() {
        return super.toString() + "  " + Utilities.fixLengthString("Waiter", 8);
    }

    public static void setAnnualRaise(double value) {
        annualRaise = value;
    }
}
