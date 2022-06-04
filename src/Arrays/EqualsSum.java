package Arrays;

import javax.management.ListenerNotFoundException;
import java.util.Scanner;

public class EqualsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isEqual = false;
        String input = scanner.nextLine();
        String[] temp = input.split(" ");
        int[] arr = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < arr.length; i++) {

            if(arr.length == 1){
                System.out.println("0");
                isEqual = true;
                break;
            }

            int sumRight = 0;
            int sumLeft = 0;
            int currentNum = arr[i];

            for (int k = i; k > 0; k--) {  // for left
                sumLeft += arr[k - 1];
            }

            for (int j = i + 1; j < arr.length; j++) {  // for right
                sumRight += arr[j];
            }

            if (sumLeft == sumRight) {
                System.out.println(i);
                isEqual = true;
            }
        }

        if(!isEqual)
            System.out.println("no");
    }
}
