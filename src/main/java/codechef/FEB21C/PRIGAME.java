/*
 * Author: Kartik Gola
 * Date: 10/02/2021, 14:20
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL: https://www.codechef.com/FEB21C/problems/PRIGAME
 */

package codechef.FEB21C;

import util.MathUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PRIGAME {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        boolean[] nonPrimes = MathUtils.primeNumbersSeive(1000_001);
        int[] distinctPrimes = new int[1000_001];
        for (int num = 2; num <= distinctPrimes.length - 1; ++num)
            distinctPrimes[num] += distinctPrimes[num-1] + (!nonPrimes[num] ? 1 : 0);

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            final String input = br.readLine();
            int x = Integer.parseInt(input.split(" ")[0]),
                y = Integer.parseInt(input.split(" ")[1]);

            if (distinctPrimes[x] <= y)
                sb.append("Chef\n");
            else
                sb.append("Divyam\n");
        }

        System.out.println(sb);
    }
}
