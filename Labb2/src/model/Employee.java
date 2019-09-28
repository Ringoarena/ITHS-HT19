package model;

import ui.Utilities;

public abstract class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    private Integer ID;
    private static int nID;

    public Employee(String name, double salary) {
        this.setName(name);
        this.setSalary(salary);
        this.setID();
    }

    public abstract void raiseSalary();

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String input) {
        input = input.trim();
        input = input.substring(0, 1).toUpperCase() + input.substring(1);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                input = input.substring(0, i + 1) + input.substring(i + 1, i + 2).toUpperCase() + input.substring(i + 2);
            }
        }
        this.name = input;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setID() {
        this.ID = ++nID;
    }

    public Integer getID() {
        return ID;
    }

    @Override
    public String toString() {
        return Utilities.fixLengthString(getID(),5) +
                "  " + Utilities.fixLengthString(getName(),20) +
                "  " + Utilities.fixLengthString(((int)getSalary()),7);
    }

    @Override
    public int compareTo(Employee employee) {
        return this.getID().compareTo(employee.getID());
    }
}
