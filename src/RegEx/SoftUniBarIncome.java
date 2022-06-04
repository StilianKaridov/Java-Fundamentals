package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalMoney = 0;
        while (!input.equals("end of shift")) {
            boolean isValid = false;
            String name = "";
            String product = "";
            int quantity = 0;
            double price = 0;
            Pattern pattern = Pattern.compile("^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                name = matcher.group("name");
                product = matcher.group("product");
                quantity += Integer.parseInt(matcher.group("quantity"));
                price += Double.parseDouble(matcher.group("price"));
                totalMoney += (quantity * price);
                isValid = true;
            }

            if (isValid) {
                System.out.printf("%s: %s - %.2f%n", name, product, price * quantity);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalMoney);
    }
}
