public class Motorcycle extends Vehicle {

    private double topSpeed;

    public Motorcycle(String make, String vin, double price, double topSpeed){

        super(make, vin, price);
        this.topSpeed = topSpeed;
    }


    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return "Motorcycle " + super.toString() + " " + topSpeed;
    }
}
