/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue {

    private Queue<Integer> q = new LinkedList<>();
    private final int LIMIT;

    MyBlockingQueue(int limit) {
        this.LIMIT = limit;
    }

    public synchronized void add(Integer val) throws InterruptedException {
        while (q.size() == LIMIT)
            wait();
        q.add(val);
        if (q.size() == 1)
            notifyAll();
    }

    public synchronized Integer remove() throws InterruptedException {
        while (q.size() == 0)
            wait();
        Integer val = q.remove();
        if (q.size() == LIMIT - 1)
            notifyAll();
        return val;
    }
}
