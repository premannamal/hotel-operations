import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class RoomTest {

    private Room room;

    @BeforeEach
    public void setUp() {
        // Initialize a standard room before each test
        room = new Room(2, 150.00f);
    }

    @Test
    public void CheckIn() {
        // Given an available room
        assertTrue(room.isAvailable());

        // When checking in
        room.checkIn();

        // Then the room should be occupied and dirty, and no longer available
        assertTrue(room.isOccupied(), "Room should be occupied after check-in.");
        assertTrue(room.isDirty(), "Room should be dirty after check-in.");
        assertFalse(room.isAvailable(), "Room should no longer be available after check-in.");
    }

    @Test
    public void CheckOut() {
        // Given an occupied room
        room.checkIn();
        assertTrue(room.isOccupied());

        // When checking out
        room.checkOut();

        // Then the room should no longer be occupied, but remain dirty until cleaned
        assertFalse(room.isOccupied(), "Room should not be occupied after checkout.");
        assertTrue(room.isDirty(), "Room should remain dirty after checkout until cleaned.");
        assertFalse(room.isAvailable(), "Room should not be available yet because it is dirty.");
    }

    @Test
    public void CleanRoom() {
        // Given a checked-out room (which is unoccupied and dirty)
        room.checkIn();
        room.checkOut();
        assertTrue(room.isDirty());
        assertFalse(room.isOccupied());

        // When cleaning the room
        room.cleanRoom();

        // Then the room should no longer be dirty and should be available again
        assertFalse(room.isDirty(), "Room should no longer be dirty after cleaning.");
        assertTrue(room.isAvailable(), "Room should be available after cleaning.");
    }

}