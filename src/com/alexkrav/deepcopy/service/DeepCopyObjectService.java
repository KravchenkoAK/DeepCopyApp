package com.alexkrav.deepcopy.service;

import java.lang.reflect.*;
import java.util.*;

public class DeepCopyObjectService {

    public static Object Copy(Object object) {

        Object copyObject = null;
        Class classObject = object.getClass();
        if (classObject.getConstructors() != null || classObject.getConstructors().length != 0) {
            copyObject = createNewInstance(classObject);
        }
        if (copyObject == null) {
            return null;
        }
        List<Method> methods = new ArrayList<>();
        try {
            methods = Arrays.asList(classObject.getMethods());
            Collection<Field> fields = Arrays.asList(classObject.getDeclaredFields());
            for (Field field : fields) {
                String fieldName = field.getName();
                fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                String getName = "get" + fieldName;
                String setName = "set" + fieldName;

                Optional<Method> setMethodOpt = methods.stream()
                        .filter(m -> m.getName().equals(setName)
                                && m.getParameterTypes()[0].equals(field.getType()))
                        .findFirst();

                Optional<Method> getMethodOpt = methods.stream()
                        .filter(m -> m.getName().equals(getName))
                        .findFirst();

                ///not used cause exception for case without method name
                ///Method setMethod = classObject.getDeclaredMethod("set" + fieldName, field.getType());
                ///Method getMethod = classObject.getDeclaredMethod("get" + fieldName);
                if (!setMethodOpt.isEmpty() && !getMethodOpt.isEmpty()) {
                    Method setMethod = setMethodOpt.get();
                    Method getMethod = getMethodOpt.get();
                    setMethod.invoke(copyObject, getMethod.invoke(object));
                }
            }
            return copyObject;

        } catch (IllegalAccessException|InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Object createNewInstance(Class classObject){
        Constructor[] constructors = classObject.getConstructors();
        Constructor constructor = constructors[0];
        Class[] listConstructorClasses = constructor.getParameterTypes();
        Object[] inputParameters = new Object[listConstructorClasses.length];
        Map<Class<?>, Object> primitiveValues = getPrimitiveValues();

        for (int i = 0; i < listConstructorClasses.length; i++) {
            if(listConstructorClasses[i].isPrimitive()) {
                inputParameters[i] = primitiveValues.get(listConstructorClasses[i]);
            }else{
                inputParameters[i] = null;
            }
        }

        try {
            return constructor.newInstance(inputParameters);
        } catch (InstantiationException|IllegalAccessException|InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Map<Class<?>, Object> getPrimitiveValues() {
        Map<Class<?>, Object> primitiveValues = new HashMap<Class<?>, Object>();
        primitiveValues.put(char.class, '\0');
        primitiveValues.put(byte.class, 0);
        primitiveValues.put(short.class, 0);
        primitiveValues.put(int.class, 0);
        primitiveValues.put(long.class, 0);
        primitiveValues.put(float.class, 0);
        primitiveValues.put(double.class, 0);
        primitiveValues.put(boolean.class, false);
        return primitiveValues;

    }

}
