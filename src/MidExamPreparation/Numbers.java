package MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        double averageValue = 0;
        for (Integer number : integerList) {
            averageValue += number;
        }
        averageValue /= integerList.size();
        Collections.sort(integerList);
        Collections.reverse(integerList);
        int countToFive = 0;
        boolean haveGreater = false;
        for (Integer numberToPrint : integerList) {
            if (countToFive < 5 && numberToPrint > averageValue) {
                System.out.print(numberToPrint + " ");
                haveGreater = true;
            } else if (!haveGreater) {
                System.out.println("No");
                break;
            } else
                break;
            countToFive++;
        }
    }
}
