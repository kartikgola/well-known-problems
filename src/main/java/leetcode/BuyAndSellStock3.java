/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyAndSellStock3 {

    private int[] readArray(BufferedReader reader, int n) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), ",");
        int[] arr = new int[n];
        int i = 0;
        while ( tokenizer.hasMoreTokens() ) {
            arr[i++] = Integer.parseInt(tokenizer.nextToken());
        }
        return arr;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] prices = readArray(reader, n);
        int l = 0;
        int currentProfit = 0;
        int h = 0, s = 0;

        // 11 7 10 9 13 14 10 15 12 10
        for ( int i = 1; i < prices.length; ++i ) {
            // if today's price is low as compared to lastBuy price
            if ( prices[i] < prices[l] ) {
                l = i;
                if ( currentProfit > s ) {
                    if ( currentProfit > h ) {
                        s = h;
                        h = currentProfit;
                    } else {
                        s = currentProfit;
                    }
                }
                currentProfit = 0;
            } else if ( prices[i] - prices[l] > currentProfit ) {
                // if selling today is beneficial
                currentProfit = prices[i] - prices[l];
            } else {
                // Otherwise, sell the one in hand & buy at today's rate
                if ( currentProfit > s ) {
                    if ( currentProfit > h ) {
                        s = h;
                        h = currentProfit;
                    } else {
                        s = currentProfit;
                    }
                }
                currentProfit = 0;
                l = i;
            }
        }

        if ( currentProfit > s ) {
            if ( currentProfit > h ) {
                s = h;
                h = currentProfit;
            } else {
                s = currentProfit;
            }
        }

        System.out.println(h + s);
    }
}
