package FinalExamPreparation;
import java.util.Scanner;

public class NikuldenCharity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] commands = scanner.nextLine().split("\\s+");
        while (!commands[0].equals("Finish")) {
            switch (commands[0]) {
                case "Replace":
                    String charToReplace = commands[1];
                    String newChar = commands[2];
                    input = input.replace(charToReplace, newChar);
                    System.out.println(input);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);

                    if (startIndex >= 0 && endIndex < input.length() && startIndex < input.length() && endIndex >= 0) {
                        String beforeStartIndex = input.substring(0, startIndex);
                        String afterEndIndex = input.substring(endIndex + 1);
                        input = beforeStartIndex + afterEndIndex;
                        System.out.println(input);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
                case "Make":
                    String upperOrLower = commands[1];
                    if (upperOrLower.equals("Upper")) {
                        input = input.toUpperCase();
                    } else {
                        input = input.toLowerCase();
                    }
                    System.out.println(input);
                    break;
                case "Check":
                    String string = commands[1];
                    if (input.contains(string)) {
                        System.out.println("Message contains " + string);
                    } else {
                        System.out.println("Message doesn't contain " + string);
                    }
                    break;
                case "Sum":
                    int sIndex = Integer.parseInt(commands[1]);
                    int eIndex = Integer.parseInt(commands[2]);
                    if (sIndex >= 0 && eIndex < input.length() && sIndex < input.length() && eIndex >= 0) {
                        int sum = 0;
                        String substr = input.substring(sIndex, eIndex + 1);
                        for (int i = 0; i < substr.length() ; i++) {
                            char currentChar = substr.charAt(i);
                            sum+=currentChar;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
            }
            commands = scanner.nextLine().split("\\s+");
        }
    }
}
