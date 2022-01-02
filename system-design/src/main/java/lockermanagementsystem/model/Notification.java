/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.model;

public class Notification {

    private int accountId;
    private int lockerId;
    private int otp;

    public Notification(int accountId, int lockerId, int otp) {
        this.accountId = accountId;
        this.lockerId = lockerId;
        this.otp = otp;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getLockerId() {
        return lockerId;
    }

    public void setLockerId(int lockerId) {
        this.lockerId = lockerId;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "accountId=" + accountId +
                ", lockerId=" + lockerId +
                ", otp=" + otp +
                '}';
    }
}
