package model;

import ui.Utilities;
import java.util.ArrayList;

public class EmployeeManager {
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("\nAdded employee: " + employee.getName());
    }

    public Employee createEmployee() {
        String name;
        double salary;
        System.out.print("\nName? ");
        name = Utilities.sc.nextLine();
        System.out.print("Salary? ");
        salary = Integer.parseInt(Utilities.sc.nextLine());
        System.out.println("Which type?");
        System.out.println("1. Waiter");
        System.out.println("2. Chef");
        switch (Utilities.getInput(1, 2)) {
            case 1:
                return new Waiter(name, salary);
            case 2:
                return new Chef(name, salary);
            default:
                System.out.println("Unknown error...");
                return null;
        }
    }

    public void removeEmployee(Employee employee) {
        if (!employees.isEmpty()) {
            employees.remove(employee);
            System.out.println("\nRemoved employee: " + employee.getName());
        } else {
            System.out.println("\nNo employees in database.");
        }
    }

    public Employee selectEmployeeByID() {
        int id;
        System.out.print("\nWhat is the ID?");
        id = Integer.parseInt(Utilities.sc.nextLine());
        for (Employee employee: employees) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        System.out.println("Employee not found");
        return null;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void listEmployees() {
        System.out.println();
        System.out.println(Utilities.fixLengthString("ID",5) +
                "  " + Utilities.fixLengthString("Name", 20) +
                "  " + Utilities.fixLengthString("Salary",7) +
                "  " + Utilities.fixLengthString("Subclass",8));
        for (Employee employee:employees) {
            System.out.println(employee);
        }
    }
}
