/*
 * Author: Kartik Gola
 * Date: 11/27/21, 1:33 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.model;

public class LockerBookingDetails {

    private int otp;
    private int lockerId;

    public LockerBookingDetails(int otp, int lockerId) {
        this.otp = otp;
        this.lockerId = lockerId;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public int getLockerId() {
        return lockerId;
    }

    public void setLockerId(int lockerId) {
        this.lockerId = lockerId;
    }
}
