package cn.codethink.common.util;

/**
 * 静态的工具类方法
 *
 * @author Chuanwise
 */
public class StaticUtilities
        extends Utilities {
    
    /**
     * 不可以调用静态工具类的构造方法
     */
    protected StaticUtilities() {
        throw new UnsupportedOperationException();
    }
}
