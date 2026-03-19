public class Vehicle {
    private String make;
    private String vin;
    private double price;

    public Vehicle(String make, String vin, double price) {
        this.make = make;
        this.vin = vin;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRange(){
        return 0;
    }

    @Override
    public String toString() {
        return make + " " + vin + " " + price;
    }
}
