package Maps;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resources = new TreeMap<>();
        Map<String, Integer> junk = new LinkedHashMap<>();
        String winner = " ";
        resources.put("shards", 0);
        resources.put("fragments", 0);
        resources.put("motes", 0);

        while (winner.equals(" ")) {
            String[] input = scanner.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < input.length; i++) {
                if (i % 2 != 0) {
                    if (resources.containsKey(input[i])) {
                        int lastQuantity = resources.get(input[i]);
                        resources.put(input[i], lastQuantity + Integer.parseInt(input[i - 1]));
                    } else {
                        if (!junk.containsKey(input[i])) {
                            junk.put(input[i], Integer.parseInt(input[i-1]));
                        } else {
                            int lastQuantity = junk.get(input[i]);
                            junk.put(input[i], lastQuantity + Integer.parseInt(input[i - 1]));
                        }
                    }
                }

                if (resources.containsKey(input[i])) {
                    if (resources.get(input[i]) >= 250) {
                        switch (input[i]) {
                            case "shards":
                                winner = "Shadowmourne";
                                break;
                            case "fragments":
                                winner = "Valanyr";
                                break;
                            case "motes":
                                winner = "Dragonwrath";
                                break;
                        }
                        resources.put(input[i], resources.get(input[i]) - 250);
                        break;
                    }
                }
            }
        }

        System.out.println(winner + " obtained!\n" +
                "shards: " + resources.getOrDefault("shards", 0) + "\n" +
                "fragments: " + resources.getOrDefault("fragments", 0) + "\n" +
                "motes: " + resources.getOrDefault("motes", 0));

        for (Map.Entry<String, Integer> entryJunk : junk.entrySet()) {
            System.out.println(entryJunk.getKey() + ": " + entryJunk.getValue());
        }
    }
}
