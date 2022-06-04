package Methods;

import java.util.Scanner;

public class TopNumber {

    static void printTopNumber(int number){

        String topNumber = "" ;
        for (int i = 1; i <= number; i++) {
            boolean isTopNumber = false;
            int countOdd = 0;
            int sum = 0;
            topNumber = String.valueOf(i);

            for (int j = 0; j < topNumber.length(); j++) {
                char ch = topNumber.charAt(j);
                int currentInt = Character.getNumericValue(ch);
                sum += currentInt;
                if(currentInt % 2 != 0)
                    countOdd++;
            }

            if(sum % 8 == 0 && countOdd > 0)
                isTopNumber = true;

            if(isTopNumber)
                System.out.println(topNumber);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        printTopNumber(num);
    }
}
