public class AppointmentBook {
    // Instance variable to store an array of Period objects
    private Period[] periodList;

    // Default constructor that initializes the array of Period objects
    public AppointmentBook() {
        this.periodList = new Period[8];
        for (int i = 0; i < 8; i++) {

            this.periodList[i] = new Period();
        }
    }

    // Setter method to copy the contents of the passed-in array into the class array
    public void setAppointmentBook(Period[] period) {
        // Make a defensive copy to avoid external modification
        this.periodList = period.clone();
    }

    // Getter method to return a copy of the class array of Period objects
    public Period[] getAppointementBook() {
        // Returning a copy of the array to prevent external modification
        return periodList.clone();
    }


    // toString method to repeatedly call the toString of the Period class
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n");

        for (Period period : periodList) {
            result.append(period.toString()).append("\n");
        }

        return result.toString();
    }

    // isMinuteFree method to check if a specific minute in a period is free
    private boolean isMinuteFree(Period period, int minute) {
        // Assuming that 'minute' is within a valid range (0 to 59)
        Appointment[] appointments = period.getAppointments();
        return appointments[minute].isAvailable();
    }

    // reserveBlock method to mark a block of time as reserved in a specific period
    private void reserveBlock(Period period, int startMinute, int duration) {
        // Assuming startMinute and duration are valid values

        Appointment[] appointments = period.getAppointments();

        for (int minute = startMinute; minute < startMinute + duration + 1 && minute < 60; minute++) {
            appointments[minute].setAvailable(false);
        }
    }

    // findFreeBlock method to search for a block of consecutive free time in a specific period
    private int findFreeBlock(Period period, int duration) {
        Appointment[] appointments = period.getAppointments();

        for (int startMinute = 0; startMinute <= 60 - duration; startMinute++) {
            boolean isFree = true;

            for (int minute = startMinute; minute < startMinute + duration; minute++) {
                if (!appointments[minute].isAvailable()) {
                    isFree = false;
                    break; // Break if any minute in the block is not free
                }
            }

            if (isFree) {
                return startMinute; // Return the first minute of the free block
            }
        }

        return -1; // No block of consecutive free time found
    }

    // makeAppointment method to schedule an appointment in a specific period
    public boolean makeAppointment(Period period, int duration) {
        int startMinute = findFreeBlock(period, duration);

        if (startMinute == -1) {

            return false;
        } else {
            reserveBlock(period, startMinute, duration);
            return true;
        }
    }




}
