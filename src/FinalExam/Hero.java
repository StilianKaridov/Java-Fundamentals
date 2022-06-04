package FinalExam;

import java.util.*;

public class Hero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(" ");
        Map<String, List<String>> heroes = new LinkedHashMap<>();
        while (!command[0].equals("End")) {
            String heroName = command[1];
            switch (command[0]) {
                case "Enroll":
                    if(!heroes.containsKey(heroName)){
                        heroes.put(heroName, new ArrayList<>());
                    } else {
                        System.out.printf("%s is already enrolled.%n", heroName);
                    }
                    break;
                case "Learn":
                    String spell = command[2];
                    if(heroes.containsKey(heroName)){
                        heroes.get(heroName).add(spell);
                    } else if (heroes.containsValue(spell)){
                        System.out.printf("%s has already learnt %s.%n", heroName, spell);
                    } else {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    }
                    break;
                case "Unlearn":
                    spell = command[2];
                    if(!heroes.containsKey(heroName)){
                        System.out.printf("%s doesn't exist.%n", heroName);
                    } else if (!heroes.get(heroName).contains(spell)){
                        System.out.printf("%s doesn't know %s.%n", heroName, spell);
                    } else {
                        heroes.get(heroName).remove(spell);
                    }
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
        System.out.println("Heroes:");
        heroes.forEach((key, value) -> {
            System.out.printf("== %s: ", key);
            String spells = String.join(", ", value);
            System.out.println(spells);
        });
    }
}
