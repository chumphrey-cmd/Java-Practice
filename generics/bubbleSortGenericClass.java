/// Main
public class Main {

    public static void main(String[] args) {

        Employee [] arr = {
                new Employee(26, 23400.23),
                new Employee(45, 230042.23),
                new Employee(18, 24000.23),
        };

        /// Here we are implementing Bubble sorting based off of the Employee Class!
        bubbleSort(arr);
        for(Employee e : arr)
            System.out.println("Sorted list based off of " + e);

    }

    /// Take note of the data type of "void" used here!
    public static <T extends Comparable<T>> void bubbleSort(T[] arr){

        int size = arr.length;
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (arr[j].compareTo(arr[j+1]) > 0){

                    /// Generic implementation here!
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

}

/// Employee Class
public class Employee implements Comparable<Employee> {

    private int empAge;
    private double empSalary;

    public Employee(int empAge, double empSalary) {
        this.empAge = empAge;
        this.empSalary = empSalary;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
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
                "empAge=" + empAge +
                ", empSalary=" + empSalary +
                '}';
    }

    public int compareTo(Employee obj){

        return empAge - obj.empAge;
    }

}

