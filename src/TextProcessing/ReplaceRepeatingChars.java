package TextProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                i++;
            }
            System.out.print(input.charAt(i));
        }
    }
}
