package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> mines = new LinkedHashMap<>();
        String command = scanner.nextLine();
        int count = 1;
        String previousMine = null;
        while (!command.equals("stop")) {
            boolean resource = false;
            if (count % 2 != 0) {
                resource = true;
                String mine = command;
                if (!mines.containsKey(mine))
                    mines.put(mine, 0);
            }

            if (resource) {
                previousMine = command;
            } else {
                mines.put(previousMine, mines.get(previousMine) + Integer.parseInt(command));
            }
            count++;
            command = scanner.nextLine();

        }

        for (Map.Entry<String, Integer> entrySet : mines.entrySet()) {
            System.out.println(entrySet.getKey() + " -> " + entrySet.getValue());
        }

    }
}
