/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.service;

import lockermanagementsystem.model.*;

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
