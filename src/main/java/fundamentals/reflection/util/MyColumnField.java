/*
 * Author: Kartik Gola
 * Date: 2/28/21, 5:40 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
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
