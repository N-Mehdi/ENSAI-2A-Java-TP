package fr.ensai.elevator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.beans.Transient;

public class ElevatorTest {

    /** Checks that the elevator is full after filling it
     * to the max. */
    @Test
    void elevatorIsFullTest() {

        //GIVEN
        Elevator elevator = new Elevator(1, 1, 3);
        elevator.fillElevatorPassenger(3);

        //WHEN
        int nbPassenger = elevator.getPassengers().size();
        int capacity = elevator.getCapacity();

        //THEN
        assertEquals(nbPassenger, capacity);
    }

    /** Checks that the elevator is not full when it 
     * contains lesser passengers than its capacity. */
    @Test
    void elevatorIsNotFullTest() {

        // GIVEN
        Elevator elevator = new Elevator(1, 1, 4);
        elevator.addPassenger(new Passenger(3));

        // WHEN
        int nbPassenger = elevator.getPassengers().size();
        int capacity = elevator.getCapacity();

        // THEN
        assertTrue(nbPassenger < capacity);
    }

    /** Checks that a floor is correctly added to the 
     * destination queue. */
    @Test
    void addDestinationTest() {

        // GIVEN
        Elevator elevator = new Elevator(1, 1, 3);
        int floor = 2;

        // WHEN
        elevator.addDestination(floor);

        // THEN
        assertTrue(elevator.getDestinationQueue().contains(floor));
    }

    /** Checks that a floor already in the queue. */
    @Test
    void addDestinationAlreadyExistsTest() {

        // GIVEN
        Elevator elevator = new Elevator(1, 1, 3);
        int floor = 2;
        elevator.addDestination(floor);

        // WHEN
        elevator.addDestination(floor);

        // THEN
        assertEquals(1, elevator.getDestinationQueue().size());
    }
}