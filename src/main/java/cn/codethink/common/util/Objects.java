package cn.codethink.common.util;

import cn.codethink.common.api.Emptiable;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * 类基础 API
 *
 * @author Chuanwise
 */
public class Objects
    extends StaticUtilities {
    
    /**
     * 判断对象是否为 null
     *
     * @param object 对象
     * @return 对象是否为 null
     */
    public static boolean isNull(Object object) {
        return object == null;
    }
    
    /**
     * 判断对象是否非 null
     *
     * @param object 对象
     * @return 对象是否非 null
     */
    public static boolean nonNull(Object object) {
        return object != null;
    }
    
    /**
     * 判断对象是否为空
     *
     * @param object 对象
     * @return 当对象是 null，返回 true。
     * 当对象是 {@link Emptiable} 的实例，返回 {@link Emptiable#isEmpty()}。
     * 当对象是各类数组，返回 {@link Arrays#isEmpty(Object[])}。
     * 否则返回 false
     */
    public static boolean isEmpty(Object object) {
        if (isNull(object)) {
            return true;
        }
    
        if (object instanceof Collection) {
            final Collection<?> objects = (Collection<?>) object;
            return Collections.isEmpty(objects);
        }
    
        if (object instanceof Emptiable) {
            final Emptiable emptiable = (Emptiable) object;
            return emptiable.isEmpty();
        }
    
        final Class<?> componentType = object.getClass().getComponentType();
        if (Objects.nonNull(componentType)) {
            return Array.getLength(object) == 0;
        }
        
        return false;
    }
    
    /**
     * 判断对象是否相等
     *
     * @param object1 对象 1
     * @param object2 对象 2
     * @return 对象 1 和 2 是否相等
     */
    public static boolean equals(Object object1, Object object2) {
        return java.util.Objects.equals(object1, object2);
    }
}
