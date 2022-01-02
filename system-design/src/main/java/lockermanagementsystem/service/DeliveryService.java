/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.service;

import lockermanagementsystem.model.LockerBookingDetails;

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
