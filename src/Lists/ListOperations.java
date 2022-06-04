package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {

    static boolean invalidIndex(List<Integer> integers, int index){
        if(index > integers.size() - 1 || index < 0){
            System.out.println("Invalid index");
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("End")) {
            if (command[0].equals("Add")) {
                int number = Integer.parseInt(command[1]);
                integerList.add(number);
            } else if (command[0].equals("Insert")) {
                int number = Integer.parseInt(command[1]);
                int index = Integer.parseInt(command[2]);
                if(!invalidIndex(integerList, index))
                    integerList.add(index, number);
            } else if (command[0].equals("Remove")) {
                int indexToRemove = Integer.parseInt(command[1]);
                if(!invalidIndex(integerList, indexToRemove))
                    integerList.remove(indexToRemove);
            } else if (command[1].equals("left")) {
                int count = Integer.parseInt(command[2]);
                for (int i = 0; i < count; i++) {
                    int firstNumber = integerList.get(0);
                    for (int j = 0; j < integerList.size() - 1; j++) {
                        integerList.set(j, integerList.get(j + 1));
                    }
                    integerList.set(integerList.size() - 1,firstNumber);
                }

            } else if (command[1].equals("right")) {
                int count = Integer.parseInt(command[2]);
                for (int i = 0; i < count; i++) {
                    int lastNumber = integerList.get(integerList.size() - 1);
                    for (int j = integerList.size() - 1; j > 0; j--) {
                        integerList.set(j, integerList.get(j-1));
                    }
                    integerList.set(0,lastNumber);
                }
            }
            command = scanner.nextLine().split(" ");
        }
        for (Integer numbers : integerList) {
            System.out.print(numbers + " ");
        }
    }
}
