/*
 * Author: Kartik Gola
 * Date: 2/28/21, 3:11 PM
 * Copyright (c) 2021 | https://rattl.io
 * Problem URL:
 */

package fundamentals.reflection;

import fundamentals.reflection.model.Person;

import java.lang.reflect.Field;

public class BasicSetReflectionAPI {

    public void setClassFieldValue() throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person();
        Class<?> clss = p.getClass();

        // Get public field ID
        Field publicField = clss.getDeclaredField("height");
        publicField.setInt(p, 175); // works fine!

        // Get private field ID
        Field privateField = clss.getDeclaredField("id");
        try {
            privateField.setInt(p, 112233); // throws IllegalAccessException
        }  catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        // Make privateField accessible
        privateField.setAccessible(true);
        privateField.setInt(p, 112233); // works fine!

        System.out.println(privateField.get(p));
    }

}
