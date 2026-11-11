import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RoomTest {

    private Room room;

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
}