package Methods;

import java.util.Scanner;

public class MiddleCharacters {

    static void printMiddleCharacter(String string){
        char charToPrint = string.charAt(string.length()/2);
        char charToPrintEven = string.charAt((string.length()/2) - 1);

        if(string.length() % 2 == 0){
            System.out.print(charToPrintEven);
            System.out.print(charToPrint);
        } else
            System.out.println(charToPrint);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        printMiddleCharacter(input);
    }
}
