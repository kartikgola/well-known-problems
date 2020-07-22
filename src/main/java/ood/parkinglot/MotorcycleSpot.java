/*
 * Author: Kartik Gola
 * Date: 19/07/20, 6:36 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ood.parkinglot;

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
