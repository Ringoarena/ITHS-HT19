import java.util.Scanner;

public class Menu {
    private static boolean exit;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        printHeader();

        while (!exit) {
            printMenu();
            performAction(getInput());
        }
    }

    private static void printHeader() {
        System.out.println("+----------+");
        System.out.println("|  Labb 1  |");
        System.out.println("+----------+");
    }

    private static void printMenu() {
        System.out.println("\nMain menu");
        System.out.println("1. Option");
        System.out.println("2. Option");
        System.out.println("3. Option");
        System.out.println("0. Exit");
    }

    private static int getInput() {
        int nDecision = 3;
        int decision = -1;
        do {
            System.out.print("Enter decision: ");
            try {
                decision = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Illegal input, numbers only!");
            }
            if (decision < 0 || nDecision < decision) {
                System.out.println("Illegal input, from 0 to " + nDecision + " only!");
            }
        } while (decision < 0 || nDecision < decision);
        return decision;
    }

    private static void performAction(int decision) {
        switch (decision) {
            case 0:
                System.out.println("\nTerminating process...");
                exit = true;
                break;
            case 1:
                System.out.println("\nCalling option 1...");
                break;
            case 2:
                System.out.println("\nCalling option 2...");
                break;
            case 3:
                System.out.println("\nCalling option 3...");
                break;
            default:
                System.out.println("\nUnknown error...");
        }
    }
}
