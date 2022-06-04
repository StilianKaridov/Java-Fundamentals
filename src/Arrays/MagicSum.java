package Arrays;

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] temp = input.split(" ");
        int[] arr = new int[temp.length];

        int guess = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int sum = 0;
                sum = currentNum + arr[j];
                if(sum == guess){
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }
}
