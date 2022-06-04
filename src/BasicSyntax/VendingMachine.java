package BasicSyntax;

import java.util.Scanner;


public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double insertedMoney = 0;
        double sumMoney = 0;
        double priceProduct = 0;
        String endInsert = "";
        endInsert = scanner.nextLine();

        while (!endInsert.equals("Start")) {
            insertedMoney = Double.parseDouble(endInsert);
            if (insertedMoney == 0.1 || insertedMoney == 0.2 || insertedMoney == 0.5 || insertedMoney == 1.0 || insertedMoney == 2.0)
                sumMoney += insertedMoney;
            else
                System.out.printf("Cannot accept %.2f%n", insertedMoney);
            endInsert = scanner.nextLine();
        }


        endInsert = scanner.nextLine();
        while (!endInsert.equals("End")) {
            boolean isPurchased = false;

            if (endInsert.equals("Nuts")) {
                priceProduct = 2.0;
                isPurchased = true;
            } else if (endInsert.equals("Water")) {
                priceProduct = 0.7;
                isPurchased = true;
            } else if (endInsert.equals("Crisps")) {
                priceProduct = 1.5;
                isPurchased = true;
            } else if (endInsert.equals("Soda")) {
                priceProduct = 0.8;
                isPurchased = true;
            } else if (endInsert.equals("Coke")) {
                priceProduct = 1.0;
                isPurchased = true;
            } else {
                System.out.println("Invalid product");
            }

            if (priceProduct > sumMoney) {
                System.out.println("Sorry, not enough money");
                isPurchased = false;
            } else if (priceProduct <= sumMoney && isPurchased) {
                sumMoney -= priceProduct;
            }

            if (isPurchased)
                System.out.printf("Purchased %s%n", endInsert);

            endInsert = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sumMoney);
    }
}
