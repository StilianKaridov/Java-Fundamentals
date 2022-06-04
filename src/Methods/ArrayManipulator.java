package Methods;

import java.util.Scanner;

public class ArrayManipulator {

    static void exchange(int index, int[] arr) {
        if (index > arr.length - 1 || index < 0) {
            System.out.println("Invalid index");
        } else {
            for (int i = 0; i <= index; i++) {
                int firstNumber = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = firstNumber;
            }
        }
    }

    static void cannotFoundMaxMin(int index) {
        if (index < 0)
            System.out.println("No matches");
        else
            System.out.println(index);
    }

    static boolean invalidCount(int counter, int[] array) {
        if (counter > array.length) {
            System.out.println("Invalid count");
            return true;
        } else
            return false;
    }

    static void maxEven(int[] arr) {
        int index = -1;
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                int currentNum = arr[i];
                if (currentNum >= currentMax) {
                    currentMax = currentNum;
                    index = i;
                }
            }
        }
        cannotFoundMaxMin(index);
    }

    static void minEven(int[] arr) {
        int index = -1;
        int currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                int currentNum = arr[i];
                if (currentNum <= currentMin) {
                    currentMin = currentNum;
                    index = i;
                }
            }
        }
        cannotFoundMaxMin(index);
    }

    static void maxOdd(int[] arr) {

        int index = -1;
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                int currentNum = arr[i];
                if (currentNum >= currentMax) {
                    currentMax = currentNum;
                    index = i;
                }
            }
        }
        cannotFoundMaxMin(index);
    }

    static void minOdd(int[] arr) {
        int index = -1;
        int currentMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                int currentNum = arr[i];
                if (currentNum <= currentMin) {
                    currentMin = currentNum;
                    index = i;
                }
            }
        }
        cannotFoundMaxMin(index);
    }

    static void printing(int count, int[] arrayForFirst) {
        if (arrayForFirst.length == 0)
            System.out.println("[]");
        else {
            if (count <= arrayForFirst.length) {
                System.out.print("[");
                for (int i = 0; i < count; i++) {
                    System.out.print(arrayForFirst[i]);
                    if (i == count - 1)
                        break;
                    else
                        System.out.print(", ");
                }
                System.out.print("]");
                System.out.println();
            } else {
                System.out.print("[");
                for (int i = 0; i < arrayForFirst.length; i++) {
                    System.out.print(arrayForFirst[i]);
                    if (i == arrayForFirst.length - 1)
                        break;
                    else
                        System.out.print(", ");
                }
                System.out.print("]");
                System.out.println();
            }
        }
    }

    static void firstEven(int count, int[] arr) {
        int countForEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                countForEven++;
        }

        int[] arrayForFirstEven = new int[countForEven];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                arrayForFirstEven[index++] = arr[i];
        }

        printing(count, arrayForFirstEven);
    }

    static void firstOdd(int count, int[] arr) {
        int countForOdd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                countForOdd++;
        }

        int[] arrayForFirstOdd = new int[countForOdd];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                arrayForFirstOdd[index++] = arr[i];
        }

        printing(count, arrayForFirstOdd);
    }

    static void lastEven(int count, int[] arr) {
        int countForEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                countForEven++;
        }

        int[] arrayForLastEven = new int[countForEven];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                arrayForLastEven[index++] = arr[i];
        }
        int[] reversingReversedArray = new int[count];
        if (countForEven > 1) {
            int counter = count - 1;
            int indexOfReversedArray = 0;
            int indexOfNormalArray = arrayForLastEven.length - 1;
            int[] reversedArray = new int[count];
            while (counter >= 0) {
                reversedArray[indexOfReversedArray++] = arrayForLastEven[indexOfNormalArray--];
                counter--;
            }


            int indexOfRevArray = reversedArray.length - 1;
            int indexOfRevRevArray = 0;
            int counterForSecondReverse = count - 1;
            while (counterForSecondReverse >= 0) {
                reversingReversedArray[indexOfRevRevArray++] = reversedArray[indexOfRevArray--];
                counterForSecondReverse--;
            }
            printing(count, reversingReversedArray);
        } else
            printing(count, arrayForLastEven);

    }

    static void lastOdd(int count, int[] arr) {
        int countForOdd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                countForOdd++;
        }

        int[] arrayForLastOdd = new int[countForOdd];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                arrayForLastOdd[index++] = arr[i];
        }

//        int[] reversedArray = new int[count];
//        int[] reversingReversedArray = new int[count];
//        if (countForOdd > 1 && !invalidCount(count, arrayForLastOdd)) {
//            int counter = count - 1;
//            int indexOfReversedArray = 0;
//            int indexOfNormalArray = arrayForLastOdd.length - 1;
//
//            while (indexOfNormalArray > 0) {
//                reversedArray[indexOfReversedArray++] = arrayForLastOdd[indexOfNormalArray--];
//                counter--;
//            }
//
//
//            int indexOfRevArray = reversedArray.length - 1;
//            int indexOfRevRevArray = 0;
//            int counterForSecondReverse = count - 1;
//            while (counterForSecondReverse >= 0) {
//                reversingReversedArray[indexOfRevRevArray++] = reversedArray[indexOfRevArray--];
//                counterForSecondReverse--;
//            }
//            printing(count, reversingReversedArray);
//        } else
            printing(count, arrayForLastOdd);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arrayOfString = input.split(" ");
        int[] arr = new int[arrayOfString.length];

        for (int i = 0; i < arrayOfString.length; i++) {
            arr[i] = Integer.parseInt(arrayOfString[i]);
        }

        // Input command, until end
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String indexOfCommandForExchange = command.replaceAll("[^0-9]", "");

            if (command.equals("exchange " + indexOfCommandForExchange)) {
                int index = Integer.parseInt(indexOfCommandForExchange);
                exchange(index, arr);
            } else if (command.equals("max odd")) {
                maxOdd(arr);
            } else if (command.equals("min odd")) {
                minOdd(arr);
            } else if (command.equals("max even")) {
                maxEven(arr);
            } else if (command.equals("min even")) {
                minEven(arr);
            } else if (command.equals("first " + indexOfCommandForExchange + " even")) {
                int index = Integer.parseInt(indexOfCommandForExchange);
                if (!invalidCount(index, arr))
                    firstEven(index, arr);
            } else if (command.equals("first " + indexOfCommandForExchange + " odd")) {
                int index = Integer.parseInt(indexOfCommandForExchange);
                if (!invalidCount(index, arr))
                    firstOdd(index, arr);

            } else if (command.equals("last " + indexOfCommandForExchange + " even")) {
                int index = Integer.parseInt(indexOfCommandForExchange);
                if (!invalidCount(index, arr))
                    lastEven(index, arr);

            } else if (command.equals("last " + indexOfCommandForExchange + " odd")) {
                int index = Integer.parseInt(indexOfCommandForExchange);
                if (!invalidCount(index, arr))
                    lastOdd(index, arr);
            }

            command = scanner.nextLine();
        }

        // Print array
        StringBuilder printingArray = new StringBuilder();
        printingArray.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                printingArray.append(arr[i]).append("]");
            else
                printingArray.append(arr[i]).append(", ");
        }
        System.out.println(printingArray);
    }
}
