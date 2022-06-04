package TextProcessing;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            ch+=3;
            System.out.print(ch);
        }
    }
}
