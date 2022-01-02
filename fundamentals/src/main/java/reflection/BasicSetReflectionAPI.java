/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package reflection;

import reflection.model.Person;

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
