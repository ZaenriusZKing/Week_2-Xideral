package Stream_1;

/* Code finished in: 24/08/24
 * 
 * By Fernando Sánchez González
 */

//Employee Performance Analysis
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

 public static void main(String[] args) {
     
     // The list of employees is created
     List<Employee> employees = Arrays.asList(
         new Employee("Fernando", "Engineering", 5, 80000.0),
         new Employee("Nyssa", "Engineering", 8, 90000.0),
         new Employee("Linda", "HR", 3, 65000.0),
         new Employee("Bicho", "HR", 6, 70000.0),
         new Employee("Nydia", "Sales", 4, 72000.0),
         new Employee("Roberto", "Sales", 7, 85000.0)
     );
     
     // Process the employees to identify top performers in each department
     // 1. Filter employees with more than 4 years of experience
     // 2. Peek to display employee names
     // 3. Sort employees by department
     // 4. FlatMap to convert employee names into a stream
     // 5. Terminal operation: Collecting employee names by department
     
     // Converting the list of employees into a Stream and processing it to identify top-performing employees by department
     Map<String, List<String>> topDepartmentEmployees = employees.stream()
         .filter(employee -> employee.getYearsOfExperience() > 4) //1
         .peek(employee -> System.out.println("Filtered employee: " + employee.getName())) //2
         .sorted((e1, e2) -> e1.getDepartment().compareTo(e2.getDepartment())) //3
         .flatMap(employee -> Collections.singletonList(employee.getName()).stream()) //4
         .collect(Collectors.groupingBy( //5
             employeeName -> employees.stream()
                 .filter(e -> e.getName().equals(employeeName))
                 .findFirst()
                 .map(e -> e.getDepartment())
                 .orElse("Unknown"))) 
         ;
     
     // Output the results
     topDepartmentEmployees.forEach((department, employeeNames) -> 
         System.out.println("Department: " + department + ", Top Employees: " + employeeNames));
 }
}

