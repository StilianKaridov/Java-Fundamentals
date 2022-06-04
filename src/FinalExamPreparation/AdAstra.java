package FinalExamPreparation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([#\\|])(?<name>[A-z\\s+]+)\\1(?<date>(\\d{2})\\/(\\d{2})\\/(\\d{2}))\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(input);
        int totalCalories = 0;
        Map<String, String> namesWithExpirationDate = new LinkedHashMap();
        Map<String, Integer> calories = new LinkedHashMap();
        List<String> items = new ArrayList();
        while (matcher.find()) {
            String name = matcher.group("name");
            String date = matcher.group("date");
            int currentCalories = Integer.parseInt(matcher.group("calories"));
            namesWithExpirationDate.putIfAbsent(name, date);
            calories.putIfAbsent(name, currentCalories);
            totalCalories += currentCalories;
            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d%n", name,date,currentCalories));
        }
        int days = totalCalories / 2000;

        System.out.printf("You have food to last you for: %s days!%n", days);
        items.forEach(System.out::print);
    }
}
