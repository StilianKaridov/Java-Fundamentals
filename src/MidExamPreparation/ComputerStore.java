package MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Double> prices = new ArrayList<>();
        while(!command.equals("special") && !command.equals("regular")){
            double price = Double.parseDouble(command);
            if(price <= 0)
                System.out.println("Invalid price!");
            else
                prices.add(price);
            command = scanner.nextLine();
        }
        double totalPrice = 0;

        for (Double price : prices) {
            totalPrice+=price;
        }
        if(totalPrice == 0)
            System.out.println("Invalid order!");
        else{
            double totalPriceWithTaxes = 0;
            double taxes = 0;
            taxes = totalPrice * 0.2;
            totalPriceWithTaxes = totalPrice + taxes;

            if(command.equals("special"))
                totalPriceWithTaxes = totalPriceWithTaxes - (totalPriceWithTaxes * 0.1);

            System.out.printf("Congratulations you've just bought a new computer!%n" +
                              "Price without taxes: %.2f$%n" +
                              "Taxes: %.2f$%n" +
                              "-----------%n" +
                              "Total price: %.2f$", totalPrice, taxes, totalPriceWithTaxes);
        }
    }
}
