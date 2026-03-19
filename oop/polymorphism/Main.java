import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Dealership myDealership = new Dealership();
        Scanner obj = new Scanner(System.in);

        System.out.println("Welcome to the Dealer Dashboard");
        myDealership.displayMenu();
        System.out.println("Please Select a Choice");
        int choice;

        do{
            choice = obj.nextInt();
            obj.nextLine();

            switch(choice){

                case 1: myDealership.addVehicle(); break;
                case 2: myDealership.removeVehicle(); break;
                case 3: myDealership.displayAllVehicleInfo(); break;
                case 4: myDealership.displayLowestPricedVehicleFirst(); break;
                case 5: myDealership.displayUnderCertainAmount(); break;
                case 6: myDealership.displayElectricVehicleAboveSpecificRange(); break;
                case 7: myDealership.exportAllInventory(); break;
                case 8: myDealership.importInventoryFromFile(); break;
                case 9:
                    System.out.println("Exiting, Goodbye!");
                    System.exit(0); return;
                default:
                    System.out.println("Try Again!");
            }
            myDealership.displayMenu();
        }while(choice !=9);

    }
}
