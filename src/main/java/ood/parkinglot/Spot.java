/*
 * Author: Kartik Gola
 * Date: 19/07/20, 6:36 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ood.parkinglot;

public interface Spot {
    public Vehicle getVehicleInfo();
    public boolean isOccupied();
    public Vehicle freeSpot();
    public boolean occupySpot(Vehicle vehicle);
    public Integer getNumber();
}
