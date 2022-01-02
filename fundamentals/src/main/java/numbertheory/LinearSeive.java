/*
 * Author: Kartik Gola
 * Date: 10/4/21, 6:04 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package numbertheory;

import java.util.ArrayList;
import java.util.List;

public class LinearSeive {

    public List<Integer> solve(int n) {
        int[] mindiv = new int[n+1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; ++i) {
            if (mindiv[i] == 0) {
                primes.add(i);
                mindiv[i] = i;
            }
            for (int prime: primes) {
                if (prime > mindiv[i] || prime*i > n)
                    break;
                mindiv[prime*i] = prime;
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(new LinearSeive().solve(20));
    }
}
