/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.reflection;

public interface ExampleEntityManager<T> {

    void persist(T t);

    T read(Class<?> classRef, long primaryKey);
}
