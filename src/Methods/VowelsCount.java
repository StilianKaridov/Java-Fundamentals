package Methods;

import java.util.Scanner;

public class VowelsCount {

    static void printVowelsCount(String word){
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(currentChar == 'a' || currentChar == 'A' || currentChar == 'e' || currentChar == 'E' || currentChar == 'i' || currentChar == 'I' || currentChar == 'o' || currentChar == 'O' || currentChar == 'u' || currentChar == 'U' || currentChar == 'y' || currentChar == 'Y')
                count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        printVowelsCount(word);
    }
}
