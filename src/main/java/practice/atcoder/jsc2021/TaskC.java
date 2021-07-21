/*
 * Author: Kartik Gola
 * Date: 4/17/21, 12:34 PM
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL: https://atcoder.jp/contests/jsc2021
 */

package practice.atcoder.jsc2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskC {

    private static int findGcd(int a, int b) {
        if (a == 0)
            return b;
        return findGcd(b % a, a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int gcd = b; gcd > 0; --gcd) {
            int multiplesFrom1toB = b / gcd;
            int multiplesFrom1toA = (a - 1) / gcd; // excluding 'a'
            if (multiplesFrom1toB - multiplesFrom1toA >= 2) {
                System.out.println(gcd);
                break;
            }
        }
    }
}
