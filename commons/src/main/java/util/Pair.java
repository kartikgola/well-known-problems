/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:45 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package util;

public class Pair<T, K> {

    private final T key;
    private final K value;

    public Pair(T key, K value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public K getValue() {
        return value;
    }
}
