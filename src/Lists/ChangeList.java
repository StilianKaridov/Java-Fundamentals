package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while(!command.equals("end")){
            String[] element = command.split(" ");
            int elementToChange = Integer.parseInt(element[1]);
            if(element[0].equals("Delete")){
                while(integerList.remove(Integer.valueOf(elementToChange)))
                    integerList.remove(Integer.valueOf(elementToChange));
            } else if(element[0].equals("Insert")){
                int index = Integer.parseInt(element[2]);
                integerList.add(index, elementToChange);
            }
            command = scanner.nextLine();
        }
        for (Integer number : integerList){
            System.out.print(number + " ");
        }
    }
}
