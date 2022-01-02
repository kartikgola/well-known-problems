/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package leetcode;

public class DesignAStackWithIncrementOperation {

    int[] arr;
    int[] lazy;
    int size = 0;
    int top = -1;

    public DesignAStackWithIncrementOperation(int maxSize) {
        arr = new int[maxSize];
        lazy = new int[maxSize];
        size = maxSize;
    }

    public void push(int x) {
        if ( top == -1 ) {
            arr[++top] = x;
        } else if ( top + 1 < size )
            arr[++top] = x;
    }

    public int pop() {
        int elem = -1;
        if ( top > -1 ) {
            elem = arr[top] + lazy[top--];
            if ( top > -1 )
                lazy[top] += lazy[top + 1];
            lazy[top + 1] = 0;
        }
        return elem;
    }

    public void increment(int k, int val) {
        if ( top > -1 )
            lazy[Math.min(top, k - 1)] += val;
    }

}
