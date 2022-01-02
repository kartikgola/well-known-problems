/*
 * Author: Kartik Gola
 * Date: 10/11/21, 7:32 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package numbertheory;

public class EuclidAlgorithm {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(42, 96));
    }
}
