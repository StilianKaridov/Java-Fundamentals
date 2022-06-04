package Methods;

import java.util.Scanner;

public class FactorialDivision {

    static double calculateFactorial(int number) {
        double factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static double divide(int number1, int number2) {
        return calculateFactorial(number1) / calculateFactorial(number2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        double factorial1 = calculateFactorial(num1);
        double factorial2 = calculateFactorial(num2);

        double divide = divide(num1, num2);

        System.out.printf("%.2f", divide);
    }
}
