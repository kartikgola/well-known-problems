/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:59 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.service;

import ood.lockermanagementsystem.model.Locker;
import ood.lockermanagementsystem.model.LockerBookingDetails;
import ood.lockermanagementsystem.model.LockerPackage;
import ood.lockermanagementsystem.model.LockerState;

import java.time.LocalDateTime;

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
