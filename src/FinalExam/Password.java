package FinalExam;

import java.util.Scanner;

public class Password {

    public static boolean checkForUpper(StringBuilder string) {
        boolean isValid = false;
        char[] charArray = string.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    public static boolean checkForLower(StringBuilder string) {
        boolean isValid = false;
        char[] charArray = string.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLowerCase(charArray[i])){
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    private static boolean checkForDigit(StringBuilder string) {
        boolean isValid = false;
        char[] charArray = string.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])){
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    private static boolean checkForAlpha(StringBuilder string) {
        boolean isValid = true;
        char[] charArray = string.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '_' && !Character.isLetterOrDigit(charArray[i])){
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder password = new StringBuilder(scanner.nextLine());
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("Complete")) {
            switch (command[0]) {
                case "Make":
                    int index = Integer.parseInt(command[2]);
                    char currentChar = password.charAt(index);
                    if (command[1].equals("Upper")) {
                        currentChar = Character.toUpperCase(currentChar);
                        password.replace(index, index + 1, String.valueOf(currentChar));
                    } else if (command[1].equals("Lower")) {
                        currentChar = Character.toLowerCase(currentChar);
                        password.replace(index, index + 1, String.valueOf(currentChar));
                    }
                    System.out.println(password.toString());
                    break;
                case "Insert":
                    int indexOfInsert = Integer.parseInt(command[1]);
                    String charToInsert = command[2];
                    if (indexOfInsert < 0 || indexOfInsert >= password.length()) {
                        continue;
                    } else {
                        password.insert(indexOfInsert, charToInsert);
                    }
                    System.out.println(password.toString());
                    break;
                case "Replace":
                    String charToBeReplaced = command[1];
                    int value = Integer.parseInt(command[2]);
                    char replaced = charToBeReplaced.charAt(0);
                    value += replaced;
                    char ascii = (char) value;
                    password = new StringBuilder(password.toString().replace(replaced, ascii));
                    System.out.println(password.toString());
                    break;
                case "Validation":
                    if (password.length() < 8) {
                        System.out.println("Password must be at least 8 characters long!");
                    }
                    if(!checkForAlpha(password)){
                        System.out.println("Password must consist only of letters, digits and _!");
                    }
                    if (!checkForUpper(password)) {
                        System.out.println("Password must consist at least one uppercase letter!");
                    }
                    if (!checkForLower(password)) {
                        System.out.println("Password must consist at least one lowercase letter!");
                    }
                    if (!checkForDigit(password)) {
                        System.out.println("Password must consist at least one digit!");
                    }
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }
    }
}
