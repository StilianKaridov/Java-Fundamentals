package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] bombSpecifications = scanner.nextLine().split(" ");
        int digitBomb = Integer.parseInt(bombSpecifications[0]);
        int powerOfBomb = Integer.parseInt(bombSpecifications[1]);
        int sum = 0;
        for (int i = 0; i < integerList.size() - 1; i++) {
            if (integerList.get(i) == digitBomb) {
                for (int j = 1; j <= powerOfBomb; j++) {
                    if (i - j < 0)
                        break;
                    else
                        integerList.remove(i - j);
                }
                int newIndex = integerList.indexOf(digitBomb);
                for (int j = 1; j <= powerOfBomb ; j++) {
                    if(newIndex + 1 <= integerList.size() - 1)
                        integerList.remove(newIndex + 1);
                    else
                        break;
                }
                integerList.remove(newIndex);
                if(integerList.size() == 0)
                    break;
                else if(digitBomb == integerList.get(newIndex))
                    i--;
            }

        }

        //Printing
        for (Integer integer : integerList) {
            sum += integer;
        }
        System.out.println(sum);
    }
}
