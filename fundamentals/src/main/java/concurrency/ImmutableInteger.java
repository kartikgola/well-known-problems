/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package concurrency;

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