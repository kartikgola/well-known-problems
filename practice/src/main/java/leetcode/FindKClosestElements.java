/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.*;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new LinkedList<>();
        Arrays.sort(arr);
        int idx = Arrays.binarySearch(arr, x), l, r;
        if (idx < 0) {idx += 1; idx *= -1;}

        if (idx == 0) {
            l = 0; r = 1;
        } else if (idx == arr.length) {
            l = arr.length-2; r = arr.length-1;
        } else {
            l = idx-1; r = idx;
        }
        while (k-- > 0) {
            if (l >= 0 && r < arr.length) {
                if (x-arr[l] <= arr[r]-x)
                    ans.add(0, arr[l--]);
                else
                    ans.add(arr[r++]);
            } else if (l >= 0)
                ans.add(0, arr[l--]);
            else
                ans.add(arr[r++]);
        }
        return ans;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        Queue<Integer> pq = new PriorityQueue<Integer>(k, (a, b) -> {
            if (Math.abs(a-x) - Math.abs(b-x) != 0)
                return Math.abs(b-x) - Math.abs(a-x);
            return b - a;
        });

        for (int num: arr) {
            if (pq.size() < k)
                pq.add(num);
            else {
                int p = pq.peek();
                int diff = Math.abs(num-x) - Math.abs(p-x);
                if (diff < 0 || (diff == 0 && num < p)) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }

        List<Integer> ans = new ArrayList<>(pq);
        Collections.sort(ans);
        return ans;
    }
}
