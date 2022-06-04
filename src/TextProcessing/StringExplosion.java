package TextProcessing;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder text = new StringBuilder();
        text.append(input);
        char separator = '>';
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == separator) {
                int strength = Integer.parseInt(String.valueOf(text.charAt(i + 1)));
                int currentIndex = i;
                int currentDeleted = 0;
                while (strength > 0) {
                    if (text.length() - 1 == currentIndex) {
                        if(text.charAt(text.length() - 1) == '>'){
                            break;
                        } else {
                            text.deleteCharAt(text.length() - 1);
                            break;
                        }
                    } else if (text.charAt(currentIndex + 1) != '>') {
                        currentDeleted = text.charAt(currentIndex + 1);
                        text.delete(currentIndex + 1, currentIndex + 2);
                        strength--;
                    } else {
                        int strengthToAdd = Integer.parseInt(String.valueOf(text.charAt(currentIndex + 2)));
                        strength += strengthToAdd;
                        currentIndex++;
                        i++;
                    }
                }
            }
        }
        System.out.println(text.toString());
    }
}
