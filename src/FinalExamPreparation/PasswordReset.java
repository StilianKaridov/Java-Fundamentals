package FinalExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder message = new StringBuilder();
        message.append(input);
        String[] command = scanner.nextLine().split(":\\|:");
        while (!command[0].equals("Reveal")) {
            StringBuilder substring = new StringBuilder(command[1]);
            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(String.valueOf(substring));
                    message.insert(index, " ");
                    System.out.println(message.toString());
                    break;
                case "Reverse":
                    if(message.toString().contains(substring.toString())){
                        String reversed = substring.reverse().toString();
                        int indexOfSubstring = message.toString().indexOf(command[1]);
                        message.delete(indexOfSubstring, indexOfSubstring + command[1].length());
                        message.append(reversed);
                        System.out.println(message.toString());
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String replacement = command[2];
                    String newString = message.toString().replaceAll(substring.toString(),replacement);
                    message = new StringBuilder(newString);
                    System.out.println(message.toString());
                    break;
            }

            command = scanner.nextLine().split(":\\|:");
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
