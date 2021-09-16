/*
 * Author: Kartik Gola
 * Date: 9/16/21, 4:40 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package practice.leetcode;

import java.util.*;

public class SingleThreadedCpu {

    class Task {
        int i;
        int enq;
        int pro;
        public Task(int i, int enq, int pro) {
            this.i = i;
            this.enq = enq;
            this.pro = pro;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] task = new Task[n];
        for (int i = 0; i < n; ++i)
            task[i] = new Task(i, tasks[i][0], tasks[i][1]);

        // Sort by enqueue time
        Arrays.sort(task, Comparator.comparingInt(t -> t.enq));

        // PQ to sort time by smallest processing time first (index to break ties)
        Queue<Task> pq = new PriorityQueue<>((t1, t2) -> {
            if (t1.pro - t2.pro == 0)
                return t1.i - t2.i;
            return t1.pro - t2.pro;
        });

        List<Integer> ans = new ArrayList<>();

        // Add first task and all the tasks that arrive at the same time
        pq.add(task[0]);
        int curr = 0;
        while (curr + 1 < n && task[curr + 1].enq == task[curr].enq)
            pq.add(task[++curr]);

        int time = pq.peek().enq;
        while (!pq.isEmpty()) {
            Task t = pq.poll();
            time += t.pro;
            ans.add(t.i);
            // Add all the tasks that have arrived while current task was being processed
            for (int i = curr + 1; i < n && task[i].enq <= time; ++i) {
                pq.add(task[i]);
                curr = i;
            }
            // In case PQ is empty & there might be some future task with enqueue time >>> current time, so we'll have to add it
            if (curr + 1 < n && pq.isEmpty()) {
                pq.add(task[++curr]);
                while (curr + 1 < n && task[curr + 1].enq == task[curr].enq)
                    pq.add(task[++curr]);
                time = pq.peek().enq;
            }
        }

        return ans.stream().mapToInt(x -> x).toArray();
    }
}
