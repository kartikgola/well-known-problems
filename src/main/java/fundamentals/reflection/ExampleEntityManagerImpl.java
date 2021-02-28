/*
 * Author: Kartik Gola
 * Date: 2/28/21, 5:25 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package fundamentals.reflection;

public class ExampleEntityManagerImpl<T> implements ExampleEntityManager<T> {

    @Override
    public void persist(T t) {

    }

    @Override
    public T read(Class<?> classRef, long primaryKey) {
        return null;
    }
}
