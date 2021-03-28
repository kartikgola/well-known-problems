/*
 * Author: Kartik Gola
 * Date: 3/27/21, 6:24 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package google.codejam2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reversort {

    private static int min(int[] arr, int i) {
        int p = i;
        for (int j = i+1; j < arr.length; ++j) {
            if (arr[j] < arr[p]) {
                p = j;
            }
        }
        return p;
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
            --j;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int _t = 1; _t <= t; ++_t) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int time = 0;
            for (int i = 0; i < n; ++i)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n-1; ++i) {
                int j = min(arr, i);
                reverse(arr, i, j);
                time += j - i + 1;
            }
            System.out.printf("Case #%d: %d\n", _t, time);
        }
    }
}
