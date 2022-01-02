/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.service;

import lockermanagementsystem.model.LockerPackage;

import java.util.Map;

public class LockerPackageService {

    private Map<Integer, LockerPackage> lockerPackageMap;

    public LockerPackageService(Map<Integer, LockerPackage> lockerPackageMap) {
        this.lockerPackageMap = lockerPackageMap;
    }

    public LockerPackage getPackageById(int lockerPackageId) {
        return lockerPackageMap.get(lockerPackageId);
    }
}
