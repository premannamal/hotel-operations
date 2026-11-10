import java.util.*;
public class Room {

int numberOfBeds;
float price;
String status = "Available";
int roomNumber;

public Room(int numberOfBeds, float price)
{
    this.numberOfBeds = numberOfBeds;
    this.price = price;
}

 public int getNumberOfBeds() {
    return numberOfBeds;
 }

 public float getPrice() {
    return price;
 }

 public boolean isOccupied() {
    return ("Occupied".equalsIgnoreCase(this.status));
 }

    public boolean isAvailable() {
        return ("Available".equalsIgnoreCase(this.status));
    }

    public boolean isDirty() {
        return ("Dirty".equalsIgnoreCase(this.status));
    }

 public void setStatus(String status) {
    this.status = status;
 }

    public static void main(String[] args) {
        Room R101 = new Room(2,139.99f);
        Room R201 = new Room( 1, 109.99f);
        Room R301 = new Room(2, 159.99f);

        System.out.println("No of beds in Room Number 101 = " + R101.getNumberOfBeds());
        System.out.println("No of beds in Room Number 201 = " + R201.getNumberOfBeds());
        R201.setStatus("Occupied");
        R301.setStatus("Available");
        R101.setStatus("Dirty");
        System.out.println("Is Room Number 301 Occupied? = " + R301.isOccupied());
        System.out.println("Is Room Number 101 Dirty? = " + R101.isDirty());
        System.out.println("Is Room Number 201 Available? = " + R201.isAvailable());

    }
}
