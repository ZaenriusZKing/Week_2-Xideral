package Stream_1;

/* Code finished in: 24/08/24
 * 
 * By Fernando Sánchez González
 */

//Employee class where we define the characteristics of the employee
public class Employee {
 private String name;
 private String department;
 private int yearsOfExperience;
 private double salary;

 public Employee(String name, String department, int yearsOfExperience, double salary) {
     this.name = name;
     this.department = department;
     this.yearsOfExperience = yearsOfExperience;
     this.salary = salary;
 }

 // Getters
 public String getName() { 
     return name; 
 }

 public String getDepartment() { 
     return department; 
 }

 public int getYearsOfExperience() { 
     return yearsOfExperience; 
 }

 public double getSalary() { 
     return salary; 
 }

 // Setter
 public void setSalary(double salary) { 
     this.salary = salary; 
 }

 @Override
 public String toString() {
     return name + " (" + department + ")";
 }
}

