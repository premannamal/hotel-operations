
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    public void setUp() {
        // Initialize a test employee before each test runs
        employee = new Employee(101, "Jane Doe", "Housekeeping");
    }

    @Test
    public void testPunchInSuccess() {
        // When punching in an available employee
        employee.punchIn();

        // Then they should be marked as punched in
        assertTrue(employee.isPunchedIn(), "Employee should be punched in after calling punchIn().");
    }

    @Test
    public void testPunchOutSuccess() throws InterruptedException {
        // Given a punched-in employee
        employee.punchIn();
        assertTrue(employee.isPunchedIn());

        // Simulate a brief wait so time elapses for duration tracking
        Thread.sleep(1000);

        // When punching out
        employee.punchOut();

        // Then they should no longer be punched in and hours should be recorded (> 0)
        assertFalse(employee.isPunchedIn(), "Employee should not be punched in after punchOut().");
        assertTrue(employee.getTotalHoursWorked() > 0.0, "Total hours worked should be greater than zero after a shift.");
    }

}