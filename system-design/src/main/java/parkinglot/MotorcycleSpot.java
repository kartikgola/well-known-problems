/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package parkinglot;

public class MotorcycleSpot extends AbstractSpot {

    MotorcycleSpot(int number) {
        super(number, SpotType.Motorcycle);
    }

    @Override
    public Motorcycle freeSpot() {
        if ( vehicle != null ) {
            isOccupied = false;
            Vehicle res = vehicle;
            vehicle = null;
            return (Motorcycle) res;
        }
        return null;
    }

    @Override
    public boolean occupySpot(Vehicle motorcycle) {
        if ( !isOccupied ) {
            this.vehicle = motorcycle;
            isOccupied = true;
            return true;
        }
        return false;
    }
}
