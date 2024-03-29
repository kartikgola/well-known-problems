/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthFactorOfN {

    public int kthFactor(int N, int K) {
        int count = 0;
        for (int i = 1; i <= N; ++i) {
            if (N % i == 0) {
                ++count;
                if (count == K) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int kthFactor2(int N, int K) {
        int sqrt = (int) Math.sqrt(N);
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num = 1; num <= sqrt; ++num) {
            if (N % num == 0) {
                pq.add(num);
                pq.add(N / num);
            }
        }

        while (!pq.isEmpty()) {
            int top = pq.poll();
            while (!pq.isEmpty() && pq.peek() == top) {
                pq.poll();
            }
            if (--K == 0)
                return top;
        }

        return -1;
    }
}
