/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package reflection;

public class ExampleEntityManagerImpl<T> implements ExampleEntityManager<T> {

    @Override
    public void persist(T t) {

    }

    @Override
    public T read(Class<?> classRef, long primaryKey) {
        return null;
    }
}
