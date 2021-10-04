/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package fundamentals.reflection.util;

import fundamentals.reflection.annotations.MyColumnAnnotation;
import fundamentals.reflection.annotations.MyPrimaryKeyAnnotation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MetaModel<T> {

    private Class<T> classRef;

    public MetaModel(Class<T> classRef) {
        this.classRef = classRef;
    }

    public static <T> MetaModel<T> of(Class<T> classRef) {
        return new MetaModel<>(classRef);
    }

    public MyPrimaryKeyField getPrimaryKey() {
        Field[] fields = classRef.getDeclaredFields();
        Optional<Field> fieldOpt = Arrays.stream(fields)
                .filter(f -> f.getAnnotation(MyPrimaryKeyAnnotation.class) != null)
                .findFirst();
        if (fieldOpt.isPresent()) {
            return new MyPrimaryKeyField(fieldOpt.get());
        }
        throw new IllegalArgumentException("No primary key found!");
    }

    public List<MyColumnField> getColumns() {
        Field[] fields = classRef.getDeclaredFields();
        List<Field> fieldsList = Arrays.stream(fields)
                .filter(f -> f.getAnnotation(MyColumnAnnotation.class) != null)
                .collect(Collectors.toList());
        return fieldsList.stream().map(MyColumnField::new).collect(Collectors.toList());
    }
}
