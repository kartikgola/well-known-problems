/*
 * Author: Kartik Gola
 * Date: 10/10/2020, 15:58
 * Copyright (c) 2020 | https://rattl.io
 * Problem URL:
 */

package ood.keyvalstorage;

import java.util.HashMap;
import java.util.Map;

public class KeyValStorage implements Storage {

    private Map<String, Store> storeMap;

    public KeyValStorage() {
        this.storeMap = new HashMap<>();
        Store defaultStore = new KeyValStore(DEFAULT_STORE_NAME);
        this.storeMap.put(DEFAULT_STORE_NAME, defaultStore);
    }

    @Override
    public Object get(String key) {
        return this.get(key, DEFAULT_STORE_NAME);
    }

    @Override
    public Object get(String key, String storeName) throws StoreNotFoundException {
        if ( storeMap.containsKey(storeName) ) {
            return storeMap.get(storeName)
                    .get(key);
        } else {
            throw new StoreNotFoundException();
        }
    }

    @Override
    public void put(String key, Object value) throws StoreOverflowException {
        this.storeMap.get(DEFAULT_STORE_NAME)
                .put(key, value);
    }

    @Override
    public void put(String key, Object value, Long timeout) throws StoreOverflowException {
        this.storeMap.get(DEFAULT_STORE_NAME)
                .put(key, value, timeout);
    }

    @Override
    public void put(String key, Object value, String storeName) throws StoreOverflowException {
        this.storeMap.get(storeName)
                .put(key, value);
    }

    @Override
    public void put(String key, Object value, String storeName, Long timeout) throws StoreOverflowException {
        this.storeMap.get(storeName)
                .put(key, value, timeout);
    }
}
