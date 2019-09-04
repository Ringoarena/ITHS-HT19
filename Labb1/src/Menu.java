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
        System.out.println("1. Call Circle class");
        System.out.println("2. Call Rectangle class");
        System.out.println("3. Call Triangle class");
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
                System.out.print("\nEnter the radius for the circle: ");
                Circle c = new Circle(Double.parseDouble(sc.nextLine()));
                System.out.println("Radius: "+c.getRadius()+" Area: "+ c.getArea()+" Circumference: "+c.getCircumference());
                break;
            case 2:
                System.out.print("\nEnter the base for the rectangle: ");
                double b = Double.parseDouble(sc.nextLine());
                System.out.print("Enter the height for the rectangle: ");
                double h = Double.parseDouble(sc.nextLine());
                Rectangle r = new Rectangle(b, h);
                System.out.println("Area: " + r.getArea() + " Perimiter: " + r.getPerimiter());
                break;
            case 3:
                System.out.print("\nEnter side a for the triangle: ");
                double A = Double.parseDouble(sc.nextLine());
                System.out.print("Enter side b for the triangle: ");
                double B = Double.parseDouble(sc.nextLine());
                System.out.print("Enter side c for the triangle: ");
                double C = Double.parseDouble(sc.nextLine());
                Triangle t = new Triangle(A, B, C);
                System.out.println("Area: "+t.getArea()+" Perimiter: "+t.getPerimiter());
                break;
            default:
                System.out.println("\nUnknown error...");
        }
    }
}
