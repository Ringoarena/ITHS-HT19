import java.util.Scanner;

public class GuessNumberGame0 {

    public static void gameMenu(){
        Scanner sc = new Scanner(System.in);
        int level = -1; // ett värde som garanterat är skilt från 1-3
        int maxNumber = 0;
        int cMinlvl = 1;
        int cMaxlvl = 3;

        do {
            System.out.println("\nChoose difficulty level (1/2/3)");
            System.out.println("1. 1-10");
            System.out.println("2. 1-100");
            System.out.println("3. 1-1000");
            try {
                level = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {}
            if (!(cMinlvl <= level && level <= cMaxlvl)) {
                System.out.println("Numbers between "+cMinlvl+" and "+cMaxlvl+" only!");
            }
        } while (!(cMinlvl <= level && level <= cMaxlvl));

        switch (level){
            case 1:
                maxNumber=10;
                break;
            case 2:
                maxNumber=100;
                break;
            case 3:
                maxNumber=1000;
                break;
        }
        System.out.println("Final guesscount is: "+playGame(maxNumber));
    }

    public static int playGame(int maxNumber){
        Scanner sc = new Scanner(System.in);
        int answer = (int)(Math.random() * maxNumber) +1;
        int guess = -1337;  // ett värde som garanterat är skilt från answer för att säkerställa att användaren får gissa
        int guesscount = 0;

        while (answer != guess){
            System.out.println("Guess a number between 1 and " + maxNumber);
            try {
                guess = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
            }
            if (0 <= guess && guess <= maxNumber) {
                guesscount ++;
                System.out.println("Current guesscount is: "+guesscount);
                giveResponse(answer, guess);
            }
        }
        return guesscount;
    }

    public static void giveResponse(int answer, int guess){
        if (answer == guess) {
            System.out.println("Well done, the correct answer is " + answer);
        } else if (answer < guess){
            System.out.println("Try again, " + guess + " is too high.");
        } else {
            System.out.println("Try again, " + guess + " is too small.");
        }
    }
}