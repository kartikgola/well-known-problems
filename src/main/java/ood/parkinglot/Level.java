/*
 * Author: Kartik Gola
 * Date: 19/07/20, 6:36 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package ood.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level {

    private int storey = -1;
    private Map<VehicleType, Integer> count = null;
    private Map<VehicleType, List<Spot>> spots = null;

    Level(Map<VehicleType, Integer> count, int storey) {
        this.storey = storey;
        this.count = count;
        int number = 100 * storey;
        for ( Map.Entry<VehicleType, Integer> e : count.entrySet() ) {
            spots.put(e.getKey(), new ArrayList<>(e.getValue()));
            for ( int i = 0; i < e.getValue(); ++i ) {
                if ( e.getKey() == VehicleType.Car )
                    spots.get(e.getKey())
                            .add(new CarSpot(number++));
                else if ( e.getKey() == VehicleType.Motorcycle )
                    spots.get(e.getKey())
                        .add(new MotorcycleSpot(number++));
            }
        }
    }

    public Spot locateVehicle(Vehicle vehicle) {
        List<Spot> spotList = spots.get(vehicle.getType());
        for ( Spot spot : spotList ) {
            if ( spot.isOccupied() && spot.getVehicleInfo().equals(vehicle) ) {
                return spot;
            }
        }
        return null;
    }

    public Spot findEmptySpot(VehicleType type) {
        List<Spot> spotList = spots.get(type);
        for ( Spot spot : spotList ) {
            if ( !spot.isOccupied() ) {
                return spot;
            }
        }
        return null;
    }

}
