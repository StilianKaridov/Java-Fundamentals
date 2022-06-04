package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("End")) {
            vehicles.add(new Vehicle(command[0], command[1], command[2], Integer.parseInt(command[3])));
            command = scanner.nextLine().split(" ");
        }

        String modelsToPrint = scanner.nextLine();
        while (!modelsToPrint.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (modelsToPrint.equals(vehicle.getModel())) {
                    if (vehicle.getType().equals("car"))
                        System.out.printf("Type: Car%n");
                    else
                        System.out.printf("Type: Truck%n");

                    System.out.printf("Model: %s%n" +
                            "Color: %s%n" +
                            "Horsepower: %d%n", vehicle.getModel(), vehicle.getColor(), vehicle.getHorsePower());
                }
            }
            modelsToPrint = scanner.nextLine();
        }
        int countForCars = 0;
        int countForTrucks = 0;
        double averageCarsHorsePower = 0;
        double averageTrucksHorsePower = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals("car")) {
                averageCarsHorsePower += vehicle.getHorsePower();
                countForCars++;
            } else {
                averageTrucksHorsePower += vehicle.getHorsePower();
                countForTrucks++;
            }
        }
        if(countForCars > 0)
            averageCarsHorsePower = averageCarsHorsePower/countForCars;
        if(countForTrucks > 0)
            averageTrucksHorsePower = averageTrucksHorsePower/countForTrucks;

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarsHorsePower);
        System.out.printf("Trucks have average horsepower of: %.2f.", averageTrucksHorsePower);
    }
}
