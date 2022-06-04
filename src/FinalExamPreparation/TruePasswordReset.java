package FinalExamPreparation;

import java.util.Scanner;

public class TruePasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("Done")) {
            switch (command[0]) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 0; i < password.length(); i++) {
                        if(i % 2 != 0 ){
                            newPassword.append(password.charAt(i));
                        }
                    }
                    password = newPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    String toRemove = password.substring(index, length+index);
                    password = password.replaceFirst(toRemove, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substringToLookFor = command[1];
                    String substringReplace = command[2];
                    if(password.contains(substringToLookFor)){
                        password = password.replace(substringToLookFor, substringReplace);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
        System.out.printf("Your password is: %s", password);
    }
}
