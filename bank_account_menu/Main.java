package practice_projects.bank_account_menu;

import java.util.Scanner;

import static bank_account_menu.BankAccount.*;

public class Main {

    public static void main (String[] args) {

        System.out.println("Welcome to the Jank Bank!");

        Scanner obj = new Scanner(System.in);
        int userInput;

        System.out.println("Please Select an Option:");
        displayMenu();
        userInput = obj.nextInt(); obj.nextLine();

        do{
            switch(userInput){
                case 1: depositFunds(); break;
                case 2: checkBalance(); break;
                case 3: withdrawFunds(); break;
                case 4: exit(); break;
                default: System.out.println("Invalid Option. Please try again.");
            }

            displayMenu();
            System.out.println("Please Select an Option:");
            userInput = obj.nextInt(); obj.nextLine();

        }while(userInput != 4);
    }
}
