package Arrays;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr1 = new int [n];
        int[] arr2 = new int[n];
        boolean isDone = false;
        for (int i = 1; i <= n; i++) {
            int num1 = Integer.parseInt(String.valueOf(scanner.nextInt()));
            int num2 = Integer.parseInt(String.valueOf(scanner.nextInt()));

            if(!isDone){
                arr2[i - 1] = num2;
                arr1[i - 1] = num1;
                isDone = true;
            } else{
                arr2[i - 1] = num1;
                arr1[i - 1] = num2;
                isDone = false;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
