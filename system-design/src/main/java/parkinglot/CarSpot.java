/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package parkinglot;

public class CarSpot extends AbstractSpot {

    CarSpot(int number) {
        super(number, SpotType.Car);
    }

    public Car freeSpot() {
        if ( vehicle != null ) {
            isOccupied = false;
            Vehicle res = vehicle;
            vehicle = null;
            return (Car) res;
        }
        return null;
    }

    public boolean occupySpot(Vehicle car) {
        if ( !isOccupied ) {
            this.vehicle = car;
            isOccupied = true;
            return true;
        }
        return false;
    }
}
