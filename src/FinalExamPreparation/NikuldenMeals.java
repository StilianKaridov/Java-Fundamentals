package FinalExamPreparation;

import java.util.*;

public class NikuldenMeals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commands = scanner.nextLine().split("-");
        Map<String, List<String>> map = new LinkedHashMap<>();
        int unlikedMeals = 0;
        while (!commands[0].equals("Stop")) {
            String guest = commands[1];
            String meal = commands[2];
            switch (commands[0]) {
                case "Like":
                    map.putIfAbsent(guest, new ArrayList<>());
                    if (!map.get(guest).contains(meal)) {
                        map.get(guest).add(meal);
                    }
                    break;
                case "Unlike":
                    if (!map.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else if (!map.get(guest).contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                    } else {
                        map.get(guest).remove(meal);
                        unlikedMeals++;
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                    }
                    break;
            }
            commands = scanner.nextLine().split("-");
        }

        map.entrySet().stream()
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size))
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> {
                    System.out.printf("%s: ", e.getKey());
                    String meals = String.join(", ", e.getValue());
                    System.out.println(meals);
                });
        System.out.println("Unliked meals: " + unlikedMeals);
    }
}
