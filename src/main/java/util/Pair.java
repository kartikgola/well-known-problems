/*
 * Author: Kartik Gola
 * Date: 09/07/20, 7:33 PM
 * Copyright (c) 2020 | https://rattl.io
 */

package util;

public class Pair<K, V> {

    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
