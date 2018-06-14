package com.ccttic.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 说明：反射工具
 * */
public class CCtticReflectUtils {
    /**
     * <p>Title: getPublicField</p>
     * <p>Description: 根据fieldNm得到当前cls或者父类Class里面的公共字段，优先获取子类中的变量</p>
     * @param cls
     * @param fieldNm
     * @return Field
     * @throws NoSuchFieldException
     * @throws SecurityException
     */
    public static Field getPublicField(Class<?> cls, String fieldNm)
            throws NoSuchFieldException, SecurityException {
        Field field = null;
        try {
            field = cls.getField(fieldNm);
        } catch (NoSuchFieldException e) {
            throw new NoSuchFieldException("没有在 " + cls.getName() +
                    " 中找到【" + fieldNm + "】，可能 '" + fieldNm + "'不是public！");
        }
        return field;
    }

    /**
     * <p>Title: getPublicFields</p>
     * <p>Description: 得到当前cls或者父类Class里面的所有公共变量</p>
     * @param cls
     * @return Field
     * @throws NoSuchFieldException
     * @throws SecurityException
     */
    public static Field [] getPublicFields(Class<?> cls)
            throws NoSuchFieldException, SecurityException {
        return cls.getFields();
    }

    /**
     * <p>Title: getSealField</p>
     * <p>Description: 根据fieldNm得到当前cls所声明的字段，不能获取父类中的变量，即使是public的</p>
     * @param cls
     * @param fieldNm
     * @return Field
     * @throws NoSuchFieldException
     */
    public static Field getSealField(Class<?> cls, String fieldNm) throws NoSuchFieldException {
        Field field = null;
        try {
            field = cls.getDeclaredField(fieldNm);
        } catch (NoSuchFieldException e) {
            throw new NoSuchFieldException("没有在 " + cls.getName() +
                    " 中找到【" + fieldNm + "】，可能 '" + fieldNm + "'不是该类中的字段！");
        }
        return field;
    }

    /**
     * <p>Title: getSealFields</p>
     * <p>Description: 得到当前cls所有声明的字段，不能获取父类中的变量，即使是public的</p>
     * @param cls
     * @return Field
     * @throws NoSuchFieldException
     */
    public static Field[] getSealFields(Class<?> cls) throws NoSuchFieldException {
        return cls.getDeclaredFields();
    }

    /**
     * <p>Title: getParentType</p>
     * <p>Description: 获得所有的父类和接口的Class</p>
     * @param cls
     * @param isAll 是否获取cls的所有父类和接口（包括非直接父类和接口）
     * @param isExclude 是否根据excludes排除不需要的Class
     * @param excludes 需要排除的Class
     * @return
     */
    public static List<Class<?>> getParentType(Class<?> cls, boolean isAll, boolean isExclude,
                                               Class<?> ... excludes) {
        List<Class<?>> superclasses = new LinkedList<>();
        List<Class<?>> interfaceses = new LinkedList<>();
        if (!isAll) {
            superclasses.add(cls.getSuperclass());
            interfaceses.addAll(Arrays.asList(cls.getInterfaces()));
        } else {
            superclasses.addAll(getAllParents(cls));
            getAllInterfaces(cls, interfaceses);
        }
        List<Class<?>> classes = new LinkedList<>();
        // 如果不排除类型或者需要排除的为空，直接返回数据
        if (isExclude == false || excludes == null || excludes.length == 0) {
            if (interfaceses != null && interfaceses.size() > 0)
                classes.addAll(interfaceses);
            classes.addAll(superclasses);
            return classes;
        }

        // 保存得到的interfaces和父类
        Class<?> [] tempClass = new Class<?>[interfaceses.size() + superclasses.size()];
        for (int i = 0; i < interfaceses.size(); i++) {
            tempClass[i] = interfaceses.get(i);
        }
        for (int i = 0; i < superclasses.size(); i++) {
            tempClass[interfaceses.size() + i] = superclasses.get(i);
        }

        int index = 0;
        for (int i = 0; i < excludes.length; i++) {
            for (int j = index; j < tempClass.length; j++) {
                if (excludes[i] == tempClass[j]) {
                    tempClass[j] = tempClass[index];
                    tempClass[index] = null;
                    index ++;
                }
            }
        }

        for (int i = index; i < tempClass.length; i++) {
            classes.add(tempClass[i]);
        }
        return classes;
    }

    /**
     * <p>Title: getParents</p>
     * <p>Description: 获得所有的父类，包括非直接的父类</p>
     * @param cls
     * @return
     */
    public static List<Class<?>> getAllParents(Class<?> cls) {
        List<Class<?>> classes = new LinkedList<>();
        Class<?> superclass = cls.getSuperclass();

        if (superclass == Object.class) {
            classes.add(superclass);
            return classes;
        }

        for (Class<?> superCls = superclass; superCls != null && superCls != Object.class;
             superCls = superCls.getSuperclass()) {
            classes.add(superCls);
        }
        classes.add(Object.class);
        return classes;
    }


    // 这里改为set
    /**
     * <p>Title: getInterfaces</p>
     * <p>Description: 获得所有的接口，包括非直接的接口</p>
     * @param cls
     * @param reClasses 返回的class
     * @return
     */
    public static List<Class<?>> getAllInterfaces(Class<?> cls, List<Class<?>> reClasses) {
        List<Class<?>> classes = new LinkedList<>(Arrays.asList(cls.getInterfaces()));
        reClasses.addAll(classes);

        Class<?>[] interfaces = null;
        for (Class<?> class1 : classes) {
            interfaces = class1.getInterfaces();
            if (interfaces == null || interfaces.length == 0)
                continue;
            for (Class<?> class2 : interfaces) {
                reClasses.add(class2);
                getAllInterfaces(class2, reClasses);
            }
        }
        return reClasses;
    }

    /**
     * <p>Title: invokeMethod</p>
     * <p>Description: 调用某个方法</p>
     * @param method
     * @param args
     * @return
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object invokeMethod(Method method, Object target, Object ...args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (method == null)
            throw new NullPointerException("method 不能为空");
        Object result = method.invoke(target, args);
        return result;
    }
}
