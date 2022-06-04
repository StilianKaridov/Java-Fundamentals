package FinalExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            boolean isValid = false;
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("(!)(?<first>[A-Z][a-z]{2,})\\1:(\\[(?<second>[A-Za-z]{8,})\\])");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                isValid = true;
                String command = matcher.group("first");
                String second = matcher.group("second");
                System.out.print(command + ": ");
                for (int i = 0; i < second.length(); i++) {
                    int ascii = second.charAt(i);
                    System.out.print(ascii + " ");
                }
                System.out.println();
            }
            if(!isValid){
                System.out.println("The message is invalid");
            }
            n--;
        }
    }
}
