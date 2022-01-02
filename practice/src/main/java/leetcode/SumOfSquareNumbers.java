/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:27 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        // smallest number possible among a or b
        long l = 0;
        // largest number bounded to floor(sqrt(c)) since both the numbers must be LTE c
        long r = (long)Math.floor(Math.sqrt(c));

        while (l <= r) {
            long s = l*l+r*r;
            if (s == c)
                return true;
            else if (s > c)
                r--;
            else
                l++;
        }

        return false;
    }

    public boolean judgeSquareSumFermatTheorem(int c) {
        // 'c' can be expressed as sum of squares of 2 positive nos. only if
        // in prime factorization of 'c', every prime of the form 4k+3
        // occurs even no. of times
        for (int i = 2; i <= Math.sqrt(c); i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        // If it is a prime, it should not be of the form 4k+3 (since it will occur odd no. of times, i.e. 1)
        return c % 4 != 3;
    }

    public boolean judgeSquareSumBinarySearch(int c) {
        return true;
    }
}
