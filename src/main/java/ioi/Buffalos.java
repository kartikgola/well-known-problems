package ioi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Buffalos {

    private int[] readArray(BufferedReader reader, int n) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
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
        int[] a = readArray(reader, n);
        int l = 0; // last buy index
        int totalProfit = 0;
        int currentProfit = 0;

        // 11 7 10 9 13 14 10 15 12 10
        for ( int i = 1; i < n; ++i ) {
            // if today's price is low as compared to lastBuy price, make current stock price as last buy
            if ( a[i] < a[l] ) {
                l = i;
                totalProfit += currentProfit;
                currentProfit = 0;
            } else if ( a[i] - a[l] > currentProfit ) {
                // if selling today is beneficial, calculate currentProfit
                currentProfit = a[i] - a[l];
            } else {
                // Otherwise, sell the one in hand & buy at today's rate
                totalProfit += currentProfit;
                currentProfit = 0;
                l = i;
            }
        }

        totalProfit += currentProfit;
        System.out.println(totalProfit);
    }
}
