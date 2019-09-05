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
        System.out.println("+--------------------------------+");
        System.out.println("|     Guess Number Game 1        |");
        System.out.println("|  It's fun to guess numbers =D  |");
        System.out.println("+--------------------------------+");
    }

    private static void printMenu() {
        System.out.println("\nMain menu");
        System.out.println("1. Play game");
        System.out.println("2. Statistics");
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
            }
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
                System.out.println("\nWhat do you want the max number to be?");
                int highLimit = Integer.parseInt(sc.nextLine());
                if (10 <= highLimit) {
                    GuessNumberGame1 game = new GuessNumberGame1(highLimit);
                    game.playGame();
                } else {
                    System.out.println("Minimum is 10!");
                }
                break;
            case 2:
                System.out.println("\nGames: "+GuessNumberGame1.getnGames()+
                        ". Total guesses: "+GuessNumberGame1.getTotalGuessCount()+
                        ". Average guess count: "+GuessNumberGame1.getAvgGuessCount());
                break;
            default:
                System.out.println("\nUnknown error...");
        }
    }
}
