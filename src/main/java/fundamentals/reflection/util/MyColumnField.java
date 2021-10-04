/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.reflection.util;

import java.lang.reflect.Field;

public class MyColumnField {

    Field field;

    public MyColumnField(Field field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "MyColumnField{" +
                "field=" + field +
                '}';
    }
}
