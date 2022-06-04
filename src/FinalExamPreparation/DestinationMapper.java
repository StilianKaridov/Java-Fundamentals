package FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([=/])(?<valid>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        int totalSum = 0;
        List<String> validCities = new ArrayList<>();
        while (matcher.find()) {
            String valid = matcher.group("valid");
            int sum = valid.length();
            totalSum += sum;
            validCities.add(valid);
        }

        System.out.println("Destinations: " + String.join(", ", validCities));
        System.out.println("Travel Points: " + totalSum);
    }
}
