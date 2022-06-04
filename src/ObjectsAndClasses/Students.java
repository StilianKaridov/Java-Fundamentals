package ObjectsAndClasses;

import java.util.*;

public class Students {



    static class Student implements Comparable<Student>{
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public int compareTo(Student o) {
            return Double.compare(this.grade, o.grade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        while (numberOfLines > 0) {
            String input = scanner.nextLine();
            String[] studentData = input.split(" ");
            students.add(new Student(studentData[0], studentData[1], Double.parseDouble(studentData[2])));
            numberOfLines--;
        }
        Collections.sort(students);
        Collections.reverse(students);
        for (Student student : students) {
            System.out.printf("%s %s: %.2f%n", student.firstName, student.lastName, student.grade);
        }
    }
}
