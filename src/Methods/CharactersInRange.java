package Methods;

import java.util.Scanner;

public class CharactersInRange {

    static void printCharactersBetween(char a, char b) {

        char i = a;
        char j = b;
        if (i < b) {
            for (char k = (char) (i + 1); k < j; k++) {
                System.out.print(k + " ");
            }
        } else {
            for (char k = (char) (j + 1); k < i; k++) {
                System.out.print(k + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        char firstChar = a.charAt(0);
        char secondChar = b.charAt(0);
        printCharactersBetween(firstChar, secondChar);
    }
}
