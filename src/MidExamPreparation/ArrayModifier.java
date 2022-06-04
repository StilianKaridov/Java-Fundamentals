package MidExamPreparation;

import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "swap":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    int temp = array[firstIndex];
                    array[firstIndex] = array[secondIndex];
                    array[secondIndex] = temp;
                    break;
                case "decrease":
                    for (int i = 0; i < array.length; i++) {
                        array[i]--;
                    }
                    break;
                case "multiply":
                    int firstIndexNumber = Integer.parseInt(command[1]);
                    int secondIndexNumber = Integer.parseInt(command[2]);
                    array[firstIndexNumber] *= array[secondIndexNumber];
                    break;

            }
            command = scanner.nextLine().split(" ");
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i != array.length - 1)
                System.out.print(", ");
        }
    }
}
