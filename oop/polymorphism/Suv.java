public class Suv extends Vehicle{

    private int seats;

    public Suv(String make, String vin, double price, int seats){

        super(make, vin, price);
        this.seats = seats;

    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Suv " + super.toString() + " " + seats;
    }
}
