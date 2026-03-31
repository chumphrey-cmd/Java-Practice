/// Main
public class Main {

    public static void main(String[] args) {

        Employee[] arr = {
                new Employee("Chuma", 25, 100.25),
                new Employee("Steve", 35, 2500.23),
                new Employee("Mary", 28, 23400.23)
        };
        boolean wasFound = linearSearch(arr, new Employee("Chuma", 25, 100.25));
        System.out.println("User found? " + wasFound);
    }


    public static <T extends Comparable<T>> boolean linearSearch(T[] arr, T value) {

        for (T item : arr)
            if (item.compareTo(value) == 0)
                return true;
        return false;


    }

}

/// Employee Class

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private String empName;
    private int employeeAge;
    private double empSalary;

    public Employee(String empName, int employeeAge, double empSalary) {
        this.empName = empName;
        this.employeeAge = employeeAge;
        this.empSalary = empSalary;

    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", employeeAge=" + employeeAge +
                ", empSalary=" + empSalary +
                '}';
    }

    /// NOTE: here we're using the built-in "compareTo" to search on the specific name of the Employee we want!
    public int compareTo(Employee obj){
        return this.empName.compareTo(obj.empName);
    }

}
