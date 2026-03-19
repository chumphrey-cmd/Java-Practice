public class Electric extends Vehicle {

    private double batteryRange;

    public Electric(String make, String vin, double price, double batteryRange){

        super(make, vin, price);
        this.batteryRange = batteryRange;

    }

    public double getRange() {
        return batteryRange;
    }

    public void setRange(double range) {
        this.batteryRange = range;
    }

    @Override
    public String toString() {
        return "Electric " + super.toString() + " " + batteryRange;
    }
}
