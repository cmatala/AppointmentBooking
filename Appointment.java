public class Appointment {
    // Instance variable to store the availability status
    private boolean available;

    // Default constructor that sets the availability to true
    public Appointment() {
        this.available = true;
    }

    // Getter method to retrieve the availability status
    public boolean isAvailable() {
        return available;
    }

    // Setter method to set the availability status
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // toString method to represent the object as a string
    @Override
    public String toString() {
        return "Appointment [available=" + available + "]";
    }
}
