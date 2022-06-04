package Maps;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(" -> ");
        Map<String, List<String>> companies = new LinkedHashMap<>();
        while(!command[0].equals("End")){
            String company = command[0];
            String employeeId = command[1];
            if(!companies.containsKey(company)){
                companies.put(company, new ArrayList<>());
                companies.get(company).add(employeeId);
            } else {
                if(!companies.get(company).contains(employeeId)){
                    companies.get(company).add(employeeId);
                }
            }
            command = scanner.nextLine().split(" -> ");
        }

        for (Map.Entry<String, List<String>> entry : companies.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            entry.getValue().forEach(e -> System.out.printf("-- %s%n", e));
        }
    }
}
