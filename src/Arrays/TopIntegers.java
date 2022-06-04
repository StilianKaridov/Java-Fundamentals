package Arrays;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arr = input.split(" ");
        int[] arrNums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arrNums[i] = Integer.parseInt(arr[i]);
        }

        for (int j = 0; j < arrNums.length; j++) {
            boolean isGreater = true;
            for (int i = j + 1; i < arrNums.length; i++) {
                if(arrNums[j] <= arrNums[i])
                    isGreater = false;
            }

            if (isGreater)
                System.out.print(arrNums[j] + " ");
        }
    }
}