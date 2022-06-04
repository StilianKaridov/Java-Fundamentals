package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfWagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacityOnEachWagon = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String indexOfCommandForExchange = command.replaceAll("[^0-9]", "");
            int numberOfPassengers = Integer.parseInt(indexOfCommandForExchange);
            if (command.equals("Add " + indexOfCommandForExchange)) {
                listOfWagons.add(numberOfPassengers);
            } else {
                int sum = 0;
                for (int i = 0; i < listOfWagons.size(); i++) {
                    if (listOfWagons.get(i) + numberOfPassengers <= maxCapacityOnEachWagon) {
                        sum = listOfWagons.get(i) + numberOfPassengers;
                        listOfWagons.remove(i);
                        listOfWagons.add(i, sum);
                        break;
                    }

                }
            }
            command = scanner.nextLine();
        }
        for (Integer wagon : listOfWagons) {
            System.out.print(wagon + " ");
        }

    }
}
