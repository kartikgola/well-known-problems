/*
 * Author: Kartik Gola
 * Date: 11/25/21, 10:47 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.model;

import java.time.LocalDateTime;

public class Locker {

    private int id;
    private int packageId;
    private int otp;
    private LockerSize lockerSize;
    private LockerState lockerState = LockerState.AVAILABLE;
    private LocalDateTime bookingTime;
    private LocalDateTime expirationTime;

    public Locker(int id, LockerSize lockerSize) {
        this.id = id;
        this.lockerSize = lockerSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public LockerSize getLockerSize() {
        return lockerSize;
    }

    public void setLockerSize(LockerSize lockerSize) {
        this.lockerSize = lockerSize;
    }

    public LockerState getLockerState() {
        return lockerState;
    }

    public void setLockerState(LockerState lockerState) {
        this.lockerState = lockerState;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }
}
