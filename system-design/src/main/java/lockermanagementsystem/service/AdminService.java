/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.service;

public class AdminService {

    private LockerService lockerService;

    public void decommisionLockers(int adminId) {
        lockerService.decommisionLockers(adminId);
    }
}
