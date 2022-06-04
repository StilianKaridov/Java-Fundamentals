package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();
        while (numberOfCommands > 0) {
            String[] command = scanner.nextLine().split(" ");
            String nameOfThePerson = command[0];
            if (command[2].equals("going!")) {
                if (!guests.contains(nameOfThePerson))
                    guests.add(nameOfThePerson);
                else
                    System.out.println(nameOfThePerson + " is already in the list!");
            } else if (command[2].equals("not")) {
                if (guests.contains(nameOfThePerson))
                    guests.remove(String.valueOf(nameOfThePerson));
                else
                    System.out.println(nameOfThePerson + " is not in the list!");
            }

            numberOfCommands--;
        }
        for (String guest : guests)
            System.out.println(guest);
    }
}
