package model;

import model.employees.*;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

    private static ArrayList<Employee> employeeDB = new ArrayList<>();



    public static void loadDB(){
        employeeDB.add(new Waiter("Rikard", "1990-09-25"));
        employeeDB.add(new Waiter("Johannes", "1930-09-25"));
        employeeDB.add(new Waiter("Mattias", "1200-09-25"));
    }

    public static void addEmployee(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee name");
        String name = sc.nextLine();

        //TODO
        System.out.println("Enter DOB (yyyy-mm-dd)");
        String dob = sc.nextLine();

        System.out.println("Enter employee salary");
        double salary = Double.parseDouble(sc.nextLine());

        int role;
        while (true){
            System.out.println("Enter employee role");
            System.out.println("1. Manager");
            System.out.println("2. HR");
            System.out.println("3. Chef");
            System.out.println("4. Bartender");
            System.out.println("5. Waiter");
            try {
                 role = Integer.parseInt(sc.nextLine());
                if (role >= 1 && role <= 5) {
                    break;
                } else {
                    System.out.println("Enter a number from 1 to 5 only!");
                }
            } catch (NumberFormatException ignor) { }
        }
        switch(role){
            case 1:
                employeeDB.add(new Manager(name, dob));
                break;
            case 2:
                employeeDB.add(new HR(name, dob));
                break;
            case 3:
                employeeDB.add(new Chef(name, dob));
                break;
            case 4:
                employeeDB.add(new Bartender(name, dob));
                break;
            case 5:
                employeeDB.add(new Waiter(name, dob));
                break;
            default:
                System.out.println("Unknown error!");
        }

    }

    public static int getSize() {
        return employeeDB.size();
    }

    public static void displayAllEmployees(){
        for (Employee emp: employeeDB)
            System.out.println(emp.toString());
    }

//    public static void removeEmployeeByID() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("\nWhat is the ID of the employee?");
//        int id = Integer.parseInt(sc.nextLine());
//
//        for (int i = 0; i < counter; i++) {
//            if ((employeeDB[i]).getID() == id) {
//                if (i == (counter - 1)) {
//                    employeeDB[counter - 1] = null;
//                } else {
//                    employeeDB[i] = employeeDB[counter - 1];
//                }
//                employeeDB[counter - 1] = null;
//                counter--;
//            }
//        }
//    }
//
//    public static void findHighestSalary(){
//        int highest = 0;
//        for (int i = 1; i < db.length; i++) {
//            if (db[i].getSalary() > db[highest].getSalary()) {
//                highest = i;
//            }
//        }
//        System.out.println("Highest salary: " + db[highest]);
//    }
//
//    public static void findOldestPerson(){
//        int oldest = 0;
//        for (int i = 1; i < db.length; i++) {
//            if (db[i].calculateAge() > db[oldest].calculateAge()) {
//                oldest = i;
//            }
//        }
//        System.out.println("Oldest employee: " + db[oldest]);
//    }
}
