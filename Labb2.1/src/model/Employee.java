package model;

import state.*;
import ui.Utilities;

public class Employee implements Comparable<Employee> {
    private static int nID;

    private int ID;
    private String name;
    private double salary;
    private EmployeeState currentState;

    public EmployeeState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(EmployeeState currentState) {
        this.currentState = currentState;
    }

    public EmployeeState selectState() {
        System.out.println("\nSelect state");
        System.out.println("1. Waiter");
        System.out.println("2. Chef");
        return StateFactory.getInstance(Utilities.getInput(1, 2));
    }

    public Employee(String name) {
        this.setName(name);
        this.setSalary(100);
        this.setID();
        this.setCurrentState(StateFactory.getInstance(0));
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

    public void raiseSalary() {
        this.setSalary(currentState.raiseSalary(salary));
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setID() {
        this.ID = ++nID;
    }

    @Override
    public String toString() {
        return Utilities.fixLengthString(getID(), 5) +
                "  " + Utilities.fixLengthString(getName(), 20) +
                "  " + Utilities.fixLengthString(((int) getSalary()), 7) +
                "  " + Utilities.fixLengthString(getCurrentState().getDescription(), 12);
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public int compareTo(Employee employee) {
        return Integer.compare(this.getID(), employee.getID());
    }
}
