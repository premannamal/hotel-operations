import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {

     int employeeId;
     String name;
     String department;

    // Time tracking fields
     LocalDateTime lastPunchInTime;
     LocalDateTime lastPunchOutTime;
     double totalHoursWorked = 0.0;
     boolean isPunchIn = false;

    // Constructor
    public Employee(int employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    /**
     * Punches the employee in if they are not already punched in.
     */
    public void punchIn() {
        if (isPunchIn) {
            System.out.println(name + " is already punched in!");
            return;
        }

        this.lastPunchInTime = LocalDateTime.now();
        this.isPunchIn = true;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(name + " punched IN at: " + lastPunchInTime.format(formatter));
    }

    public void punchOut() {
        if (!isPunchIn) {
            System.out.println(name + " is not currently punched in!");
            return;
        }

        this.lastPunchOutTime = LocalDateTime.now();
        this.isPunchIn = false;

        // Calculate hours worked for this session
        Duration sessionDuration = Duration.between(lastPunchInTime, lastPunchOutTime);
        double hoursElapsed = sessionDuration.toSeconds() / 3600.0;
        this.totalHoursWorked += hoursElapsed;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(name + " punched OUT at: " + lastPunchOutTime.format(formatter));
        System.out.printf("Session hours: %.2f | Total hours today: %.2f%n", hoursElapsed, totalHoursWorked);
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public boolean isPunchedIn() {
        return isPunchIn;
    }

    public double getTotalHoursWorked() {
        return totalHoursWorked;
    }

    // Optional main method to demonstrate how it works
    public static void main(String[] args) throws InterruptedException {
        Employee emp = new Employee(101, "Alex Smith", "Front Desk");

        // Test punching in
        emp.punchIn();

        // Simulate working for a brief moment (e.g., 2 seconds for testing)
        Thread.sleep(2000);

        // Test punching out
        emp.punchOut();

        // Test trying to punch out again when already out
        emp.punchOut();
    }
}


