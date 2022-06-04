package Maps;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(" : ");
        Map<String, List<String>> courses = new LinkedHashMap<>();
        while(!command[0].equals("end")){
            String courseName = command[0];
            String studentName = command[1];
            if(!courses.containsKey(courseName)){
                courses.put(courseName, new ArrayList<>());
                courses.get(courseName).add(studentName);
            } else {
                if(!courses.get(courseName).contains(studentName)){
                    courses.get(courseName).add(studentName);
                }
            }
            command = scanner.nextLine().split(" : ");
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            entry.getValue().forEach(e -> System.out.printf("-- %s%n", e));
        }
    }
}
