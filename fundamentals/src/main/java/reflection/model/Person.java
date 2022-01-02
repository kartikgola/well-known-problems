/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package reflection.model;

import reflection.annotations.MyColumnAnnotation;
import reflection.annotations.MyPrimaryKeyAnnotation;

public class Person {

    @MyPrimaryKeyAnnotation
    private long id;

    @MyColumnAnnotation
    private String name;

    @MyColumnAnnotation
    private int age;

    @MyColumnAnnotation
    public int height;

    public Person() {
    }

    public Person(long id, String name, int age, int height) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public static Person of(String name, int age, int height) {
        return new Person(name, age, height);
    }
}
