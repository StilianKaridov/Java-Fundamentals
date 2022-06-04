package TextProcessing;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(", ");
        for (int i = 0; i < names.length; i++) {
            boolean isValid = false;
            String currentName = names[i];
            if(currentName.length() >= 3 && currentName.length() <= 16){
                for (int j = 0; j < currentName.length(); j++) {
                    char currentChar = currentName.charAt(j);
                    if(!Character.isLetterOrDigit(currentChar) && currentChar != '_' && currentChar != '-'){
                        isValid = false;
                        break;
                    } else
                        isValid = true;
                }
            }
            if(isValid)
                System.out.println(currentName);
        }
    }
}
