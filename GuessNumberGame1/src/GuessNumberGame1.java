import java.util.Scanner;

public class GuessNumberGame1 {

    private int highLimit;
    private int guessCount;

    private static double nGames;
    private static int totalGuessCount;

    public GuessNumberGame1(int highLimit) {
        nGames++;
        this.highLimit = highLimit;
    }

    public void playGame(){
        Scanner sc = new Scanner(System.in);
        int answer = (int)(Math.random() * this.highLimit) +1;
        int guess;

        do {
            System.out.println("Guess a number from 1 to " + highLimit);
            guess = Integer.parseInt(sc.nextLine());
            guessCount++;
            totalGuessCount++;
            System.out.println("Current guesscount: "+guessCount);
            if (answer == guess) {
                System.out.println("Well done, the correct answer is " + answer);
            } else if (answer < guess){
                System.out.println("Try again, " + guess + " is too high.");
            } else {
                System.out.println("Try again, " + guess + " is too small.");
            }
        }while (answer != guess);
    }

    public static int getnGames(){
        return (int)nGames;
    }

    public static int getTotalGuessCount(){
        return totalGuessCount;
    }

    public static double getAvgGuessCount(){
        if (0 < nGames) {
            return totalGuessCount / nGames;
        } else {
            return 0;
        }
    }
}