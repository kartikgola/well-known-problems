/*
 * Author: Kartik Gola
 * Date: 19/07/20, 6:36 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package ood.parkinglot;

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
