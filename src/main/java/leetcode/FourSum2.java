/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package leetcode;

import util.ArrayInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FourSum2 {

    private int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        final int n = A.length;
        final int target = 0;
        int tuplesCount = 0;

        Arrays.sort(C);
        Arrays.sort(D);

        for ( int i = 0; i < n; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                int sum = target - A[i] - B[j];
                tuplesCount += twoSumCount2(C, D, sum);
            }
        }


        return tuplesCount;
    }

    private int twoSumCount2(int[] A, int[] B, int target) {
        final int n = A.length;
        int tuplesCount = 0;

        int i = 0, j = n - 1;
        while ( i < n && j > -1 ) {
            if ( A[i] + B[j] == target ) {
                int iCount = 1, jCount = 1;
                while ( i < n - 1 && A[i] == A[i + 1] ) { iCount++; i++; }
                while ( j > 0 && B[j - 1] == B[j] ) { jCount++; j--; }
                tuplesCount += iCount * jCount;
                i++;
                j--;
            } else if ( A[i] + B[j] > target ) --j;
            else ++i;
        }

        return tuplesCount;
    }

    private int fourSumCount23(int[] A, int[] B, int[] C, int[] D) {
        final int n = A.length;
        final int target = 0;
        int tuplesCount = 0;

        ArrayList<Integer> sum1 = new ArrayList<>();
        ArrayList<Integer> sum2 = new ArrayList<>();

        for ( Integer a : A ) {
            for ( Integer b : B ) {
                sum1.add(a + b);
            }
        }

        for ( Integer c : C ) {
            for ( Integer d : D ) {
                sum2.add(c + d);
            }
        }

        Collections.sort(sum1);
        Collections.sort(sum2);

        for ( Integer num : sum1 ) {
            int search = Collections.binarySearch(sum2, -1 * num);
            if ( search >= 0 && search < sum2.size() ) {
                int count = 1, i = search;
                while ( i > 0 && sum2.get(--i).equals(sum2.get(search)) ) ++count;
                i = search;
                while ( i < sum2.size() - 1 && sum2.get(++i).equals(sum2.get(search)) ) ++count;
                tuplesCount += count;
            }
        }

        return tuplesCount;
    }

    public void solve() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(reader.readLine());
        System.out.println(fourSumCount23(
                ArrayInput.readArray(reader, N),
                ArrayInput.readArray(reader, N),
                ArrayInput.readArray(reader, N),
                ArrayInput.readArray(reader, N)
        ));
    }
}
