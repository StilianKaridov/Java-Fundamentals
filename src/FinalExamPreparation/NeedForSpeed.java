package FinalExamPreparation;

import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> nameMileage = new LinkedHashMap<>();
        Map<String, Integer> nameFuel = new LinkedHashMap<>();
        while (n > 0) {
            String[] cars = scanner.nextLine().split("\\|");
            String carName = cars[0];
            int mileage = Integer.parseInt(cars[1]);
            int fuel = Integer.parseInt(cars[2]);
            nameMileage.put(carName, mileage);
            nameFuel.put(carName, fuel);
            n--;
        }
        String[] command = scanner.nextLine().split(" : ");
        while (!command[0].equals("Stop")) {
            String car = command[1];
            switch (command[0]) {
                case "Drive":
                    int distance = Integer.parseInt(command[2]);
                    int fuel = Integer.parseInt(command[3]);
                    if (fuel > nameFuel.get(car)) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        nameFuel.put(car, nameFuel.get(car) - fuel);
                        nameMileage.put(car, nameMileage.get(car) + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                        if (nameMileage.get(car) >= 100000) {
                            System.out.printf("Time to sell the %s!%n", car);
                            nameFuel.remove(car);
                            nameMileage.remove(car);
                        }
                    }
                    break;
                case "Refuel":
                    int fuelForRefuel = Integer.parseInt(command[2]);
                    if (fuelForRefuel + nameFuel.get(car) >= 75) {
                        fuelForRefuel = 75 - nameFuel.get(car);
                        nameFuel.put(car, 75);

                    } else {
                        nameFuel.put(car, fuelForRefuel + nameFuel.get(car));
                    }
                    System.out.printf("%s refueled with %d liters%n", car, fuelForRefuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(command[2]);
                    nameMileage.put(car, nameMileage.get(car) - kilometers);
                    if (nameMileage.get(car) < 10000) {
                        nameMileage.put(car, 10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;
            }
            command = scanner.nextLine().split(" : ");
        }
        for (Map.Entry<String, Integer> entry : nameMileage.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue(), nameFuel.get(entry.getKey()));
        }
    }
}