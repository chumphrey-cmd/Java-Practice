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

        for (int i = 0; i < length; i ++){
            System.out.println("Enter the temperature for day " + (i+1) + " :");
            double inputTemp = obj.nextDouble();
            obj.nextLine();

            tempData[i] = inputTemp;

        }
        // Array to String sanity check
        System.out.println("Here are the temperatures: " + Arrays.toString(tempData));

        // Enhance for-loop
        for (double tempPrint : tempData){
            System.out.println("Temperature(s) Entered: " + tempPrint);
            sum += tempPrint;
        }

        average = sum/length;
        System.out.println("Average Temperature: " + average);

    }

}