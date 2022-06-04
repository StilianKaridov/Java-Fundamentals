package TextProcessing;

import java.util.Scanner;

public class CharacterMultiplier {

    static int getBiggerLengthOfTwoStrings(String first, String second){
        if(first.length() < second.length())
            return first.length();
        else
            return second.length();
    }


    static int sumOfTwoStrings(String firstString, String secondString){
        int sum = 0;
        int length = getBiggerLengthOfTwoStrings(firstString, secondString);
        for (int i = 0; i < length; i++) {
            char firstStringChar = firstString.charAt(i);
            char secondStringChar = secondString.charAt(i);
            sum += (firstStringChar * secondStringChar);
        }
        if(length == firstString.length()){
            for (int i = length; i < secondString.length(); i++) {
                char ch = secondString.charAt(i);
                sum+=ch;
            }
        } else {
            for (int i = length; i < firstString.length(); i++) {
                char ch = firstString.charAt(i);
                sum+=ch;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] st = scanner.nextLine().split(" ");
        String first = st[0];
        String second = st[1];
        int sum = sumOfTwoStrings(first, second);
        System.out.println(sum);
    }
}
