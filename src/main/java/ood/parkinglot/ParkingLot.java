/*
 * Author: Kartik Gola
 * Date: 19/07/20, 6:36 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ood.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private int maxLevels;
    Level[] levels = null;

    ParkingLot(int levelsCount) {
        this.maxLevels = levelsCount;
        this.levels = new Level[maxLevels];
        Map<VehicleType, Integer> count = new HashMap<>();
        count.put(VehicleType.Car, 80);
        count.put(VehicleType.Motorcycle, 20);
        for ( int i = 0; i < maxLevels; ++i ) {
            this.levels[i] = new Level(count, i);
        }
    }

    private Spot findSpot(VehicleType type) {
        for ( Level level : levels ) {
            Spot spot = level.findEmptySpot(type);
            if ( spot != null )
                return spot;
        }
        return null;
    }

    public Spot assignSpot(Vehicle vehicle) {
        Spot spot = findSpot(vehicle.getType());
        if ( spot != null ) {
            spot.occupySpot(vehicle);
            return spot;
        }
        return null;
    }

    public static void main(String[] args) {
        new ParkingLot(3, );
    }
}
