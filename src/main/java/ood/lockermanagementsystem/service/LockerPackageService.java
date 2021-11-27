/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:58 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.service;

import ood.lockermanagementsystem.model.LockerPackage;

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
