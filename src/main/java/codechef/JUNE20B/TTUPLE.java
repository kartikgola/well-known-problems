/*
 * Author: Kartik Gola
 * Date: 11/06/20, 2:58 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package codechef.JUNE20B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TTUPLE {

    private int[] diff(int[] src, int[] tar) {
        int[] res = new int[src.length];
        for ( int i = 0; i < res.length; ++i )
            res[i] = tar[i] - src[i];
        return res;
    }

    private int[] mod(int[] src, int[] tar) {
        int[] res = new int[src.length];
        for ( int i = 0; i < res.length; ++i )
            res[i] = tar[i] % src[i];
        return res;
    }

    private int[] mult(int[] src, int[] tar) {
        int[] res = new int[src.length];
        for ( int i = 0; i < res.length; ++i )
            res[i] = src[i] == 0 ? 0 : tar[i] / src[i];
        return res;
    }

    private void add(int[] src, int val) {
        for ( int i = 0; i < src.length; ++i )
            src[i] += val;
    }

    private void multiply(int[] src, int val) {
        for ( int i = 0; i < src.length; ++i )
            src[i] *= val;
    }

    private int ops(int[] src, int[] tar, int k) {
        if ( Arrays.equals(src, tar) )
            return k;

        if ( k >= 2 )
            return 3;

        return -1;
    }

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while ( t-- > 0 ) {
            int[] src = new int[3];
            int[] tar = new int[3];

            st = new StringTokenizer(br.readLine());
            for ( int i = 0; i < src.length; ++i )
                src[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for ( int i = 0; i < src.length; ++i )
                tar[i] = Integer.parseInt(st.nextToken());

            System.out.println(ops(src, tar, 0));
        }
    }
}
