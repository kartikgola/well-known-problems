/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KS2 {

    private int sumOfDigits(String n) {
        int sum = 0;
        for ( Character ch : n.toCharArray() ) {
            sum += Integer.parseInt(ch.toString());
        }
        return sum;
    }

    private String nthSmallestRound(String n) {
        int sum = sumOfDigits(n);
        Integer lastDigit = sum % 10;

        if ( lastDigit != 0 )
            lastDigit = 10 - lastDigit;

        return n + lastDigit.toString();
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while ( t-- > 0 ) {
            System.out.println(nthSmallestRound(reader.readLine()));
        }
    }
}
