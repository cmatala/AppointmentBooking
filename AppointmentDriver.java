import java.util.Scanner;

public class AppointmentDriver {
    // Constants
    private static final int NUM_PERIODS = 8;
    private static final int NUM_MINUTES = 60;



    // Global variables
    private static Scanner scanner = new Scanner(System.in);
    private static AppointmentBook appointmentBook = new AppointmentBook();

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();
            choice = getValidChoice();

            switch (choice) {
                case 1:
                    requestAppointment();
                    break;
                case 2:
                    printSchedules(2);
                    break;
                case 3:
                    printSchedules(3);
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }

    // Display the menu of user options
    private static void displayMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1--Schedule an appointment");
        System.out.println("2--List Period Schedule");
        System.out.println("3--List Full Schedule");
        System.out.println("4--Quit");
    }

    // Request an appointment from the user
    private static void requestAppointment() {
        System.out.print("Enter which period you are requesting the appointment for: ");
        int period = getValidPeriod();

        System.out.print("Enter the duration of the appointment: ");
        int duration = getValidDuration();

        boolean isBooked = appointmentBook.makeAppointment(appointmentBook.getAppointementBook()[period - 1], duration);

        if (isBooked) {
            System.out.println("Your " + duration + " minute appointment has been scheduled.");
        } else {
            System.out.println( duration + " minutes "+"is not available during period " + period);
        }

    }


    // Print schedules based on the display menu code (2 or 3)
    private static void printSchedules(int code) {
        if (code == 2) {
            System.out.print("Which period do you want to print? ");
            int period = getValidPeriod();
            printSinglePeriodSchedule(appointmentBook.getAppointementBook()[period - 1]);
        } else if (code == 3) {
            printFullSchedule();
        }
    }

    // Print a single period schedule
    private static void printSinglePeriodSchedule(Period period) {
        System.out.println(period);
    }

    // Print the entire schedule
    private static void printFullSchedule() {
        for (int i = 0; i < appointmentBook.getAppointementBook().length; i++) {
            Period p = appointmentBook.getAppointementBook()[i];
            System.out.println("Period " + (i + 1) + ":");
            System.out.println(p);
        }
    }




    // Helper method to get a valid choice from the user
    private static int getValidChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    // Helper method to get a valid period from the user
    private static int getValidPeriod() {
        int period;
        do {
            period = getValidChoice();
        } while (period < 1 || period > NUM_PERIODS);
        return period;
    }

    // Helper method to get a valid duration from the user
    private static int getValidDuration() {
        int duration;
        do {
            duration = getValidChoice();
            if (duration <= 0 || duration > NUM_MINUTES) {
                System.out.println("Invalid duration. Please enter a positive duration less than or equal to " + NUM_MINUTES + ".");
            }
        } while (duration <= 0 || duration > NUM_MINUTES);
        return duration;
    }




}





