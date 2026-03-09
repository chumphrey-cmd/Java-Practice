

public class InheritancePractice {

    public static void main(String[] args) {

        System.out.println("--- Testing Parent (Vehicle) ---");
        Vehicle veh = new Vehicle("Generic Brand", 24000);
        veh.displayInfo();
        veh.startEngine();

        System.out.println("\n--- Testing Child (Car) ---");
        Car myCar = new Car("Toyota", 35000, 4);
        myCar.displayInfo();

        // Testing Override vs Overload
        myCar.startEngine();        // Calls the OVERRIDDEN method
        myCar.startEngine(true);    // Calls the OVERLOADED method

        System.out.println("\n--- Testing Grandchild (Hybrid) ---");
        Hybrid myHybrid = new Hybrid("Prius", 28000, 4, 100);
        myHybrid.displayInfo();

        System.out.println("\n--- Testing Child (Motorcycle) ---");
        Motorcycle motorCycle = new Motorcycle("Indian", 35000, false);
        motorCycle.displayInfo();
        motorCycle.startEngine();
    }
}

// PARENT CLASS
class Vehicle {

    // PRIVATE: Only visible inside Vehicle. Children cannot touch this directly!
    private int price;

    // PROTECTED: Visible to Vehicle, AND its children (Car, Hybrid)
    protected String brand;

    // CONSTRUCTOR: Sets up the object when it's created
    public Vehicle(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    // PUBLIC: Everyone has access
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Price: $" + price);
    }

    public void startEngine() {
        System.out.println("The generic vehicle engine starts... Vroom.");
    }

    // GETTER: The only way outsiders (even children) can read the private price
    public int getPrice() {
        return price;
    }
}

class Motorcycle extends Vehicle {

    // Unique property just for Motorcycles
    private boolean hasSidecar;

    public Motorcycle(String brand, int price, boolean hasSidecar) {
        super(brand, price);

        // This unique to motorcycle specifically!
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void startEngine() {
        super.startEngine();

        System.out.print("This " + super.brand + " roars loudly! ");

        // Custom logic based on the Motorcycle's unique property
        if (hasSidecar) {
            System.out.println("Hop in the sidecar, let's go!");
        } else {
            System.out.println("Hold on tight!");
        }
    }
}

// CHILD CLASS
class Car extends Vehicle {

    private int numberOfDoors;

    public Car(String brand, int price, int numberOfDoors) {
        // super() = Calling the parent's constructor. This MUST be the first line!
        super(brand, price);
        this.numberOfDoors = numberOfDoors;
    }

    // OVERRIDE = Same method name, same signature!
    @Override
    public void startEngine() {
        // super.methodName() = triggering the parent's exact code before adding our own
        super.startEngine();

        // super.value = accessing the protected variable from the parent
        System.out.println("This " + super.brand + " purrs quietly. It has " + numberOfDoors + " doors.");
    }

    // OVERLOAD = Same method name, DIFFERENT signature (takes a boolean this time)
    public void startEngine(boolean isRemoteStart) {
        if (isRemoteStart) {
            System.out.println("Starting the " + brand + " remotely with the key fob!");
        } else {
            startEngine(); // Just calls the normal startEngine() above
        }
    }
}



/// FINAL = This puts a lock on the class. No one can ever 'extend Hybrid'!
final class Hybrid extends Car {

    private int batteryLife;

    public Hybrid(String brand, int price, int numberOfDoors, int batteryLife) {
        super(brand, price, numberOfDoors); // Calls the Car constructor
        this.batteryLife = batteryLife;
    }

    @Override
    public void displayInfo() {
        // Notice we MUST use getPrice() here because 'price' is PRIVATE in Vehicle!
        // But we can use 'brand' directly because it is PROTECTED.
        System.out.println("Hybrid Brand: " + brand + ", Price: $" + getPrice() + ", Battery: " + batteryLife + "%");
    }
}

