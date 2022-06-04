package Methods;

import java.util.Scanner;

public class NxNMatrix {

    static void printNxNMatrix(int numberToPrintMatrix){
        for (int i = 0; i < numberToPrintMatrix; i++) {
            System.out.print(numberToPrintMatrix + " ");
            for (int j = 0; j < numberToPrintMatrix - 1; j++) {
                System.out.print(numberToPrintMatrix + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        printNxNMatrix(number);
    }
}
