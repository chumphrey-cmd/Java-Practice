public class MovieTheaterTicketingSystem {

    public static void main(String[] args) {

        System.out.println("Welcome to the Movie Theater Kiosk!");
        System.out.println("Here is the list of available seating!");

        /// Need to move this outside of the do-while because it will consume resources each time the loop is ran....
        Scanner obj = new Scanner(System.in);

        int[] seats = {1, 0, 1, 1, 1, 0, 1, 0, 0, 1};
        displaySeats(seats);

        do {
            System.out.println("Which seat would you like to reserve? (Enter 1-10, or 0 to quit)");
            int userChoice = obj.nextInt();
            obj.nextLine();

            if (userChoice >= 1 && userChoice <= 10)
                reserveSeats(seats, userChoice);


            else if (userChoice == 0) {
                System.out.println("Exiting Movie Theater Kiosk, goodbye...");
                System.exit(0);
            }

            else {
                System.out.println("Invalid choice, try again...\n");
                displaySeats(seats);
            }
        }while(true);
    }


    public static void displaySeats(int[] seats){

        /// NOTE: an enhanced for loop isn't allowed here because we want to access the POSITION, not the value. The enhanced for-loop only gives you the value...

        for (int i = 0; i < seats.length; i++) {

            if (seats[i] == 0) {
                System.out.println("Seat " + (i + 1) + ": Empty");
            }else
                System.out.println("Seat " + (i + 1) + ": Taken");
        }

    }

    public static void reserveSeats(int [] seats, int userChoice){

        // Here we need to subtract 1 from the user choice to simulate the actual value that the user is wanting to determine (e.g., userChoice = 1; actualIndex = 0)
        int actualIndex = userChoice - 1;

        if (seats[actualIndex] == 0){
            seats[actualIndex] = 1;
            System.out.println("Seat " + userChoice + " is reserved for you!");
        }
        else{
            System.out.println("Sorry, seat " + userChoice + " is already taken!");
        }
    }
}