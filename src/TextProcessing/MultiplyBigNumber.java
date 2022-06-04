package TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().replaceFirst("^0+(?!$)", "");;

        if(text.isEmpty()){
            text = "0";
        }

        int number = Integer.parseInt(scanner.nextLine());
        boolean isValid = true;

        if (number == 0) {
            System.out.println(0);
            return;
        } else if (number == 1){
            isValid = false;
            System.out.println(text);
        }

        StringBuilder sum = new StringBuilder();
        int startingOst = 0;

        if(isValid){
            for (int i = text.length() - 1; i >= 0; i--) {
                char lastChar = text.charAt(i);
                int lastDigit = Character.getNumericValue(lastChar);
                int product = (lastDigit * number) + startingOst;
                String product1 = String.valueOf(product);
                if(product >= 10){
                    char ost = product1.charAt(0);
                    startingOst = Character.getNumericValue(ost);
                } else {
                    startingOst = 0;
                }
                int toAppend = product % 10;
                if(i > 0){
                    toAppend = product % 10;
                    sum.append(toAppend);
                } else {
                    if(product >= 10){
                        int lastDig = product % 10;
                        char firstDigit = product1.charAt(0);
                        int second = Character.getNumericValue(firstDigit);
                        String append = String.valueOf(lastDig);
                        append += String.valueOf(second);
                        sum.append(append);
                    } else {
                        sum.append(toAppend);
                    }
                }
            }

            System.out.println(sum.reverse().toString());
        }
    }
}
