/*
 * Author: Kartik Gola
 * Date: 11/25/21, 11:29 AM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package ood.lockermanagementsystem.service;

import java.util.Random;

public class OtpService {

    public static int generateOtp() {
        int low = 1000;
        int high = 10000;
        return low + new Random().nextInt(high-low);
    }
}
