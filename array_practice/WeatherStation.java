/// Basic demonstration of using arrays to accepts user input and then output information about the information that was recieved, average the data, and then output the information at the very end.

import java.util.Arrays;
import java.util.Scanner;

public class WeatherStation {

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);

        System.out.println("How many days of data do you want? ");
        int daysOfData = obj.nextInt();

        double average;
        double sum = 0;

        double [] tempData = new double[daysOfData];
        int length = tempData.length;

        double lowest = tempData[0];
        double highest = tempData[0];

        for (int i = 0; i < length; i ++){
            System.out.println("Enter the temperature for day " + (i+1) + " :");
            double inputTemp = obj.nextDouble();
            obj.nextLine();

            tempData[i] = inputTemp;

            /// Here we are addressing the issue of the "Ghost Index" which would create the invisible value of "0.0"
            if (i == 0) {
                lowest = inputTemp;
                highest = inputTemp;
            }

            else if (tempData[i] < lowest)
                lowest = tempData[i];

            else if (tempData[i] > highest)
                highest = tempData[i];

        }
        // Array to String sanity check
        System.out.println("Here are the temperatures: " + Arrays.toString(tempData));

        // Enhance for-loop
        for (double tempPrint : tempData){
            System.out.println("Temperature(s) Entered: " + tempPrint);
            sum += tempPrint;
        }

        // Average Temperature
        average = sum/length;
        System.out.println("Average Temperature: " + average);

        // Highest and Lowest Temperatures
        System.out.println("Highest Temp: " + highest);
        System.out.println("Lowest Temp: " + lowest);
    }

}
