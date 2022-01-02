/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package parkinglot;

public interface Spot {
    public Vehicle getVehicleInfo();
    public boolean isOccupied();
    public Vehicle freeSpot();
    public boolean occupySpot(Vehicle vehicle);
    public Integer getNumber();
}
