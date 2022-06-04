package ObjectsAndClasses;

import java.util.*;

public class OpinionPoll{

    static class Person implements Comparable<Person>{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return this.name + " - " + this.age;
        }


        @Override
        public int compareTo(Person o) {
            return this.getName().compareTo(o.name);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        Person person;
        List<Person> persons = new ArrayList<>();
        while (numberOfLines > 0) {
            String[] personData = scanner.nextLine().split(" ");
            String nameOfThePerson = personData[0];
            int ageOfThePerson = Integer.parseInt(personData[1]);
            person = new Person(nameOfThePerson, ageOfThePerson);
            if(person.getAge() > 30)
                persons.add(person);
            numberOfLines--;
        }
        Collections.sort(persons);
        for (Person person1 : persons) {
            System.out.println(person1.toString());
        }
    }
}
