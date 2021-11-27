/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:58 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.service;

import ood.lockermanagementsystem.model.LockerBookingDetails;

public class DeliveryService {

    private LockerService lockerService;
    private NotificationService notificationService;

    public DeliveryService(LockerService lockerService, NotificationService notificationService) {
        this.lockerService = lockerService;
        this.notificationService = notificationService;
    }

    public void deliver(int executiveId, int packageId) {
        LockerBookingDetails lockerBookingDetails = lockerService.put(executiveId, packageId);
        notificationService.notifyCustomer(lockerBookingDetails, packageId);
    }
}
