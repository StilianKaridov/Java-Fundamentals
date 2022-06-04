package Methods;

import java.util.Scanner;

public class PasswordValidator {

    static boolean charactersRule(String password) {
        boolean breakRule = false;
        if (password.length() < 6 || password.length() > 10)
            breakRule = true;
        return breakRule;
    }

    static boolean lettersAndDigitsRule(String password) {
        boolean breakRule = false;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (currentChar >= 65 && currentChar <= 90 || currentChar >= 48 && currentChar <= 57 || currentChar >= 97 && currentChar <= 122) {

            } else {
                breakRule = true;
                break;
            }
        }
        return breakRule;
    }

    static boolean atLeast2DigitsRule(String password) {
        int count = 0;
        boolean atLeast2Digits = false;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            if (currentChar >= 48 && currentChar <= 57)
                count++;

            if (count >= 2)
                atLeast2Digits = true;
        }
        return atLeast2Digits;
    }

    public static void main(String[] args) {
        boolean isValid = true;

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if(charactersRule(password)){
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }

        if (lettersAndDigitsRule(password)) {
            System.out.println("Password must consist only of letters and digits");
            isValid = false;
        }

        if (!atLeast2DigitsRule(password)) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }

        if(isValid)
            System.out.println("Password is valid");
    }
}
