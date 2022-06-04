package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> registered = new LinkedHashMap<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        while (numberOfCommands > 0) {
            String[] command = scanner.nextLine().split(" ");
            String username = command[1];
            if (command[0].equals("register")) {
                String licensePlate = command[2];
                if (!registered.containsKey(username)) {
                    registered.put(username, licensePlate);
                    System.out.println(username + " registered " + licensePlate + " successfully");
                } else {
                    System.out.println("ERROR: already registered with plate number " + licensePlate);
                }
            } else {
                if (!registered.containsKey(username)) {
                    System.out.println("ERROR: user " + username + " not found");
                } else {
                    registered.remove(username);
                    System.out.println(username + " unregistered successfully");
                }
            }
            numberOfCommands--;
        }

        for (Map.Entry<String, String> entry : registered.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
