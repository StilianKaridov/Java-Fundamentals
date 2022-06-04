package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> students = new LinkedHashMap<>();
        double averageGrade = 0;
        while(n > 0){
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if(!students.containsKey(name)){
                students.put(name, grade);
                averageGrade = grade;
            } else {
                students.put(name, students.get(name) + grade);
                averageGrade = students.get(name) / 2;
                students.put(name, averageGrade);
            }
            n--;
        }
        for (Map.Entry<String, Double> student : students.entrySet()) {
            if(student.getValue() >= 4.50){
                System.out.printf("%s -> %.2f%n", student.getKey(), student.getValue());
            }
        }
    }
}
