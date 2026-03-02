/// Simple employee menu where you're provided a selection of options for employees that you want add, display information for, or average specific salaries.
/// Overall, were using this to demonstrat modular array creation.

/// Add Employee Public Class

import java.util.Scanner;

public class AddEmployee {
    public static void main (String[] args){
        System.out.println("Welcome to the Employee Dashboard...\nPlease Select An Option");

    }

    public static void displayMenu(){
        System.out.println("1. Add An Employee");
        System.out.println("2. Average Employee Age");
        System.out.println("3. Get Employee Salary Above Specific Amount");
        System.out.println("4. Display All Employee");
        System.out.println("5. Exit");
    }

    /// count needs to be localized to the add() method, to accomplish this, we need to return count so that our do-while loop can access it...
    /// int[] age, int count: passing the empty array of age and the int of count into the method...

    public static int addEmp(Employee[] employee, int count){

        if (count == employee.length){
            System.out.println("You've reached the maximum of your list...");
            return count;
        }
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter Employee Name: ");
        String empName = obj.nextLine();

        System.out.println("Enter the age: ");
        int employeeAge = obj.nextInt(); obj.nextLine();

        System.out.println("Enter Employee Salary: ");
        double empSalary = obj.nextDouble(); obj.nextLine();

        ///  Here we are filling the initialized empty array with count incrementing...
        employee[count] = new Employee(empName, employeeAge, empSalary);
        count = count + count;
        return count;

    }

    public static void avgEmp(Employee[] employee, int count){
        double sum = 0;

        for (int i = 0; i<count; i++){
            sum += employee[i].getEmployeeAge();
        }

        double avg = sum/count;
        System.out.println("The average age of your employees is: " + avg);

    }

    public static void ageEmpSummarySalary(Employee[] employee, int count){

        Scanner obj = new Scanner(System.in);
        System.out.print("Select a Salary You Want to Search Above: ");
        int threshold = obj.nextInt();

        for(int i = 0; i < count; i++)
            if(employee[i].getEmpSalary() >= threshold)
                System.out.println("Here are the salaries above " + threshold + ": " + employee[i]);

            else
                System.out.println("There are no employees that fall above the age of " + threshold);
    }

    public static void displayAllEmployeeInformation(Employee[] employee){
        ///  FOR EACH EXAMPLE, MUCH CLEANER "for `allAges` in each range of `age`..."
        for (Employee allEmployeeInformation : employee)
            System.out.println(allEmployeeInformation);
    }

    public static void exit(){
        System.out.println("Exiting, Goodbye...");
        System.exit(0);
    }
}

/// Main.java
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner obj = new Scanner(System.in);

        System.out.print("What is the Max Number of Employees You Want to Add: ");
        int maxEmpSize = obj.nextInt();
        int count = 0; // Used to keep track of the total lengths of arrays that we're working with...
        int choice;

        /// Here we are creating a new Employee array and setting the size of that employee array to maxEmpSize...
        Employee[] employee = new Employee[maxEmpSize];

        do{
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = obj.nextInt();

            switch(choice){
                /// Here we are setting the add() method equal to count which localizes count for add()
                case 1: count = addEmp(employee,count); break;
                case 2: avgEmp(employee,count); break;
                case 3: ageEmpSummarySalary(employee,count);break;
                case 4: displayAllEmployeeInformation(employee); break;
                case 5: exit(); return ;
                default: System.out.print("Invalid input...\n");
            }

        }while(true);

    }

}