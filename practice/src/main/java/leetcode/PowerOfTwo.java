/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if ( n < 0 )
            return false;
        String str = Integer.toString(n, 2);
        return str.indexOf('1') >= 0 && str.indexOf('1') == str.lastIndexOf('1');
    }

    public boolean isPowerOfTwo2(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo3(int n) {
        return (n & (-n)) == n;
    }

}
