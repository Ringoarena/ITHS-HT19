package ui;

import model.EmployeeManager;
import model.Employee;
import java.util.Collections;
import java.util.Comparator;

public class Menu {
    private boolean exit;
    private EmployeeManager employeeManager;

    public Menu(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    public void mainMenu() {
        while (!exit) {
            System.out.println("\nMain Menu");
            System.out.println("1. Management menu");
            System.out.println("2. Statistics menu");
            System.out.println("0. Exit");
            switch (Utilities.getInput(0, 2)) {
                case 0:
                    System.out.println("\nTerminating process...");
                    exit = true;
                    break;
                case 1:
                    managementMenu();
                    break;
                case 2:
                    statsMenu();
                    break;
                default:
            }
        }
    }

    public void managementMenu() {
        boolean previous = false;
        while (!previous) {
            System.out.println("\nManagement Menu");
            System.out.println("1. Add employee");
            System.out.println("2. Remove employee");
            System.out.println("3. Raise salary of all employees");
            System.out.println("0. Previous menu");
            switch (Utilities.getInput(0, 3)) {
                case 0:
                    System.out.println("\nReturning to previous menu...");
                    previous = true;
                    break;
                case 1:
                    employeeManager.addEmployee(employeeManager.createEmployee());
                    break;
                case 2:
                    employeeManager.removeEmployee(employeeManager.selectEmployeeByID());
                    break;
                case 3:
                    for (Employee employee: employeeManager.getEmployees()) {
                        employee.raiseSalary();
                    }
                    System.out.println("\n Raised salary of all employees...");
                default:
            }
        }
    }

    public void statsMenu() {
        boolean previous = false;
        while (!previous) {
            System.out.println("\nStats Menu");
            System.out.println("1. List employees");
            System.out.println("2.");
            System.out.println("3.");
            System.out.println("0. Previous menu");
            switch (Utilities.getInput(0, 3)) {
                case 0:
                    System.out.println("\nReturning to previous menu...");
                    previous = true;
                    break;
                case 1:
                    sortMenu();
                    break;
                case 2:
                    //
                    break;
                case 3:
                    //
                    break;
                default:
            }
        }
    }

    public void sortMenu() {
        boolean previous = false;
        while (!previous) {
            System.out.println("\nSort employees by:");
            System.out.println("1. salary, ascending");
            System.out.println("2. salary, descending");
            System.out.println("3. Sort alphabetical by name");
            System.out.println("4. Sort using overrriden method");
            System.out.println("0. Previous menu");
            switch (Utilities.getInput(0, 4)) {
                case 0:
                    System.out.println("\nReturning to previous menu...");
                    previous = true;
                    break;
                case 1:
                    // sort using Comparator
                    Comparator<Employee> ascending = (e1, e2) -> (int) (e1.getSalary()-e2.getSalary());
                    employeeManager.getEmployees().sort(ascending);
                    employeeManager.listEmployees();
                    break;
                case 2:
                    // sort using Comparator
                    Comparator<Employee> descending = (e1, e2) -> (int) (e2.getSalary()-e1.getSalary());
                    employeeManager.getEmployees().sort(descending);
                    employeeManager.listEmployees();
                    break;
                case 3:
                    // sort using Comparator
                    Comparator<Employee> alphabetical = (e1, e2) -> e1.getName().compareTo(e2.getName());
                    employeeManager.getEmployees().sort(alphabetical);
                    employeeManager.listEmployees();
                    break;
                case 4:
                    // sort using Comparable
                    Collections.sort(employeeManager.getEmployees());
                    employeeManager.listEmployees();
                    break;
                default:
                    System.out.println("Unknown error in sortMenu()");
            }
        }
    }
}