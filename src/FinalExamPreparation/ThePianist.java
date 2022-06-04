package FinalExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static class Composer {
        private String name;
        private String piece;
        private String key;

        public Composer(String name, String piece, String key) {
            this.name = name;
            this.piece = piece;
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPiece() {
            return piece;
        }

        public void setPiece(String piece) {
            this.piece = piece;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return this.piece + " -> Composer: " + this.name + ", Key: " + this.key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPieces = Integer.parseInt(scanner.nextLine());
        Map<String, Composer> map = new LinkedHashMap<>();
        while (numberOfPieces > 0) {
            String[] info = scanner.nextLine().split("\\|");
            map.putIfAbsent(info[0], new Composer(info[1], info[0], info[2]));
            numberOfPieces--;
        }
        String[] commands = scanner.nextLine().split("\\|");
        while (!commands[0].equals("Stop")) {
            String piece = commands[1];
            switch (commands[0]) {
                case "Add":
                    String composer = commands[2];
                    String key = commands[3];
                    if(!map.containsKey(piece)){
                        map.put(piece, new Composer(composer, piece, key));
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    } else {
                        System.out.printf("%s is already in the collection!%n", piece);
                    }
                    break;
                case "Remove":
                    if(map.containsKey(piece)){
                        map.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commands[2];
                    if(map.containsKey(piece)){
                        Composer newComposer = new Composer(map.get(piece).getName(), piece, newKey);
                        map.replace(piece, newComposer);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            commands = scanner.nextLine().split("\\|");
        }
        map.forEach((s, composer) -> System.out.println(composer.toString()));
    }
}
