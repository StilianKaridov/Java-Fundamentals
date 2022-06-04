package MidExam;

import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cars = scanner.nextLine().split(">>");
        String[] carsData;
        String typeOfCar;
        int yearsTaxPaid;
        int kilometersTravelled;
        double totalTaxes = 0;
        for (int i = 0; i < cars.length; i++) {
            double currentTax = 0;
            carsData = cars[i].split(" ");
            typeOfCar = carsData[0];
            yearsTaxPaid = Integer.parseInt(carsData[1]);
            kilometersTravelled = Integer.parseInt(carsData[2]);
            int taxIncreasing;
            if (typeOfCar.equals("family")) {
                taxIncreasing = kilometersTravelled / 3000;
                currentTax = taxIncreasing * 12 + (50 - yearsTaxPaid * 5);
            } else if (typeOfCar.equals("heavyDuty")) {
                taxIncreasing = kilometersTravelled / 9000;
                currentTax = taxIncreasing * 14 + (80 - yearsTaxPaid * 8);
            } else if (typeOfCar.equals("sports")) {
                taxIncreasing = kilometersTravelled / 2000;
                currentTax = taxIncreasing  * 18 + (100 - yearsTaxPaid * 9);
            } else
                System.out.println("Invalid car type.");

            if (currentTax > 0) {
                System.out.printf("A %s car will pay %.2f euros in taxes.%n", typeOfCar, currentTax);
            }

            totalTaxes += currentTax;
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", totalTaxes);
    }
}
