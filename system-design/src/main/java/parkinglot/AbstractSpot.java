/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package parkinglot;

public abstract class AbstractSpot implements Spot {
    final int number;
    final SpotType spotType;
    protected Vehicle vehicle;
    protected boolean isOccupied;

    AbstractSpot(int number, SpotType type) {
        this.number = number;
        this.spotType = type;
        this.isOccupied = false;
        this.vehicle = null;
    }

    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    @Override
    public Vehicle getVehicleInfo() {
        return vehicle;
    }

    @Override
    public Integer getNumber() {
        return number;
    }
}
