package cn.codethink.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 反射工具类
 *
 * @author Chuanwise
 */
public class Reflections {
    
    private Reflections() {
        Exceptions.throwUtilClassInitializeException(Reflections.class);
    }
    
    /**
     * 检测一种类型的主体能否用于调用某个方法
     *
     * @param subjectClass 主体类型
     * @param method       方法
     * @return 能否调用 method.invoke(subject, arguments...)
     * @throws NullPointerException subjectClass 为 null
     * @throws NullPointerException method 为 null
     */
    public static boolean canInvoke(Class<?> subjectClass, Method method) {
        Preconditions.objectNonNull(subjectClass, "subject class");
        Preconditions.objectNonNull(method, "method");
    
        final Class<?> declaringClass = method.getDeclaringClass();
        if (Modifiers.isStatic(method)) {
            return declaringClass == subjectClass;
        } else {
            return declaringClass.isAssignableFrom(subjectClass);
        }
    }
    
    /**
     * 反射调用方法
     *
     * @param subject   方法调用者
     * @param method    方法
     * @param arguments 参数
     * @return 方法返回值
     * @throws InvocationTargetException 执行方法时出现异常
     */
    public static Object invokeMethod(Object subject, Method method, Object... arguments) throws InvocationTargetException {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonNull(method, "method");
        Preconditions.objectNonNull(arguments, "arguments");
        
        // 检查 static 或 subject
        final int modifiers = method.getModifiers();
        final Class<?> methodClass = method.getDeclaringClass();
        Preconditions.argument((Modifier.isStatic(modifiers) || Objects.equals(subject, methodClass))
                || methodClass.isInstance(subject),
            "method should be static and subject object equals to the declaring class of method, " +
                "or the subject object must be a instance of the declaring class of method.");
        
        final boolean accessible = method.isAccessible();
        
        try {
            method.setAccessible(true);
            return method.invoke(subject, arguments);
        } catch (IllegalAccessException exception) {
            throw new IllegalStateException("can not set method accessible", exception);
        } finally {
            method.setAccessible(accessible);
        }
    }
    
    /**
     * 反射调用静态方法
     *
     * @param method    方法
     * @param arguments 参数
     * @return 方法返回值
     * @throws InvocationTargetException 执行方法时出现异常
     */
    public static Object invokeStaticMethod(Method method, Object... arguments) throws InvocationTargetException {
        Preconditions.objectNonNull(method, "method");
        Preconditions.objectNonNull(arguments, "arguments");
        Preconditions.argument(Modifiers.isStatic(method), "method is not static");
        
        return invokeMethod(method.getDeclaringClass(), method, arguments);
    }
    
    /**
     * 反射调用可访问的，参数非空的方法
     *
     * @param subject    对象
     * @param methodName 方法名
     * @param arguments  参数列表
     * @return 当找到该方法时，返回方法返回的值，否则返回 null
     * @throws InvocationTargetException 执行方法时出现异常
     */
    public static Object invokeAccessibleArgumentNonNullMethod(Object subject, String methodName, Object... arguments) throws InvocationTargetException {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(arguments, "arguments");
        
        // 收集参数类型
        final Class<?>[] parameterClasses = new Class<?>[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            final Object argument = arguments[i];
            Preconditions.objectNonNull(argument, "argument " + i);
            parameterClasses[i] = argument.getClass();
        }
        
        // 查找方法
        final Method method = getAccessibleMethod(subject.getClass(), methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        return invokeMethod(subject, method, arguments);
    }
    
    /**
     * 反射调用存在的，参数非空的方法
     *
     * @param subject    对象
     * @param methodName 方法名
     * @param arguments  参数列表
     * @return 当找到该方法时，返回方法返回的值，否则返回 null
     * @throws InvocationTargetException 执行方法时出现异常
     */
    public static Object invokeExistArgumentNonNullMethod(Object subject, String methodName, Object... arguments) throws InvocationTargetException {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(arguments, "arguments");
        
        // 收集参数类型
        final Class<?>[] parameterClasses = new Class<?>[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            final Object argument = arguments[i];
            Preconditions.objectNonNull(argument, "argument " + i);
            parameterClasses[i] = argument.getClass();
        }
        
        // 查找方法
        final Method method = getExistMethod(subject.getClass(), methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        return invokeMethod(subject, method, arguments);
    }
    
    /**
     * 反射调用定义的，参数非空的方法
     *
     * @param subject    对象
     * @param methodName 方法名
     * @param arguments  参数列表
     * @return 当找到该方法时，返回方法返回的值，否则返回 null
     * @throws InvocationTargetException 执行方法时出现异常
     */
    public static Object invokeDeclaredArgumentNonNullMethod(Object subject, String methodName, Object... arguments) throws InvocationTargetException {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(arguments, "arguments");
        
        // 收集参数类型
        final Class<?>[] parameterClasses = new Class<?>[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            final Object argument = arguments[i];
            Preconditions.objectNonNull(argument, "argument " + i);
            parameterClasses[i] = argument.getClass();
        }
        
        // 查找方法
        final Method method = getDeclaredMethod(subject.getClass(), methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        return invokeMethod(subject, method, arguments);
    }
    
    /**
     * 反射调用可访问的，参数非空的静态方法
     *
     * @param clazz      类型
     * @param methodName 方法名
     * @param arguments  参数列表
     * @return 当找到该方法时，返回方法返回的值，否则返回 null
     * @throws InvocationTargetException 执行方法时出现异常
     */
    public static Object invokeAccessibleArgumentNonNullStaticMethod(Class<?> clazz, String methodName, Object... arguments) throws InvocationTargetException {
        Preconditions.objectNonNull(clazz, "clazz");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(arguments, "arguments");
        
        // 收集参数类型
        final Class<?>[] parameterClasses = new Class<?>[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            final Object argument = arguments[i];
            Preconditions.objectNonNull(argument, "argument " + i);
            parameterClasses[i] = argument.getClass();
        }
        
        // 查找方法
        final Method method = getAccessibleStaticMethod(clazz, methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        return invokeStaticMethod(method, arguments);
    }
    
    /**
     * 反射调用存在的，参数非空的方法
     *
     * @param clazz      类型
     * @param methodName 方法名
     * @param arguments  参数列表
     * @return 当找到该方法时，返回方法返回的值，否则返回 null
     * @throws InvocationTargetException 执行方法时出现异常
     */
    public static Object invokeExistArgumentNonNullStaticMethod(Class<?> clazz, String methodName, Object... arguments) throws InvocationTargetException {
        Preconditions.objectNonNull(clazz, "clazz");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(arguments, "arguments");
        
        // 收集参数类型
        final Class<?>[] parameterClasses = new Class<?>[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            final Object argument = arguments[i];
            Preconditions.objectNonNull(argument, "argument " + i);
            parameterClasses[i] = argument.getClass();
        }
        
        // 查找方法
        final Method method = getExistStaticMethod(clazz, methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        return invokeStaticMethod(method, arguments);
    }
    
    /**
     * 反射调用定义的，参数非空的方法
     *
     * @param clazz      类型
     * @param methodName 方法名
     * @param arguments  参数列表
     * @return 当找到该方法时，返回方法返回的值，否则返回 null
     * @throws InvocationTargetException 执行方法时出现异常
     */
    public static Object invokeDeclaredArgumentNonNullStaticMethod(Class<?> clazz, String methodName, Object... arguments) throws InvocationTargetException {
        Preconditions.objectNonNull(clazz, "clazz");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(arguments, "arguments");
        
        // 收集参数类型
        final Class<?>[] parameterClasses = new Class<?>[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            final Object argument = arguments[i];
            Preconditions.objectNonNull(argument, "argument " + i);
            parameterClasses[i] = argument.getClass();
        }
        
        // 查找方法
        final Method method = getDeclaredStaticMethod(clazz, methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        return invokeStaticMethod(method, arguments);
    }
    
    /**
     * 获取可访问到的属性
     *
     * @param clazz     类型
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Field getAccessibleField(Class<?> clazz, String fieldName) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(fieldName, "field name");
        
        try {
            return clazz.getField(fieldName);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
    
    /**
     * 获取存在的属性
     *
     * @param clazz     类型
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Field getExistField(Class<?> clazz, String fieldName) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(fieldName, "field name");
        
        do {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException ignored) {
            }
            
            clazz = clazz.getSuperclass();
        } while (Objects.nonNull(clazz));
        
        return null;
    }
    
    /**
     * 获取存在的所有属性
     *
     * @param clazz 类型
     * @return 类型的所有属性
     */
    public static Field[] getExistFields(Class<?> clazz) {
        Preconditions.objectNonNull(clazz, "class");
        
        final List<Field> fields = new ArrayList<>();
        while (Objects.nonNull(clazz)) {
            fields.addAll(Arrays.unmodifiableList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields.toArray(new Field[0]);
    }
    
    /**
     * 获取该类中定义的属性
     *
     * @param clazz     类型
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Field getDeclaredField(Class<?> clazz, String fieldName) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(fieldName, "field name");
        
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
    
    /**
     * 获取可访问到的静态属性
     *
     * @param clazz     类型
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Field getAccessibleStaticField(Class<?> clazz, String fieldName) {
        final Field field = getAccessibleField(clazz, fieldName);
        if (Objects.isNull(field)) {
            return null;
        }
        
        Preconditions.argument(Modifiers.isStatic(field), "field is not static");
        return field;
    }
    
    /**
     * 获取存在的的静态属性
     *
     * @param clazz     类型
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Field getExistStaticField(Class<?> clazz, String fieldName) {
        final Field field = getExistField(clazz, fieldName);
        if (Objects.isNull(field)) {
            return null;
        }
        
        Preconditions.argument(Modifiers.isStatic(field), "field is not static");
        return field;
    }
    
    /**
     * 获取定义的的静态属性
     *
     * @param clazz     类型
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Field getDeclaredStaticField(Class<?> clazz, String fieldName) {
        final Field field = getDeclaredField(clazz, fieldName);
        if (Objects.isNull(field)) {
            return null;
        }
        
        Preconditions.argument(Modifiers.isStatic(field), "field is not static");
        return field;
    }
    
    /**
     * 获取可访问到的非静态属性
     *
     * @param clazz     类型
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Field getAccessibleNonStaticField(Class<?> clazz, String fieldName) {
        final Field field = getAccessibleField(clazz, fieldName);
        if (Objects.isNull(field)) {
            return null;
        }
        
        Preconditions.argument(!Modifiers.isStatic(field), "field is static");
        return field;
    }
    
    /**
     * 获取存在的的非静态属性
     *
     * @param clazz     类型
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Field getExistNonStaticField(Class<?> clazz, String fieldName) {
        final Field field = getExistField(clazz, fieldName);
        if (Objects.isNull(field)) {
            return null;
        }
        
        Preconditions.argument(!Modifiers.isStatic(field), "field is static");
        return field;
    }
    
    /**
     * 获取定义的的非静态属性
     *
     * @param clazz     类型
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Field getDeclaredNonStaticField(Class<?> clazz, String fieldName) {
        final Field field = getDeclaredField(clazz, fieldName);
        if (Objects.isNull(field)) {
            return null;
        }
        
        Preconditions.argument(!Modifiers.isStatic(field), "field is static");
        return field;
    }
    
    /**
     * 获取属性值
     *
     * @param subject 对象
     * @param field   属性
     * @return 当找不到该属性时返回 null
     */
    public static Object getFieldValue(Object subject, Field field) {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonNull(field, "field");
        
        // 检查 static 或 subject
        final Class<?> fieldClass = field.getDeclaringClass();
        Preconditions.argument((Modifiers.isStatic(field) || Objects.equals(subject, fieldClass))
                || fieldClass.isInstance(subject),
            "field should be static and subject object equals to the declaring class of field, " +
                "or the subject object must be a instance of the declaring class of field.");
        
        final boolean accessible = field.isAccessible();
        
        try {
            field.setAccessible(true);
            return field.get(subject);
        } catch (IllegalAccessException exception) {
            throw new IllegalStateException("can not set field accessible", exception);
        } finally {
            field.setAccessible(accessible);
        }
    }
    
    /**
     * 获取静态属性值
     *
     * @param field 属性
     * @return 当找不到该属性时返回 null
     */
    public static Object getStaticFieldValue(Field field) {
        Preconditions.objectNonNull(field, "field");
        Preconditions.argument(Modifiers.isStatic(field), "field is not static");
        
        return getFieldValue(field.getDeclaringClass(), field);
    }
    
    /**
     * 获取非静态属性值
     *
     * @param field 属性
     * @return 当找不到该属性时返回 null
     */
    public static Object getNonStaticFieldValue(Field field) {
        Preconditions.objectNonNull(field, "field");
        Preconditions.argument(!Modifiers.isStatic(field), "field is static");
        
        return getFieldValue(field.getDeclaringClass(), field);
    }
    
    /**
     * 设置属性值
     *
     * @param subject 对象
     * @param field   属性
     * @param value   属性值
     */
    public static void setFieldValue(Object subject, Field field, Object value) {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonNull(field, "field");
        
        // 检查 static 或 subject
        final Class<?> fieldClass = field.getDeclaringClass();
        Preconditions.argument((Modifiers.isStatic(field) || Objects.equals(subject, fieldClass))
                || fieldClass.isInstance(subject),
            "field should be static and subject object equals to the declaring class of field, " +
                "or the subject object must be a instance of the declaring class of field.");
        
        // 检查 value 类型
        if (Objects.nonNull(value)) {
            final Class<?> type = field.getType();
            Preconditions.argument(type.isInstance(value), "value is not null, and not the instance of field type");
        }
        
        final boolean accessible = field.isAccessible();
        
        try {
            field.setAccessible(true);
            field.set(subject, value);
        } catch (IllegalAccessException exception) {
            throw new IllegalStateException("can not set field accessible", exception);
        } finally {
            field.setAccessible(accessible);
        }
    }
    
    /**
     * 设置静态属性值
     *
     * @param field 属性
     * @param value 属性值
     */
    public static void setStaticFieldValue(Field field, Object value) {
        Preconditions.objectNonNull(field, "field");
        
        setFieldValue(field.getDeclaringClass(), field, value);
    }
    
    /**
     * 获取可访问的属性值
     *
     * @param subject   对象
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Object getAccessibleFieldValue(Object subject, String fieldName) {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonEmpty(fieldName, "field name");
        
        final Field field = getAccessibleField(subject.getClass(), fieldName);
        if (Objects.isNull(field)) {
            return null;
        }
        
        return getFieldValue(subject, field);
    }
    
    /**
     * 设置可访问的属性值
     *
     * @param subject   对象
     * @param fieldName 属性名
     * @param value     属性值
     * @return 当找不到该属性时返回 false
     */
    public static boolean setAccessibleFieldValue(Object subject, String fieldName, Object value) {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonEmpty(fieldName, "fieldName");
        
        final Field field = getAccessibleField(subject.getClass(), fieldName);
        if (Objects.isNull(field)) {
            return false;
        }
        
        setFieldValue(field.getDeclaringClass(), field, value);
        return true;
    }
    
    /**
     * 获取存在的属性值
     *
     * @param subject   对象
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Object getExistFieldValue(Object subject, String fieldName) {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonEmpty(fieldName, "field name");
        
        final Field field = getExistField(subject.getClass(), fieldName);
        if (Objects.isNull(field)) {
            return null;
        }
        
        return getFieldValue(subject, field);
    }
    
    /**
     * 设置存在的属性值
     *
     * @param subject   对象
     * @param fieldName 属性名
     * @param value     属性值
     * @return 当找不到该属性时返回 false
     */
    public static boolean setExistFieldValue(Object subject, String fieldName, Object value) {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonEmpty(fieldName, "fieldName");
        
        final Field field = getExistField(subject.getClass(), fieldName);
        if (Objects.isNull(field)) {
            return false;
        }
        
        setFieldValue(field.getDeclaringClass(), field, value);
        return true;
    }
    
    /**
     * 获取定义的属性值
     *
     * @param subject   对象
     * @param fieldName 属性名
     * @return 当找不到该属性时返回 null
     */
    public static Object getDeclaredFieldValue(Object subject, String fieldName) {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonEmpty(fieldName, "field name");
        
        final Field field = getDeclaredField(subject.getClass(), fieldName);
        if (Objects.isNull(field)) {
            return null;
        }
        
        return getFieldValue(subject, field);
    }
    
    /**
     * 设置定义的属性值
     *
     * @param subject   对象
     * @param fieldName 属性名
     * @param value     属性值
     * @return 当找不到该属性时返回 false
     */
    public static boolean setDeclaredFieldValue(Object subject, String fieldName, Object value) {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonEmpty(fieldName, "fieldName");
        
        final Field field = getDeclaredField(subject.getClass(), fieldName);
        if (Objects.isNull(field)) {
            return false;
        }
        
        setFieldValue(field.getDeclaringClass(), field, value);
        return true;
    }
    
    /**
     * 获取可访问的方法
     *
     * @param clazz            方法
     * @param methodName       方法名
     * @param parameterClasses 方法参数类型
     * @return 当找不到该方法是返回 null
     */
    public static Method getAccessibleMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(parameterClasses, "parameter classes");
        
        try {
            return clazz.getMethod(methodName, parameterClasses);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
    
    /**
     * 获取存在的方法
     *
     * @param clazz            方法
     * @param methodName       方法名
     * @param parameterClasses 方法参数类型
     * @return 当找不到该方法是返回 null
     */
    public static Method getExistMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(parameterClasses, "parameter classes");
        
        final Set<Class<?>> checkedClasses = new HashSet<>();
        final Queue<Class<?>> classes = new LinkedList<>();
        classes.add(clazz);
        
        while (!classes.isEmpty()) {
            final Class<?> currentClass = classes.poll();
            
            try {
                return currentClass.getMethod(methodName, parameterClasses);
            } catch (NoSuchMethodException ignored) {
            }
            
            // 在父类中寻找
            final Class<?> superclass = currentClass.getSuperclass();
            if (Objects.nonNull(superclass)) {
                checkedClasses.add(superclass);
                classes.add(superclass);
            }
            
            // 在父类的接口中寻找
            for (Class<?> superInterface : currentClass.getInterfaces()) {
                if (!checkedClasses.contains(superInterface)) {
                    checkedClasses.add(superInterface);
                    classes.add(superInterface);
                }
            }
        }
        
        return null;
    }
    
    /**
     * 获取定义的方法
     *
     * @param clazz            方法
     * @param methodName       方法名
     * @param parameterClasses 方法参数类型
     * @return 当找不到该方法是返回 null
     */
    public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(parameterClasses, "parameter classes");
        
        try {
            return clazz.getDeclaredMethod(methodName, parameterClasses);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
    
    /**
     * 获取可访问的方法
     *
     * @param clazz            方法
     * @param methodName       方法名
     * @param parameterClasses 方法参数类型
     * @return 当找不到该方法是返回 null
     */
    public static Method getAccessibleStaticMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(parameterClasses, "parameter classes");
        
        final Method method = getAccessibleMethod(clazz, methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        Preconditions.argument(Modifiers.isStatic(method), "method is not static");
        return method;
    }
    
    /**
     * 获取存在的静态方法
     *
     * @param clazz            方法
     * @param methodName       方法名
     * @param parameterClasses 方法参数类型
     * @return 当找不到该方法是返回 null
     */
    public static Method getExistStaticMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(parameterClasses, "parameter classes");
        
        final Method method = getExistMethod(clazz, methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        Preconditions.argument(Modifiers.isStatic(method), "method is not static");
        return method;
    }
    
    /**
     * 获取定义的静态方法
     *
     * @param clazz            方法
     * @param methodName       方法名
     * @param parameterClasses 方法参数类型
     * @return 当找不到该方法是返回 null
     */
    public static Method getDeclaredStaticMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(parameterClasses, "parameter classes");
        
        final Method method = getDeclaredMethod(clazz, methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        Preconditions.argument(Modifiers.isStatic(method), "method is not static");
        return method;
    }
    
    /**
     * 获取可访问的方法
     *
     * @param clazz            方法
     * @param methodName       方法名
     * @param parameterClasses 方法参数类型
     * @return 当找不到该方法是返回 null
     */
    public static Method getAccessibleNonStaticMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(parameterClasses, "parameter classes");
        
        final Method method = getAccessibleMethod(clazz, methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        Preconditions.argument(!Modifiers.isStatic(method), "method is static");
        return method;
    }
    
    /**
     * 获取存在的静态方法
     *
     * @param clazz            方法
     * @param methodName       方法名
     * @param parameterClasses 方法参数类型
     * @return 当找不到该方法是返回 null
     */
    public static Method getExistNonStaticMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(parameterClasses, "parameter classes");
        
        final Method method = getExistMethod(clazz, methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        Preconditions.argument(!Modifiers.isStatic(method), "method is static");
        return method;
    }
    
    /**
     * 获取定义的静态方法
     *
     * @param clazz            方法
     * @param methodName       方法名
     * @param parameterClasses 方法参数类型
     * @return 当找不到该方法是返回 null
     */
    public static Method getDeclaredNonStaticMethod(Class<?> clazz, String methodName, Class<?>... parameterClasses) {
        Preconditions.objectNonNull(clazz, "class");
        Preconditions.objectNonEmpty(methodName, "method name");
        Preconditions.objectNonNull(parameterClasses, "parameter classes");
        
        final Method method = getDeclaredMethod(clazz, methodName, parameterClasses);
        if (Objects.isNull(method)) {
            return null;
        }
        
        Preconditions.argument(!Modifiers.isStatic(method), "method is static");
        return method;
    }
}