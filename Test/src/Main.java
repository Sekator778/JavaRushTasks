import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Main main = new Main();
        System.out.println("Enter number: ");
        double number = input.nextDouble();
        System.out.println("Enter degree of number: ");
        double degreeOfNumber = input.nextDouble();
        System.out.println("Result is: ");
        if (degreeOfNumber == 2) { number = main.squareOfNumber(number); }
        else if (degreeOfNumber == 3) { number = main.cubeNumber(number); }
        else {
            number = main.result(number, degreeOfNumber); }
        System.out.println(number);
    }

    public double result(double number, double degreeOfNumber) {

        double initialNumber = number;
        double negativeNumber = degreeOfNumber;

        if (degreeOfNumber < 0) {
            degreeOfNumber = -degreeOfNumber;
        }

        for (double i = degreeOfNumber; i > 1; i--) {
            number *= initialNumber;
        }

        if (negativeNumber < 0) {
            return 1 / number;
        } else
            return number;
    }

    public double squareOfNumber (double number) {
        return number * number;
    }

    public double cubeNumber (double number) {
        return number * number * number;
    }

}