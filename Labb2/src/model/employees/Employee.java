package model.employees;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.*;

public abstract class Employee {

    private String name;
    private String dob;
    private int ID;
    private double salary;

    private static int IDGenerator;

    public Employee(String name, String dob) {
        this.name = name;
        this.dob = dob;
        this.ID = ++IDGenerator;
    }

    public abstract double bonus();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getID() {
        return ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Date of birth: " + dob + ", ID: " + ID + ", Salary: " + salary;
    }

    public long calculateAge(){
        LocalDate birthdate = LocalDate.parse(dob);
        LocalDate now = LocalDate.now();
        return YEARS.between(birthdate, now);
    }
}
