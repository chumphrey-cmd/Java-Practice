import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Dealership {

    private ArrayList<Vehicle> vehicle;

    public Dealership(){
        vehicle = new ArrayList<Vehicle>();
    }

    public void addVehicle(){

        Scanner obj = new Scanner(System.in);
        int choice = 0;


        do {
            vehicleMenuDisplay();
            System.out.println("Enter Vehicle Type:");
            choice = obj.nextInt();
            obj.nextLine();

            switch(choice){
                case 1: addMotorcycle(); break;
                case 2: addTruck(); break;
                case 3: addSuv(); break;
                case 4: addEV(); break;
                case 5: addGas(); break;
                case 6: addHybrid(); break;
                case 7:
                    System.out.println("Back to Main Page"); return;
                default:
                    System.out.println("Try Again!");
            }

        }while(choice != 7);


    }

    private void vehicleMenuDisplay(){

        System.out.println("1. Motorcycle");
        System.out.println("2. Truck");
        System.out.println("3. SUV");
        System.out.println("4. Electric");
        System.out.println("5. Gas");
        System.out.println("6. Hybrid");
        System.out.println("7. Return");

    }

    private void addMotorcycle(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter make:");
        String make = obj.nextLine();

        System.out.println("Enter VIN");
        String vin = obj.nextLine();

        System.out.println("Enter price:");
        double price = obj.nextDouble();
        obj.nextLine();

        System.out.println("Enter top speed:");
        double topSpeed = obj.nextDouble();
        obj.nextLine();

        vehicle.add(new Motorcycle(make, vin, price, topSpeed));
    }

    private void addTruck(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter make:");
        String make = obj.nextLine();

        System.out.println("Enter VIN");
        String vin = obj.nextLine();

        System.out.println("Enter price:");
        double price = obj.nextDouble();
        obj.nextLine();

        System.out.println("Enter towing capacity:");
        double towingCapacity = obj.nextDouble();
        obj.nextLine();

        vehicle.add(new Truck(make, vin, price, towingCapacity));
    }

    private void addSuv(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter make:");
        String make = obj.nextLine();

        System.out.println("Enter VIN");
        String vin = obj.nextLine();

        System.out.println("Enter price:");
        double price = obj.nextDouble();
        obj.nextLine();

        System.out.println("Enter number of seats:");
        int seats = obj.nextInt();
        obj.nextLine();

        vehicle.add(new Suv(make, vin, price, seats));
    }

    private void addEV(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter make:");
        String make = obj.nextLine();

        System.out.println("Enter VIN");
        String vin = obj.nextLine();

        System.out.println("Enter price:");
        double price = obj.nextDouble();
        obj.nextLine();

        System.out.println("Enter battery range:");
        double battery = obj.nextDouble();
        obj.nextLine();

        vehicle.add(new Electric(make, vin, price, battery));
    }

    private void addGas(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter make:");
        String make = obj.nextLine();

        System.out.println("Enter VIN");
        String vin = obj.nextLine();

        System.out.println("Enter price:");
        double price = obj.nextDouble();
        obj.nextLine();

        System.out.println("Enter horse power:");
        double horsePower = obj.nextDouble();
        obj.nextLine();

        vehicle.add(new Gas(make, vin, price, horsePower));
    }

    private void addHybrid(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter make:");
        String make = obj.nextLine();

        System.out.println("Enter VIN");
        String vin = obj.nextLine();

        System.out.println("Enter price:");
        double price = obj.nextDouble();
        obj.nextLine();

        System.out.println("Enter Miles Per Gallon:");
        double mpg = obj.nextDouble();
        obj.nextLine();

        vehicle.add(new Hybrid(make, vin, price, mpg));
    }

    public void removeVehicle(){
        System.out.println("==============");
        System.out.println("Enter a VIN to remove...");
        System.out.println("==============");

        Scanner obj = new Scanner(System.in);
        String choice = obj.nextLine();

        for (int i = 0; i < vehicle.size(); i++){
            if(vehicle.get(i).getVin().equals(choice)){
                System.out.println("Removing the vehicle with a VIN of " + vehicle.get(i).getVin() + " ...");
                vehicle.remove(i);
                return;
            }
            System.out.println("VIN not found, try again...");
        }



    }

    public void displayAllVehicleInfo(){

        System.out.println("==============");
        System.out.println("All Vehicle Info:");
        System.out.println("==============");

        for (Vehicle v : vehicle)
            System.out.println(v);

    }

    public void displayLowestPricedVehicleFirst(){

        System.out.println("==============");
        System.out.println("Displaying Lowest Priced Vehicles First:");
        System.out.println("==============");

        vehicle.sort(Comparator.comparing(Vehicle :: getPrice).reversed());

        for (Vehicle lowestToHighest : vehicle){
            System.out.println(lowestToHighest);
        }
    }

    public void displayUnderCertainAmount(){

        System.out.println("==============");
        System.out.println("Enter a price of vehicles you want to search below:");
        System.out.println("==============");

        Scanner obj = new Scanner(System.in);
        double choice = obj.nextDouble();
        obj.nextLine();

        for (Vehicle lowestToHighest : vehicle){
            if (lowestToHighest.getPrice() < choice)
                System.out.println(lowestToHighest);
        }
    }

    public void displayElectricVehicleAboveSpecificRange(){

        System.out.println("==============");
        System.out.println("Electric Vehicle Range You Want to Search For?");
        System.out.println("==============");

        Scanner obj = new Scanner(System.in);
        double choice = obj.nextDouble();
        obj.nextLine();

        for (Vehicle v : vehicle){
            if(v.getRange() > choice){
                System.out.println("EVs with a Range above the Range of " + choice + " miles");
                System.out.println(v);
                return;
            }
        }
            System.out.println("Selection criteria not found, try again...");

    }

    public void exportAllInventory(){

        System.out.println("==============");
        System.out.println("Exporting Inventory:");
        System.out.println("==============");


        try {
            File dir = new File("src/mar/mar_19_exam");
            FileWriter myWriter = new FileWriter(new File (dir,"your_cars.txt"));
            for (Vehicle veh : vehicle){
                myWriter.write(veh + System.lineSeparator());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file at " + dir);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void importInventoryFromFile(){

        System.out.println("==============");
        System.out.println("Importing Inventory:");
        System.out.println("==============");

        File dir = new File("src/mar/mar_19_exam/your_cars.txt");

        // Each time that you upload, you need to clear the array to avoid uploading multiple copies of the same array!
        vehicle.clear();

        // Putting this in these parentheses auto-closes the file to prevent memory leaks!

        try (BufferedReader bf = new BufferedReader(new FileReader(dir))) {

            String line;

            // Read line-by-line until the file ends
            while ((line = bf.readLine()) != null) {

                if (line.trim().isEmpty())
                    continue;

                // 1. Chop the text into pieces (Change "," to "\\|" if you used pipes!)
                String[] pieces = line.split(" ");

                // Grab the common variables (Indices 0, 1, 2, 3), .trim() removes blank space
                String type = pieces[0].trim();
                String make = pieces[1].trim();
                String vin = pieces[2].trim();
                double price = Double.parseDouble(pieces[3].trim());

                // Automatic switching based off the first value that is at index[0] (the name of vehicle classes)
                switch (type) {
                    case "Motorcycle":
                        double topSpeed = Double.parseDouble(pieces[4].trim());

                        // Build the object and add it!
                        vehicle.add(new Motorcycle(make, vin, price,topSpeed));
                        break;

                    case "Truck":
                        double towing = Double.parseDouble(pieces[4].trim());

                        vehicle.add(new Truck(make, vin, price,towing));
                        break;

                    case "Suv":
                        int seats = Integer.parseInt(pieces[4].trim());

                        vehicle.add(new Suv(make, vin, price, seats));
                        break;

                    case "Electric":
                        double batteryRange = Double.parseDouble(pieces[4].trim());

                        vehicle.add(new Electric(make, vin, price,batteryRange));
                        break;

                    case "Gas":
                        double horsePower = Double.parseDouble(pieces[4].trim());

                        vehicle.add(new Gas(make, vin, price, horsePower));
                        break;

                    case "Hybrid":
                        double mpg = Double.parseDouble(pieces[4].trim());

                        vehicle.add(new Hybrid(make, vin, price, mpg));
                        break;
                }
            }

            int x = 0;

            System.out.println("Employees successfully loaded!");

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file! Make sure the path is correct.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        } catch (Exception e) {
            System.out.println("There must be a formatting error in your parsing...");
            System.out.println("The exact error was: " + e);
        }


    }

    public void displayMenu(){
        System.out.println("1. Add Vehicle");
        System.out.println("2. Remove Vehicle By ID");
        System.out.println("3. Display All Vehicle Info");
        System.out.println("4. Display Lowest Priced Vehicle First");
        System.out.println("5. Display Vehicle Under Certain Amount");
        System.out.println("6. Display Electric Vehicle Above Specific Range");
        System.out.println("7. Export All Inventory to File");
        System.out.println("8. Import Inventory from File");
        System.out.println("9. Exit");
    }
}
