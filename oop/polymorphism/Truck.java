public class Truck extends Vehicle {

    private double towing;

    public Truck(String make, String vin, double price, double towing){

        super(make, vin, price);
        this.towing = towing;

    }

    public double getTowing() {
        return towing;
    }

    public void setTowing(double towing) {
        this.towing = towing;
    }

    @Override
    public String toString() {
        return "Truck " + super.toString() + " " + towing;
    }
}
