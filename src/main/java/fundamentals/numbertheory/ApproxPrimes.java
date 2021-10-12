/*
 * Author: Kartik Gola
 * Date: 10/11/21, 8:48 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.numbertheory;

public class ApproxPrimes {

    public static int primesLessThan(int n) {
        return (int) (n / Math.log(n));
    }

    public static void main(String[] args) {
        System.out.println(primesLessThan(100));
    }
}
