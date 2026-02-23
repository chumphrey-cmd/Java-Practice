// ATM example going over the topics discussed in class
// Should checkBalance(), deposit(), withdraw(), exit()

import java.util.Scanner;

public class BankAccount {

    public static int balance;

    public static void displayMenu(){
        System.out.println("1. Deposit Funds\n2. Check Balance\n3. Withdraw Funds\n4. Exit");
    }

    public static void checkBalance(){
        System.out.println("Your Balance Is: " + balance);
    }

    public static void depositFunds(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Deposit Amount: ");
        int depositAmount = obj.nextInt(); obj.nextLine();

        balance += depositAmount;
        System.out.println("Final Balance: " + balance);

    }

    public static void withdrawFunds(){
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter Withdraw Amount: ");
        int withdrawAmount = obj.nextInt(); obj.nextLine();
        balance -= withdrawAmount;

        System.out.println("Final Balance: " + balance);

    }

    public static void exit(){
        System.out.println("Thank you for using Jank Bank!");
        System.exit(0);
    }
}

