package fr.ensai.elevator;

import java.util.Random;

/**
 * A crazy elevator with random behavior.
**/

public class CrazyElevator extends Elevator {

    private static Random random = new Random();

    /**
     * Constructs a new CrazyElevator.
     *
     * @param id         the unique identifier for the crazy elevator
     * @param startFloor the floor where the crazy elevator starts
     * @param capacity   the maximum number of passengers the crazy elevator can carry
     */
    public CrazyElevator(int id, int startFloor, int capacity) {
        super(id, startFloor, capacity);
    }


    /**
     * Moves the elevator with crazy behavior,
     * remain stationary
     * skip its next destination and go directly to the next one
     * go to the next floor as a normal elevator        
     **/
    @Override
    public void move() {
        int b = random.nextInt(3);
        if (b == 1) {
            if (this.getDestinationQueue().size() >= 2)
                this.getDestinationQueue().remove(0);
            super.move();
        } else if (b == 2) {
            super.move();
        }
    }

    /**
     * Unloads passengers half the time.
     * If the crazy elevator is full, passengers are sent
     * intoo another dimension.
     * @param floor the Floor where passengers will exit
     * @return the number of passengers unloaded
     */
    @Override
    public int unloadPassengers(Floor floor) {
        if (this.isFull()) {
            int count = this.getPassengers().size();
            this.getPassengers().clear();
            return count;
        }
        if (random.nextInt(2) == 0) {
            return 0;
        } else { return super.unloadPassengers(floor);}
        
    }
}


 