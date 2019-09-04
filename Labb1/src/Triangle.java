public class Triangle {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        if (isValidTriangle(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            System.out.println("Side lengths are not valid!");
        }
    }

    private boolean isValidTriangle(double a, double b, double c) {
        double longestSide = a;
        if (longestSide < b) {
            longestSide = b;
        }
        if (longestSide < c) {
            longestSide = c;
        }
        return (longestSide < a + b + c - longestSide);
    }

    public double getArea() {
        double s = (a+b+c)/2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getPerimiter() {
        return a + b + b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
