/*************************************************************
 * Program : Main.java
 * Purpose : Calculates the price it charges for parking based
 * on the day of the week and the time spent parked.
 *
 * Created : 8/30/2025
 * Programmer : D. McCallum
 ******************* Change history *********************
 * Programmer Date Description of change
 *
 * N/A.
 ***********************************************************/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Invokes the garage prompt
        displayPrompt();
    }

    // Function to display the menu & prompts to the user
    static void displayPrompt(){

        // Declare required local variable members
        Scanner input = new Scanner(System.in);
        String daySelected;
        boolean isDayValid = false;
        int arrivalTime;
        int departureTime;

        // Displays the message and scanner to the user
        System.out.println("Please enter the day of the week: ");
        daySelected = input.nextLine().toLowerCase();

        switch (daySelected) {
            case "mon":
                daySelected = "Monday";
                isDayValid = true;
                break;
            case "tue":
                daySelected = "Tuesday";
                isDayValid = true;
                break;
            case "wed":
                daySelected = "Wednesday";
                isDayValid = true;
                break;
            case "thu":
                daySelected = "Thursday";
                isDayValid = true;
                break;
            case "fri":
                daySelected = "Friday";
                isDayValid = true;
                break;
            case "sat":
                daySelected = "Saturday";
                isDayValid = true;
                break;
            case "sun":
                daySelected = "Sunday";
                isDayValid = true;
                break;
            default:
                System.out.println("Please insert a valid three letter day abbreviation");

        }

        // Calculates the rate based on the day of the week
        double dailyRate;
        if (daySelected.startsWith("Saturday") || daySelected.startsWith("Sunday")){
            dailyRate = 0.50;
        } else {
            dailyRate = 1.25;
        }

        // Continues the prompt if the day entered is valid
        if (isDayValid){
            System.out.println("Please enter the vehicle's arrival time: ");
            arrivalTime = input.nextInt();
            System.out.println("Please enter its departure time: ");
            departureTime = input.nextInt();

            int duration = convertTime(arrivalTime, departureTime);
            double rate = parkingRate(daySelected, duration, dailyRate);

            if (duration <= 0){
                System.out.println("Please start the process over again.");
            } else {
                // Displays output message
                System.out.printf("Day of the week: " + daySelected);
                System.out.printf("\nParking duration in minutes: %d, rate: $%.2f%n", duration, dailyRate);
                System.out.printf("Amount charged: $%.2f%n", rate);
            }
        }

    }

    // Function to convert arrival time into minutes
    static int convertTime(int arrival, int departure){

        // Convert arrival time into minutes
        int arrivalMin = (arrival / 100) * 60 + (arrival % 100);
        int departMin = (departure / 100) * 60 + (departure % 100);

        // Checks for discrepancies between arrival and departure time
        if (arrivalMin >= departMin){
            System.out.println("Arrival time must be earlier than departure time, please try again");
        }

        // Returns the duration
        return departMin - arrivalMin;
    }

    // Function to calculate the rate
    static double parkingRate(String day, int duration, double rate){

        // If time exceeds 15-minute intervals it rounds up
        int interval = duration / 15;
        if (duration % 15 != 0){
            interval++;
        }

        // Calculates the final charges
        double charge = interval * rate;
        if (charge > 15.00){
            charge = 15.00;
        }

        return charge;

    }
}