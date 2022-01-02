/*
 * Author: Kartik Gola
 * Date: 10/4/21, 5:28 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BasicGetReflectionAPI {

    public void getClassReference() throws ClassNotFoundException {
        // from object
        Class<?> class1 = "string".getClass();

        // from a known class
        Class<?> class2 = String.class;

        // from fully qualified class name
        Class<?> class3 = Class.forName("java.lang.String");
    }

    public void getSuperClasses() {
        Class<?> superClass = String.class.getSuperclass();
        Class<?>[] interfaces = String.class.getInterfaces();
    }

    public void getClassFields() throws NoSuchFieldException, SecurityException {
        // declared fields = private, protected, public fields declared in the class
        Field[] declaredFields = String.class.getDeclaredFields();

        // gets only public + inherited fields in the class
        Field[] fields = String.class.getFields();

        Field field = String.class.getDeclaredField("hash");
    }

    public void getClassMethods() throws NoSuchMethodException, SecurityException {
        // declared methods = private, protected, public methods declared in the class
        Method[] declaredMethods = String.class.getDeclaredMethods();

        // gets only public + inherited methods in the class
        Method[] methods = String.class.getMethods();

        Method method = String.class.getMethod("indexOf", int.class);
    }

    public void getFieldModifiers() throws NoSuchFieldException, SecurityException {
        Field field = String.class.getDeclaredField("hash");
        int modifiers = field.getModifiers();
        boolean isPrivate = Modifier.isPrivate(modifiers);
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isProtected = Modifier.isProtected(modifiers);
        boolean isStatic = Modifier.isStatic(modifiers);
    }

    public void getClassModifiers() throws SecurityException {
        Class<?> strClass = String.class;
        int modifiers = strClass.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isStatic = Modifier.isStatic(modifiers);
        boolean isInterface = Modifier.isInterface(modifiers);
    }

    public void getClassConstructors() throws NoSuchMethodException {
        Class<?> strClass = String.class;
        Constructor<?> constructor = strClass.getConstructor(String.class);

        // declared constructor = all constructors declared in the class
        Constructor<?>[] declaredConstructors = strClass.getDeclaredConstructors();
        // gets only publicly declared constructor in class (does not include inherited constructors)
        Constructor<?>[] constructors = strClass.getConstructors();

    }
}
