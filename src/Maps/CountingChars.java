package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            for (int j = 0; j < currentWord.length(); j++) {
                char ch = currentWord.charAt(j);
                if (!map.containsKey(ch)) {
                    map.put(ch, 0);
                }
                map.put(ch, map.get(ch) + 1);
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            System.out.println(characterIntegerEntry.getKey() + " -> " + characterIntegerEntry.getValue());
        }
    }
}
