package Arrays;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String input2 = scanner.nextLine();
        String[] arr1 = input.split(" ");
        String[] arr2 = input2.split(" ");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if(arr2[i].equals(arr1[j])){
                    System.out.print(arr2[i] + " ");
                }
            }
        }
    }
}
