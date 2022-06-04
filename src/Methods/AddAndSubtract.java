package Methods;

import java.util.Scanner;

public class AddAndSubtract {

    static int sum(int number1, int number2) {
        return number1 + number2;
    }

    static int sum(int number1, int number2, int number3) {
        return sum(number1, number2) - number3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        System.out.println(sum(num1, num2, num3));
    }
}
