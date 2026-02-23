import java.text.DecimalFormat;
import java.util.Scanner;

public class InvestmentCalculator {

    // Creating a tool to calculate the future value of an investment.

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        System.out.println("Welcome to the Investment Calculator!\n");

        System.out.print("How Much Do You Have Saved? ");
        double currentBalance = obj.nextDouble(); obj.nextLine();

        while (currentBalance < 0) {
            System.out.println("You cannot enter a negative number, try again!");
            currentBalance = obj.nextDouble(); obj.nextLine();
        }

        System.out.print("Enter the Current Interest Rate: ");
        double interestRate = obj.nextDouble(); obj.nextLine();

        while (interestRate < 0) {
            System.out.println("Please enter a valid interest rate:");
            interestRate = obj.nextDouble(); obj.nextLine();
        }

        System.out.print("Enter your age: ");
        int userAge = obj.nextInt();
        obj.nextLine();

        while (userAge < 0) {
            System.out.println("Please enter a valid age:");
            userAge = obj.nextInt(); obj.nextLine();
        }

        System.out.print("Enter your desired retirement age: ");
        int retirementAge = obj.nextInt();
        obj.nextLine();

        while (retirementAge < userAge || retirementAge == 0) {
            System.out.println("Please enter a retirement age greater than your current age:");
            retirementAge = obj.nextInt(); obj.nextLine();
        }

        int yearsToRetirement = retirementAge - userAge;
        for (int i = 0; i < yearsToRetirement; i++) {
            double newBalance;
            newBalance = currentBalance + (currentBalance *(interestRate/100));
            currentBalance = newBalance;

            // Formatted output (https://www.geeksforgeeks.org/java/formatted-output-in-java/)
            DecimalFormat account = new DecimalFormat("$###,###,###,###,###.##");
            System.out.println("Year " + (i + 1) + ": " + account.format(currentBalance));
        }
    }
}