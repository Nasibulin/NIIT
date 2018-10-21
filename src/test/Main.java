package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        // Get class name as string.
        String myClassName = Base.class.getName();
        // Create class of type Base.
        Class<?> myClass = Class.forName("test.Base");
        // Create constructor call with argument types.
        Constructor<?> ctr = myClass.getConstructor(String.class, String.class);
        // Finally create object of type Base and pass data to constructor.
        String arg1 = "My User Data";
        String arg2 = "My User Data2";
        Object object = ctr.newInstance(new Object[]{arg1, arg2});
        // Type-cast and access the data from class Base.
        Base base = (Base)object;
        System.out.println(base.data);
    }

}
