/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.reflection.util;

import java.lang.reflect.Field;

public class MyPrimaryKeyField {

    Field field;

    public MyPrimaryKeyField(Field field) {
        this.field = field;
    }

    public String getName() {
        return field.getName();
    }

    public Class<?> getType() {
        return field.getType();
    }

    @Override
    public String toString() {
        return "MyPrimaryKeyField{" +
                "field=" + field +
                '}';
    }
}
