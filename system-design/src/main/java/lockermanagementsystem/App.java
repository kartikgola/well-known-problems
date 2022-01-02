/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem;

import lockermanagementsystem.model.*;
import lockermanagementsystem.service.*;

import java.util.Arrays;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        CustomerService customerService = new CustomerService(Map.of(
                1000, new Customer("Kartik", 1000, "Delhi")
        ));
        ExecutiveService executiveService = new ExecutiveService(Map.of(
                2000, new Executive("John", 2000, "Delhi")
        ));
        LockerPackageService lockerPackageService = new LockerPackageService(Map.of(
                301, new LockerPackage(301, new Dimension(1, 1, 1), 1000),
                302, new LockerPackage(302, new Dimension(20, 20, 20), 2000)
        ));
        Locker locker1 = new Locker(101, LockerSize.S);
        Locker locker2 = new Locker(102, LockerSize.M);
        LockerService lockerService = new LockerService(
                Map.of(LockerSize.S, Arrays.asList(locker1), LockerSize.M, Arrays.asList(locker2)),
                Map.of(101, locker1, 102, locker2),
                lockerPackageService
        );
        NotificationService notificationService = new NotificationService(customerService, executiveService, lockerPackageService);
        DeliveryService deliveryService = new DeliveryService(lockerService, notificationService);
        ReturnService returnService = new ReturnService(notificationService, lockerService);
        deliveryService.deliver(2000, 301);
        returnService.returnPackage(1000, 302);
    }
}
