/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package atcoder.abc199;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TaskC {

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());
        int p = 0;

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1 + p;
            int b = Integer.parseInt(st.nextToken()) - 1 + p;

            if (a >= 2*n)
                a %= n;
            if (b >= 2*n)
                b %= n;

            if (t == 1) {
                swap(s, a, b);
            } else {
                p = p == 0 ? n : 0;
            }
        }

        if (p != 0) {
            for (int i = 0; p < 2*n; ++p, ++i) {
                swap(s, i, p);
            }
        }

        System.out.println(new String(s));
    }
}
