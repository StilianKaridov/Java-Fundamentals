package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (firstPlayer.size() != 0 && secondPlayer.size() != 0) {
            if (firstPlayer.get(0) > secondPlayer.get(0)) {
                //secondPlayer card is last and firstPlayer is second to last;
                int firstCard = firstPlayer.get(0);
                for (int i = 0; i < firstPlayer.size() - 1; i++) {
                    firstPlayer.set(i, firstPlayer.get(i + 1));
                }
                firstPlayer.set(firstPlayer.size() - 1, firstCard);
                firstPlayer.add(secondPlayer.get(0));
                secondPlayer.remove(0);
            } else if (secondPlayer.get(0) > firstPlayer.get(0)) {
                int firstCard = secondPlayer.get(0);
                for (int i = 0; i < secondPlayer.size() - 1; i++) {
                    secondPlayer.set(i, secondPlayer.get(i + 1));
                }
                secondPlayer.set(secondPlayer.size() - 1, firstCard);
                secondPlayer.add(firstPlayer.get(0));
                firstPlayer.remove(0);
            } else {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
        }

        int sum = 0;
        if (firstPlayer.size() > secondPlayer.size()) {
            for (int i = 0; i < firstPlayer.size(); i++) {
                sum += firstPlayer.get(i);
            }
            System.out.println("First player wins! Sum: " + sum);
        } else {
            for (int i = 0; i < secondPlayer.size(); i++) {
                sum += secondPlayer.get(i);
            }
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}
