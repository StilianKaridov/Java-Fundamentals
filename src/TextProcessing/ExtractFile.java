package TextProcessing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\\\");
        String[] file = input[input.length - 1].split("\\.");
        String name = file[0];
        String extension = file[1];
        System.out.printf("File name: %s%n", name);
        System.out.printf("File extension: %s", extension);
    }
}
