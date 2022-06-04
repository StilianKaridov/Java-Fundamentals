package RegEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile(">>(?<name>[A-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)");

        double totalCosts = 0;
        List<String> names = new ArrayList<>();
        String text = scanner.nextLine();
        while (!text.equals("Purchase")) {
            Matcher matcher = pattern.matcher(text);
            boolean found = matcher.find();
            if(found) {
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalCosts+=(quantity*price);
                names.add(name);
            }
            text = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        names.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalCosts);
    }
}
