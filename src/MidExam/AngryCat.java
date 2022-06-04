package MidExam;

import java.util.Scanner;

public class AngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int[] priceRatings = new int[input.length];
        for (int i = 0; i < priceRatings.length; i++) {
            priceRatings[i] = Integer.parseInt(input[i]);
        }

        int indexOfCatsEntry = Integer.parseInt(scanner.nextLine());
        String typeOfItemsToBreak = scanner.nextLine();
        int sumRight = 0;
        int sumLeft = 0;
        if(typeOfItemsToBreak.equals("cheap")){
            for (int i = 0; i < priceRatings.length; i++) {
                if(i < indexOfCatsEntry && priceRatings[i] < priceRatings[indexOfCatsEntry]){
                    sumLeft+=priceRatings[i];
                } else if (i > indexOfCatsEntry && priceRatings[i] < priceRatings[indexOfCatsEntry]){
                    sumRight+=priceRatings[i];
                }
            }
        } else if (typeOfItemsToBreak.equals("expensive")){
            for (int i = 0; i < priceRatings.length; i++) {
                if(i < indexOfCatsEntry && priceRatings[i] >= priceRatings[indexOfCatsEntry]){
                    sumLeft+=priceRatings[i];
                } else if (i > indexOfCatsEntry && priceRatings[i] >= priceRatings[indexOfCatsEntry]){
                    sumRight+=priceRatings[i];
                }
            }
        }

        if(sumLeft > sumRight){
            System.out.println("Left - " + sumLeft);
        } else if (sumRight > sumLeft){
            System.out.println("Right - " + sumRight);
        } else
            System.out.println("Left - " + sumLeft);
    }
}
