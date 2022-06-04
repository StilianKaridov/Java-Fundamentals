package Methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers {

    static void printSmallestOfThreeNumbers(int a, int b, int c) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (a < min)
                min = a;
            else if (b < min)
                min = b;
            else if (c < min)
                min = c;
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        printSmallestOfThreeNumbers(num1, num2, num3);
    }
}
