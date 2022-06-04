package Methods;

import java.util.Scanner;

public class PalindromeIntegers {

    static boolean palindromeCheck(String number){
        boolean isPalindrome = false;
        StringBuilder reversedNumber = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            char currentInt = number.charAt(i);
            reversedNumber.append(currentInt);
        }
        if(reversedNumber.toString().equals(number))
            isPalindrome = true;

        return isPalindrome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("END")){
            if(palindromeCheck(input))
                System.out.println("true");
            else
                System.out.println("false");

            input = scanner.nextLine();
        }
    }
}
