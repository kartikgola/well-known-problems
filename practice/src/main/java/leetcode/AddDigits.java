/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class AddDigits {

    public int addDigits(int num) {
        // Only edge case
        if ( num == 0 )
            return 0;

        // Answer can only be in [1, 9]
        // Lets say that answer is 2
        // So, 2 + 9m = num OR (num - 2) % 9 == 0
        //      where, m >= 1
        for ( int i = 1; i <= 9; ++i ) {
            if ( (num - i) % 9 == 0 )
                return i;
        }

        // Never reaches here
        return -1;
    }
}
