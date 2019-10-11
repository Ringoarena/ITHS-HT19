package model;

import ui.Utilities;

import java.util.ArrayList;
import java.util.List;

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
        System.out.print("\nEnter name: ");
        return new Employee(Utilities.sc.nextLine());
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
        System.out.print("\nWhat is the ID? ");
        id = Integer.parseInt(Utilities.sc.nextLine());
        for (Employee employee: employees) {
            if (employee.getID() == id) {
                return employee;
            }
        }
        System.out.println("Employee not found");
        return null;
    }

    public void promoteEmployee(Employee employee) {
        employee.setCurrentState(employee.selectState());
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void listEmployees() {
        System.out.println();
        System.out.println(Utilities.fixLengthString("ID",5) +
                "  " + Utilities.fixLengthString("Name", 20) +
                "  " + Utilities.fixLengthString("Salary",7) +
                "  " + Utilities.fixLengthString("Description",12));
        for (Employee employee:employees) {
            System.out.println(employee);
        }
    }
}
