/*
 * Author: Kartik Gola
 * Date: 10/10/2020, 15:59
 * Copyright (c) 2020 | https://kartikgola.com
 * Problem URL:
 */

package ood.keyvalstorage;

public interface Store {

    public final long MAX_KEYS_PER_STORE = 1000_000;

    public final long DEFAULT_TIMEOUT = 60 * 60 * 1000;

    public final long MAX_TIMEOUT = 7 * 24 * 60 * 60 * 1000;

    public Object get(String key);

    public void put(String key, Object value) throws StoreOverflowException;

    public void put(String key, Object value, long timeout) throws StoreOverflowException;

    public void remove(String key);
}
