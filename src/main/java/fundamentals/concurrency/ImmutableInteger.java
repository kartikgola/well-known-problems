/*
 * Author: Kartik Gola
 * Date: 27/02/2021, 20:59
 * Copyright (c) 2021 | https://kartikgola.com
 * Problem URL:
 */

package fundamentals.concurrency;

public class ImmutableInteger {

    private final int value;

    public ImmutableInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ImmutableInteger add(int value) {
        return new ImmutableInteger(this.value + value);
    }

    public ImmutableInteger subtract(int value) {
        return new ImmutableInteger(this.value - value);
    }
}