package FinalExamPreparation;

import java.util.Scanner;


public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder citiesToVisit = new StringBuilder(scanner.nextLine());


        String[] command = scanner.nextLine().split(":");
        while (!command[0].equals("Travel")) {
            switch (command[0]) {
                case "Add Stop" -> {
                    int index = Integer.parseInt(command[1]);
                    String string = command[2];
                    if (index < citiesToVisit.length()) {
                        citiesToVisit.insert(index, string);
                    }
                }
                case "Remove Stop" -> {
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (startIndex >= 0 && endIndex < citiesToVisit.length())
                        citiesToVisit.delete(startIndex, endIndex + 1);
                }
                case "Switch" -> {
                    String oldString = command[1];
                    String newString = command[2];
                    if (citiesToVisit.toString().contains(oldString)) {
                        String changedCities = citiesToVisit.toString().replace(oldString, newString);
                        citiesToVisit.setLength(0);
                        citiesToVisit.append(changedCities);
                    }
                }
            }
            System.out.println(citiesToVisit.toString());
            command = scanner.nextLine().split(":");
        }
        System.out.println("Ready for world tour! Planned stops: " + citiesToVisit.toString());
    }
}
