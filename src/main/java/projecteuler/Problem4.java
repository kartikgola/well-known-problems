/*
 * Author: Kartik Gola
 * Date: 28/02/2021, 19:09
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: 
 */

package projecteuler;

public class Problem4 {

    public int solve() {
        int max = 0;
        for (int num1 = 999; num1 >= 100; --num1) {
            for (int num2 = 999; num2 >= 100; --num2) {
                int prod = num1 * num2;
//                if (MathUtils.isPalindrome(prod) && prod > max) {
//                    max = prod;
//                }
            }
        }
        return max;
    }
}
