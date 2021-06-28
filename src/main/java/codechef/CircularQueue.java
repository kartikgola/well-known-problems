/*
 * Author: Kartik Gola
 * Date: 10/06/20, 5:53 PM
 * Copyright (c) 2020 | https://kartikgola.com
 */

package codechef;

import java.util.Arrays;

public class CircularQueue {

    private int[] q;
    private int capacity;
    private int front;
    private int back;

    public CircularQueue(final int capacity) {
        assert capacity > 0: "Capacity cannot be <= 0";
        this.capacity = capacity;
        this.q = new int[capacity];
        front = -1;
        back = -1;
    }

    public boolean isEmpty() {
        return front == -1 && back == -1;
    }

    public boolean isFull() {
        if ( isEmpty() )
            return false;
        return (back + 1) % capacity == front;
    }

    public void add(int element) throws Exception {
        if ( !isFull() ) {
            if ( isEmpty() ) front++;
            back = (back + 1) % capacity;
            q[back] = element;
        } else {
            throw new Exception("Queue is full!");
        }
    }

    public int delete() throws Exception {
        if ( !isEmpty() ) {
            final int peek = peekFront();
            if ( front == back ) back = front = -1;
            else front = (front + 1) % capacity;
            return peek;
        } else {
            throw new Exception("Queue is empty!");
        }
    }

    public int peekFront() throws Exception {
        if ( !isEmpty() ) {
            return q[front];
        } else {
            throw new Exception("Queue is empty");
        }
    }

    public int peekBack() throws Exception {
        if ( !isEmpty() ) {
            return q[back];
        } else {
            throw new Exception("Queue is empty");
        }
    }

    public String toString() {
        return Arrays.toString(q) + " FRONT: " + front + " BACK: " + back;
    }
}
