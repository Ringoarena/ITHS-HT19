package model;

import ui.Utilities;

public class Chef extends Employee {
    private static double annualRaise = 10;

    public Chef(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void raiseSalary() {
        double salary = this.getSalary();
        this.setSalary(salary*(annualRaise/100+1));
    }

    @Override
    public String toString() {
        return super.toString() + "  " + Utilities.fixLengthString("Chef", 8);
    }

    public static void setAnnualRaise(double annualRaise) {
        Chef.annualRaise = annualRaise;
    }
}
