package ObjectsAndClasses;

import java.util.Scanner;

public class AdvertisementMessage {

    static class Message {
        static String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};

        static String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};

        static String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        static String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        public Message() {
        }

        int i = 0;
        void printMessage(){
            System.out.printf("%s %s %s - %s%n", phrases[i], events[i], authors[i], cities[i]);
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfFakeMessages = Integer.parseInt(scanner.nextLine());
        Message fakeMessage = new Message();
        for (int i = 0; i < numberOfFakeMessages; i++) {
            fakeMessage.printMessage();
        }
    }
}
