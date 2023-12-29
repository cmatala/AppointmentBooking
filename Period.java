public class Period {
    // Instance variable to store an array of Appointment objects
    private Appointment[] appointmentList;
    // Default constructor that initializes the array and loads each element with Appointment objects
    public Period() {
        this.appointmentList = new Appointment[60];
        for (int i = 0; i < 60; i++) {
            this.appointmentList[i] = new Appointment();
        }
    }

    // Getter method to return a copy of the array
    public Appointment[] getAppointments() {
        // Returning a copy of the array to prevent external modification
        return appointmentList.clone();
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int minute = 0; minute < 60; minute++) {
            result.append("Minute: ").append(minute).append(": Available: ").append(appointmentList[minute].isAvailable()).append("\n");
        }

        return result.toString();
    }

}

