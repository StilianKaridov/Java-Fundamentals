package FinalExamPreparation;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder encryptedMessage = new StringBuilder();
        String input = scanner.nextLine();
        encryptedMessage.append(input);
        String[] command = scanner.nextLine().split("\\|");
        while (!command[0].equals("Decode")) {
            switch (command[0]) {
                case "ChangeAll":
                    char charToReplace = command[1].charAt(0);
                    String replacement = command[2];
                    for (int i = 0; i < encryptedMessage.length(); i++) {
                        if(encryptedMessage.charAt(i) == charToReplace){
                            encryptedMessage.replace(i, i+1, replacement);
                        }
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[1]);
                    String toInsert =command[2];
                    encryptedMessage.insert(index, toInsert);
                    break;
                case "Move":
                    int numberOfLetters = Integer.parseInt(command[1]);
                    for (int i = 0; i < numberOfLetters; i++) {
                        char currentChar = encryptedMessage.charAt(0);
                        encryptedMessage.append(currentChar);
                        encryptedMessage.deleteCharAt(0);
                    }
                    break;
            }
            command = scanner.nextLine().split("\\|");
        }
        System.out.printf("The decrypted message is: %s", encryptedMessage.toString());
    }
}
