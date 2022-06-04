package MidExam;

import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double experienceNeeded = Double.parseDouble(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());
        int countOfBattlesToPrint = 0;
        int countForDiscount = 0;
        while (countOfBattles != 0 && experienceNeeded > 0) {
            countForDiscount++;
            countOfBattles--;
            countOfBattlesToPrint++;
            double currentExperience = Double.parseDouble(scanner.nextLine());

            if (countForDiscount % 15 == 0) {
                experienceNeeded -= (currentExperience + (currentExperience * 0.05));
            } else if (countForDiscount % 5 == 0) {
                experienceNeeded -= (currentExperience - (currentExperience * 0.1));
            } else if (countForDiscount % 3 == 0) {
                experienceNeeded -= (currentExperience + (currentExperience * 0.15));
            } else {
                experienceNeeded -= currentExperience;
            }


        }

        if (experienceNeeded <= 0)
            System.out.printf("Player successfully collected his needed experience for %d battles.%n", countOfBattlesToPrint);
        else
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", experienceNeeded);
    }
}
