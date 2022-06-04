package Arrays;

import java.util.Scanner;

public class MaxSequenceEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] temp = input.split(" ");
        int[] arr = new int[temp.length];

        int counterToPrint = 0;
        int counter = 1;
        int digitToPrint = 0;

        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]){
                counter++;
                if(counter > counterToPrint){
                    counterToPrint = counter;
                    digitToPrint = arr[i];
                }
            } else
                counter = 1;
        }
        for (int i = 0; i < counterToPrint; i++) {
            System.out.print(digitToPrint + " ");
        }
    }
}
