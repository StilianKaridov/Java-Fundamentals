package ObjectsAndClasses;

import java.util.*;

public class OrderByAge {

    static class Person {
        String name;
        String id;
        int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("End")) {
            persons.add(new Person(command[0], command[1], Integer.parseInt(command[2])));
            command = scanner.nextLine().split(" ");
        }
        persons.sort(Comparator.comparing(o -> o.age));
        for (Person person : persons) {
            System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getId(), person.getAge());
        }
    }
}
