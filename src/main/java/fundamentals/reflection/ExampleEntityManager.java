/*
 * Author: Kartik Gola
 * Date: 2/28/21, 5:24 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package fundamentals.reflection;

public interface ExampleEntityManager<T> {

    void persist(T t);

    T read(Class<?> classRef, long primaryKey);
}
