/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | rattl.io
 */

package leetcode;

public class PowerOfTwo {

    public boolean isPowerOfTwoNaive(int n) {
        if ( n < 0 )
            return false;
        String str = Integer.toString(n, 2);
        return str.indexOf('1') >= 0 && str.indexOf('1') == str.lastIndexOf('1');
    }

    public boolean isPowerOfTwoBitHack(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }

}
