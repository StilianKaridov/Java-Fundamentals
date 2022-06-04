package FinalExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesCodeLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> heroes = new LinkedHashMap<>();
        while (numberOfHeroes > 0) {
            String[] heroesData = scanner.nextLine().split("\\s+");
            String nameOfTheHero = heroesData[0];
            int hitPoint = Integer.parseInt(heroesData[1]);
            int manaPoint = Integer.parseInt(heroesData[2]);
            int[] points = new int[]{hitPoint, manaPoint};
            heroes.put(nameOfTheHero, points);
            numberOfHeroes--;
        }
        String[] command = scanner.nextLine().split(" - ");
        while (!command[0].equals("End")) {
            String heroName = command[1];
            switch (command[0]) {
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(command[2]);
                    String spellName = command[3];
                    if (heroes.get(heroName)[1] >= manaNeeded) {
                        heroes.get(heroName)[1] -= manaNeeded;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroes.get(heroName)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(command[2]);
                    String attacker = command[3];
                    if (heroes.get(heroName)[0] - damage > 0) {
                        heroes.get(heroName)[0] -= damage;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroes.get(heroName)[0]);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroes.remove(heroName);
                    }

                    break;
                case "Recharge":
                    int amountMana = Integer.parseInt(command[2]);
                    if (heroes.get(heroName)[1] + amountMana > 200) {
                        amountMana = 200 - heroes.get(heroName)[1];
                    }
                    heroes.get(heroName)[1] += amountMana;
                    System.out.printf("%s recharged for %d MP!%n", heroName, amountMana);
                    break;
                case "Heal":
                    int amountHealth = Integer.parseInt(command[2]);
                    if (heroes.get(heroName)[0] + amountHealth > 100){
                        amountHealth = 100 - heroes.get(heroName)[0];
                    }
                    heroes.get(heroName)[0] += amountHealth;
                    System.out.printf("%s healed for %d HP!%n", heroName, amountHealth);
                    break;
            }
            command = scanner.nextLine().split(" - ");
        }
        if (!heroes.isEmpty()) {
            for (Map.Entry<String, int[]> entry : heroes.entrySet()) {
                int[] currentValues = entry.getValue();
                System.out.printf("%s%n" +
                        "  HP: %d%n" +
                        "  MP: %d%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
            }
        }
    }
}