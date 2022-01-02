/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package atcoder.jsc2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> union = new HashSet<>();
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            a.add(val);
            union.add(val);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(st.nextToken());
            b.add(val);
            union.add(val);
        }

        a.retainAll(b);
        union.removeAll(a);

        List<Integer> al = new ArrayList<>(union);
        Collections.sort(al);

        for (Integer val: al)
            System.out.print(val + " ");
    }
}
