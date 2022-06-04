package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        int count = 0;
        while(!command.equals("End")){
            int index = Integer.parseInt(command);
            if(index >= 0 && index < integerList.size() && integerList.get(index) != -1){
                int currentTarget = integerList.get(index);
                for (int i = 0; i < integerList.size(); i++) {
                    int nextTarget = integerList.get(i);
                    if(nextTarget > currentTarget && nextTarget != -1)
                        integerList.set(i, nextTarget - currentTarget);
                    else if (nextTarget <= currentTarget && nextTarget != -1)
                        integerList.set(i, nextTarget + currentTarget);
                }
                integerList.set(index, -1);
            }
            command = scanner.nextLine();
        }
        for (Integer number : integerList) {
            if(number == -1)
                count++;
        }

        System.out.print("Shot targets: " + count + " -> ");
        for (Integer number : integerList) {
            System.out.print(number + " ");
        }
    }
}
