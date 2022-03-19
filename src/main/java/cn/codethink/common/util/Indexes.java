package cn.codethink.common.util;

/**
 * 索引相关工具
 *
 * @author Chuanwise
 */
public class Indexes
        extends StaticUtilities {
    
    /**
     * 判断索引值是否合法
     *
     * @param index 索引值
     * @param bound 最大值
     * @return 当 index >= 0 且小于 bound 时返回 true
     * @throws IllegalArgumentException bound 小于 0
     */
    public static boolean isLegal(int index, int bound) {
        Preconditions.argument(bound >= 0, "bound must be bigger than or equals to 0!");
        
        return index >= 0 && index < bound;
    }
}
