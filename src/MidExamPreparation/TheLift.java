package MidExamPreparation;

import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] wagons = new int[input.length];
        for (int i = 0; i < wagons.length; i++) {
            wagons[i] = Integer.parseInt(input[i]);
        }
        boolean isFull = false;
        int i = 0;
        while (peopleWaiting != 0) {
            while (wagons[i] < 4) {
                if (peopleWaiting == 0)
                    break;
                wagons[i]++;
                peopleWaiting--;
            }
            i++;
            if (i == wagons.length)
                break;
        }

        for (int j = 0; j < wagons.length; j++) {
            if (wagons[j] == 4)
                isFull = true;
            else{
                isFull = false;
                break;
            }

        }

        if (peopleWaiting == 0 && !isFull)
            System.out.println("The lift has empty spots!");
        else if (peopleWaiting > 0)
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);

        for (int j = 0; j < wagons.length; j++) {
            System.out.print(wagons[j] + " ");
        }
    }
}
