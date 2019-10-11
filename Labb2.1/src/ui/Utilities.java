package ui;

import java.util.Scanner;

public class Utilities {
    public static Scanner sc = new Scanner(System.in);

    public static int getInput(int lowEnd, int highEnd) {
        int decision = -1;
        while (!(lowEnd <= decision && decision <= highEnd)) {
            System.out.print("Enter decision: ");
            try {
                decision = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ignored) {
            }
            if (!(lowEnd <= decision && decision <= highEnd)) {
                System.out.println("Illegal input, numbers from " + lowEnd + " to " + highEnd + " only!");
            }
        }
        return decision;
    }

    public static String fixLengthString(String string, int length) {
        if (string.length() >= length) {
            return string.substring(0, length);
        } else {
            while (string.length() < length) {
                string += " ";
            }
            return string;
        }
    }

    public static String fixLengthString(int integer, int length) {
        String string = String.valueOf(integer);
        return fixLengthString(string, length);
    }
}
