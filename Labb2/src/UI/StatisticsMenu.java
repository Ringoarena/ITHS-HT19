package UI;

import model.EmployeeManagement;

import java.util.Scanner;

public class StatisticsMenu {
    private static boolean previous;
    private static Scanner sc = new Scanner(System.in);

    public static void runSubMenu() {
        previous = false;
        printHeader();

        while (!previous) {
            printMenu();
            performAction(getInput());
        }
    }

    private static void printHeader() {
        System.out.println("\n+----------+");
        System.out.println("|Sub-header|");
        System.out.println("+----------+");
    }

    private static void printMenu() {
        System.out.println("\nSub-menu");
        System.out.println("1. List employees");
        System.out.println("2. Sub-Option");
        System.out.println("3. Sub-Option");
        System.out.println("0. Return to previous menu");
    }

    private static int getInput() {
        int nDecision = 3;
        int decision = -1;
        while (!(0 <= decision && decision <= nDecision)) {
            System.out.print("Enter decision: ");
            try {
                decision = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ignored) {}
            if (!(0 <= decision && decision <= nDecision)) {
                System.out.println("Illegal input, numbers from 0 to " + nDecision + " only!");
            }
        }
        return decision;
    }

    private static void performAction(int decision) {
        switch (decision) {
            case 0:
                System.out.println("\nReturning to previous menu...");
                previous = true;
                break;
            case 1:
                EmployeeManagement.displayAllEmployees();
                break;
            case 2:
                System.out.println("\nCalling sub-option 2...");
                break;
            case 3:
                System.out.println("\nCalling sub-option 3...");
                break;
            default:
                System.out.println("\nUnknown error...");
        }
    }
}
