/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.service;

import lockermanagementsystem.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class LockerService {

    private Map<LockerSize, List<Locker>> lockerSizeListMap;
    private Map<Integer, Locker> lockerMap;
    private LockerPackageService lockerPackageService;

    public LockerService(Map<LockerSize, List<Locker>> lockerSizeListMap, Map<Integer, Locker> lockerMap,
                         LockerPackageService lockerPackageService) {
        this.lockerSizeListMap = lockerSizeListMap;
        this.lockerMap = lockerMap;
        this.lockerPackageService = lockerPackageService;
    }

    private LockerSize getLockerSizeFor(Dimension dimension) {
        int size = dimension.getLength() * dimension.getHeight() * dimension.getWidth();
        if (size <= 1000) {
            return LockerSize.S;
        } else if (size <= 1000_000) {
            return LockerSize.M;
        } else {
            return LockerSize.L;
        }
    }

    private Locker findLockerFor(Dimension dimension) {
        LockerSize lockerSize = getLockerSizeFor(dimension);
        return lockerSizeListMap.get(lockerSize).stream()
                .filter(locker -> locker.getLockerState().equals(LockerState.AVAILABLE))
                .findFirst().orElse(null);
    }

    private LockerPackage openLocker(Locker locker, int otp) {
        if (locker.getLockerState() == LockerState.DE_COMMISSIONED)
            throw new RuntimeException("Locker has been de-commisioned. Please contact support.");
        if (locker.getLockerState() == LockerState.AVAILABLE)
            throw new RuntimeException("Locker is empty.");
        if (LocalDateTime.now().compareTo(locker.getExpirationTime()) >= 0)
            throw new RuntimeException("Locker OTP has expired. Please contact support.");
        if (locker.getOtp() == otp) {
            locker.setLockerState(LockerState.AVAILABLE);
            locker.setBookingTime(null);
            locker.setExpirationTime(null);
            int lockerPackageId = locker.getPackageId();
            locker.setPackageId(-1);
            return lockerPackageService.getPackageById(lockerPackageId);
        } else {
            throw new RuntimeException("Incorrect OTP");
        }
    }

    public LockerPackage get(int accountId, int lockerId, int otp) {
        // check for accountId auth
        return openLocker(lockerMap.get(lockerId), otp);
    }

    public LockerBookingDetails put(int accountId, int packageId) {
        // check for accountId auth
        LockerPackage lockerPackage = lockerPackageService.getPackageById(packageId);
        Locker locker = findLockerFor(lockerPackage.getDimension());
        if (locker == null)
            throw new RuntimeException("No locker available.");
        locker.setPackageId(packageId);
        locker.setBookingTime(LocalDateTime.now());
        locker.setExpirationTime(LocalDateTime.now().plusDays(3));
        locker.setPackageId(packageId);
        locker.setLockerState(LockerState.BOOKED);
        locker.setOtp(OtpService.generateOtp());
        return new LockerBookingDetails(locker.getOtp(), locker.getId());
    }

    public void decommisionLockers(int adminId) {
        // check for adminId auth
        for (Locker locker: lockerMap.values()) {
            if (locker.getLockerState() == LockerState.BOOKED
                    && LocalDateTime.now().compareTo(locker.getExpirationTime()) >= 0) {
                locker.setLockerState(LockerState.DE_COMMISSIONED);
            }
        }
    }

}
