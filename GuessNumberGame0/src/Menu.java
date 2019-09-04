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
        System.out.println("+---------------------+");
        System.out.println("|  Guess Number Game  |");
        System.out.println("+---------------------+");
    }

    private static void printMenu() {
        System.out.println("\nMain menu");
        System.out.println("1. Start game");
        System.out.println("0. Exit");
    }

    private static int getInput() {
        int nDecision = 1;
        int decision = -1;
        do {
            System.out.print("Enter decision: ");
            try {
                decision = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {}
            if (!(0 <= decision && decision <= nDecision)) {
                System.out.println("Illegal input, numbers from 0 to " + nDecision + " only!");
            }
        } while (!(0 <= decision && decision <= nDecision));
        return decision;
    }

    private static void performAction(int decision) {
        switch (decision) {
            case 0:
                System.out.println("\nTerminating process...");
                exit = true;
                break;
            case 1:
                GuessNumberGame0.gameMenu();
                break;
            default:
                System.out.println("\nUnknown error...");
        }
    }
}
