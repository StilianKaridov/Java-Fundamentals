package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<firstNumber>\\d+)\\]\\|\\[(?<secondNumber>\\d+)\\]\\|\\[(?<thirdNumber>\\d+)\\]\\|$";

        while(n > 0){
            boolean isValid = false;
            String command = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(command);
            String tag = "";
            StringBuilder encryptedMessage = new StringBuilder();
            while(matcher.find()){
                isValid = true;
                tag = matcher.group("tag");
                int firstNumber = Integer.parseInt(matcher.group("firstNumber"));
                int secondNumber = Integer.parseInt(matcher.group("secondNumber"));
                int thirdNumber = Integer.parseInt(matcher.group("thirdNumber"));
                char first = (char) firstNumber;
                char second = (char) secondNumber;
                char third = (char) thirdNumber;
                encryptedMessage.append(first);
                encryptedMessage.append(second);
                encryptedMessage.append(third);
            }
            if (!isValid) {
                System.out.println("Valid message not found!");
            } else {
                System.out.printf("%s: %s%n", tag, encryptedMessage.toString());
            }
            n--;
        }
    }
}
