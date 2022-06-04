package FinalExamPreparation;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split("\\|\\|");
        Map<String, Integer> namePopulation = new LinkedHashMap<>();
        Map<String, Integer> nameGold = new LinkedHashMap<>();
        List<String> cities = new ArrayList<>();
        while (!command[0].equals("Sail")) {
            String cityName = command[0];
            int population = Integer.parseInt(command[1]);
            int gold = Integer.parseInt(command[2]);
            if (namePopulation.containsKey(cityName)) {
                namePopulation.put(cityName, namePopulation.get(cityName) + population);
                nameGold.put(cityName, nameGold.get(cityName) + gold);
            } else {
                namePopulation.putIfAbsent(cityName, population);
                nameGold.putIfAbsent(cityName, gold);
            }
            command = scanner.nextLine().split("\\|\\|");
        }
        command = scanner.nextLine().split("=>");
        while (!command[0].equals("End")) {
            String town = command[1];
            switch (command[0]) {
                case "Plunder":
                    int peopleKilled = Integer.parseInt(command[2]);
                    int gold = Integer.parseInt(command[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, peopleKilled);
                    nameGold.put(town, nameGold.get(town)-gold);
                    namePopulation.put(town, namePopulation.get(town) - peopleKilled);
                    if(nameGold.get(town) <= 0 || namePopulation.get(town) <= 0){
                        nameGold.remove(town);
                        namePopulation.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;
                case "Prosper":
                    gold = Integer.parseInt(command[2]);
                    if(gold < 0){
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        nameGold.put(town, gold + nameGold.get(town));
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, nameGold.get(town));
                    }
                    break;
            }
            command = scanner.nextLine().split("=>");
        }
        for (Map.Entry<String, Integer> entry : nameGold.entrySet()) {
            cities.add(String.format("%s -> Population: %d citizens, Gold: %d kg", entry.getKey(), namePopulation.get(entry.getKey()),entry.getValue()));
        }

        if(!nameGold.isEmpty()){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", nameGold.size());
            cities.forEach(System.out::println);
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}