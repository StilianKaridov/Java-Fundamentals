package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        int numberOfMoves = 0;
        while (!command[0].equals("end")) {
            numberOfMoves++;
            int firstIndex = Integer.parseInt(command[0]);
            int secondIndex = Integer.parseInt(command[1]);
            if (secondIndex < 0 || firstIndex < 0 || secondIndex > elements.size() - 1 || firstIndex > elements.size() - 1 || firstIndex == secondIndex) {
                elements.add(elements.size() / 2, -numberOfMoves + "a");
                elements.add(elements.size() / 2, -numberOfMoves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (elements.get(firstIndex).equals(elements.get(secondIndex))) {
                System.out.println("Congrats! You have found matching elements - " + elements.get(firstIndex) + "!");
                String elementToRemove = elements.get(firstIndex);
                elements.remove(elementToRemove);
                elements.remove(elementToRemove);
            } else if (!elements.get(firstIndex).equals(elements.get(secondIndex))) {
                System.out.println("Try again!");
            }

            if (elements.size() == 0) {
                System.out.printf("You have won in %d turns!%n", numberOfMoves);
                break;
            }

            command = scanner.nextLine().split(" ");
        }
        if (elements.size() > 0) {
            System.out.println("Sorry you lose :(");
            for (String element : elements) {
                System.out.print(element + " ");
            }
        }
    }
}
