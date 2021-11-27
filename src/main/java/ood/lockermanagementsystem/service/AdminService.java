/*
 * Author: Kartik Gola
 * Date: 11/27/21, 1:46 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.service;

public class AdminService {

    private LockerService lockerService;

    public void decommisionLockers(int adminId) {
        lockerService.decommisionLockers(adminId);
    }
}
