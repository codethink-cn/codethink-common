package cn.codethink.common.util;

import com.google.common.base.Preconditions;

/**
 * 范围工具
 *
 * @author Chuanwise
 */
@SuppressWarnings("unused")
public class Ranges {
    private Ranges() {
        Throwables.throwNoInstancesException(Ranges.class);
    }
    
    /**
     * 判断一个值是否在给定的区间内
     *
     * @param value 给定值
     * @param min   最小值
     * @param max   最大值
     * @return 给定值是否在 [min, max) 的区间内
     * @throws IllegalArgumentException min > max 时
     */
    public static boolean in(int value, int min, int max) {
        Preconditions.checkArgument(min <= max, "Illegal range: [ " + min + ", " + max + " )");
        
        return value >= min && value < max;
    }
    
    /**
     * 判断一个值是否在给定的范围内
     *
     * @param value  给定值
     * @param bound1 边界 1
     * @param bound2 边界 2
     * @return 给定值是否在 [ min{bound1, bound2}, max{bound1, bound2} ) 的范围内
     */
    public static boolean between(int value, int bound1, int bound2) {
        return (value >= bound1 && value < bound2)
            || (value >= bound2 && value < bound1);
    }
    
    /**
     * 判断一个值是否在给定的区间内
     *
     * @param value 给定值
     * @param min   最小值
     * @param max   最大值
     * @return 给定值是否在 [min, max) 的区间内
     */
    public static <U, T extends Comparable<U>> boolean in(U value, T min, T max) {
        Preconditions.checkNotNull(value, "Value is null!");
        Preconditions.checkNotNull(min, "Min is null!");
        Preconditions.checkNotNull(max, "Max is null!");
    
        return min.compareTo(value) < 0 && max.compareTo(value) >= 0;
    }
    
    /**
     * 判断一个值是否在给定的范围内
     *
     * @param value  给定值
     * @param bound1 边界 1
     * @param bound2 边界 2
     * @return 给定值是否在 [ min{bound1, bound2}, max{bound1, bound2} ) 的范围内
     */
    public static <U, T extends Comparable<U>> boolean between(U value, T bound1, T bound2) {
        return (bound1.compareTo(value) < 0 && bound2.compareTo(value) >= 0)
            || (bound2.compareTo(value) < 0 && bound1.compareTo(value) >= 0);
    }
}