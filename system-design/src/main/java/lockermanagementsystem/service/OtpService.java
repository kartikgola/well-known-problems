/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package lockermanagementsystem.service;

import java.util.Random;

public class OtpService {

    public static int generateOtp() {
        int low = 1000;
        int high = 10000;
        return low + new Random().nextInt(high-low);
    }
}
