public class Hybrid extends Vehicle {

    private double mpg;

    public Hybrid(String make, String vin, double price, double mpg){

        super(make, vin, price);
        this.mpg = mpg;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    @Override
    public String toString() {
        return "Hybrid " + super.toString() + " " + mpg;
    }
}
