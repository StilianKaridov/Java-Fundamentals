package RegEx;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> participants = new LinkedHashMap<>();

        String[] players = scanner.nextLine().split(", ");
        for (String player : players) {
            participants.putIfAbsent(player, 0);
        }

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            int kilometersTravelled = 0;
            Pattern pattern = Pattern.compile("([A-Za-z]+)");
            Matcher matcher = pattern.matcher(input);
            String nameOfParticipant = "";
            while (matcher.find()) {
                nameOfParticipant += matcher.group();
            }

            Pattern digitPattern = Pattern.compile("\\d");
            Matcher digitMatcher = digitPattern.matcher(input);

            while (digitMatcher.find()) {
                kilometersTravelled += Integer.parseInt(digitMatcher.group());
            }

            if (participants.containsKey(nameOfParticipant)) {
                participants.put(nameOfParticipant, participants.get(nameOfParticipant) + kilometersTravelled);
            }

            input = scanner.nextLine();
        }

        List<String> names = new LinkedList<>();
        participants.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).forEach(p -> names.add(p.getKey()));
        System.out.printf("1st place: %s\n" +
                "2nd place: %s\n" +
                "3rd place: %s\n", names.get(0), names.get(1), names.get(2));
    }
}
