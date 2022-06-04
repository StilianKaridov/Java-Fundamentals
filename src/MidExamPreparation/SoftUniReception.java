package MidExamPreparation;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int hours = 0;
        int answersFor1hour = firstEmployee + secondEmployee + thirdEmployee;

        while (studentsCount > 0) {
            studentsCount = studentsCount - answersFor1hour;
            hours++;
            if (hours % 4 == 0 && hours != 0)
                hours++;
        }

        System.out.printf("Time needed: %sh.", hours);
    }
}
