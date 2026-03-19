public class Gas extends Vehicle{

    private double horsePower;

    public Gas(String make, String vin, double price, double horsePower){

        super(make, vin, price);
        this.horsePower = horsePower;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Gas " + super.toString() + " " + horsePower;
    }
}
