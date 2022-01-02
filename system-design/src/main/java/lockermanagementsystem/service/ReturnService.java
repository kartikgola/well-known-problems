/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.service;

import lockermanagementsystem.model.LockerBookingDetails;

public class ReturnService {

    NotificationService notificationService;
    LockerService lockerService;

    public ReturnService(NotificationService notificationService, LockerService lockerService) {
        this.notificationService = notificationService;
        this.lockerService = lockerService;
    }

    public void returnPackage(int customerId, int packageId) {
        LockerBookingDetails lockerBookingDetails = lockerService.put(customerId, packageId);
        notificationService.notifyExecutive(lockerBookingDetails, packageId);
    }
}
