/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package keyvalstorage;

import java.util.HashMap;
import java.util.Map;

public class KeyValStore implements Store {

    private String name;
    private Map<String, Object> map;
    private Map<String, Long> timeoutMap;

    public KeyValStore(String name) {
        this.name = name;
        this.map = new HashMap<>();
    }

    @Override
    public Object get(String key) {
        return map.get(key);
    }

    @Override
    public void put(String key, Object value) throws StoreOverflowException {
        put(key, value, DEFAULT_TIMEOUT);
    }

    @Override
    public void put(String key, Object value, long timeout) throws StoreOverflowException {
        if ( map.size() < MAX_KEYS_PER_STORE ) {
            map.put(key, value);
            map.put(key, timeout);
        } else {
            throw new StoreOverflowException();
        }
    }

    @Override
    public void remove(String key) {
        if ( map.containsKey(key) ) {
            map.remove(key);
            timeoutMap.remove(key);
        }
    }
}
