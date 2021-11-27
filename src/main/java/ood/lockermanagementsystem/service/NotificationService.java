/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:58 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.service;

import ood.lockermanagementsystem.model.*;

public class NotificationService {

    CustomerService customerService;
    ExecutiveService executiveService;
    LockerPackageService lockerPackageService;

    public NotificationService(CustomerService customerService, ExecutiveService executiveService, LockerPackageService lockerPackageService) {
        this.customerService = customerService;
        this.executiveService = executiveService;
        this.lockerPackageService = lockerPackageService;
    }

    public void notifyCustomer(LockerBookingDetails lockerBookingDetails, int packageId) {
        LockerPackage lockerPackage = lockerPackageService.getPackageById(packageId);
        Customer customer = customerService.getCustomerById(lockerPackage.getCollectorAccountId());
        Notification notification = new Notification(customer.getId(), lockerBookingDetails.getLockerId(), lockerBookingDetails.getOtp());
        System.out.println("Customer " + customer + " notified by " + notification);
    }

    public void notifyExecutive(LockerBookingDetails lockerBookingDetails, int packageId) {
        LockerPackage lockerPackage = lockerPackageService.getPackageById(packageId);
        Executive executive = executiveService.getExecutiveById(lockerPackage.getCollectorAccountId());
        Notification notification = new Notification(executive.getId(), lockerBookingDetails.getLockerId(), lockerBookingDetails.getOtp());
        System.out.println("Executive " + executive + " notified by " + notification);
    }
}
