/*
 * Author: Kartik Gola
 * Date: 1/2/22, 3:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package keyvalstorage;

public interface Storage {

    public final int MAX_STORES = 1000;

    public final String DEFAULT_STORE_NAME = "default";

    public Object get(String key);

    public Object get(String key, String storeName) throws StoreNotFoundException;

    public void put(String key, Object value) throws StoreOverflowException;

    public void put(String key, Object value, Long timeout) throws StoreOverflowException;

    public void put(String key, Object value, String storeName) throws StoreOverflowException;

    public void put(String key, Object value, String storeName, Long timeout) throws StoreOverflowException;
}
