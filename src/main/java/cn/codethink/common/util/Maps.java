package cn.codethink.common.util;

import java.util.Map;
import java.util.function.Supplier;

/**
 * 映射表相关工具类
 *
 * @author Chuanwise
 */
public class Maps {
    
    private Maps() {
        Exceptions.throwUtilClassInitializeException(Maps.class);
    }
    
    /**
     * 从映射表中获取某元素，或将其添加后获取
     *
     * @param map   映射表
     * @param key   键
     * @param value 值
     * @param <K>   键类型
     * @param <V>   值类型
     * @return 值
     * @throws NullPointerException map 为 null
     */
    public static <K, V> V getOrPut(Map<K, V> map, K key, V value) {
        Preconditions.objectNonNull(map, "map");
        
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            map.put(key, value);
            return value;
        }
    }
    
    /**
     * 从映射表中获取某元素，或将其添加后获取
     *
     * @param map      映射表
     * @param key      键
     * @param supplier 值的访问器
     * @param <K>      键类型
     * @param <V>      值类型
     * @return 值
     * @throws NullPointerException map 为 null
     * @throws NullPointerException supplier 为 null
     */
    public static <K, V> V getOrPutGet(Map<K, V> map, K key, Supplier<V> supplier) {
        Preconditions.objectNonNull(map, "map");
        Preconditions.objectNonNull(supplier, "supplier");
        
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            final V v = supplier.get();
            map.put(key, v);
            return v;
        }
    }
    
    /**
     * 从哈希表中获取元素
     *
     * @param map 哈希表
     * @param key 键
     * @param <K> 键类型
     * @param <V> 值类型
     * @return 值
     * @throws NullPointerException             map 为 null
     * @throws java.util.NoSuchElementException 哈希表中没有该键对应的值
     */
    public static <K, V> V getOrFail(Map<K, V> map, K key) {
        Preconditions.objectNonNull(map, "map");
        
        final V value = map.get(key);
        if (Objects.isNull(value)) {
            Preconditions.element(map.containsKey(key), "no value present for key: " + key);
        }
        return value;
    }
}