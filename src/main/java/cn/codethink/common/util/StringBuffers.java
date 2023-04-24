package cn.codethink.common.util;

import com.google.common.base.Preconditions;

import java.util.Objects;

/**
 * StringBuffer 相关工具
 *
 * @author Chuanwise
 */
public class StringBuffers {
    private StringBuffers() {
        Throwables.throwNoInstancesException(StringBuffers.class);
    }
    
    /**
     * 判断 StringBuffer 是否为空
     *
     * @param stringBuffer StringBuffer
     * @return 当 stringBuffer 为 null 或空串时，返回 true，否则返回 false。
     */
    public static boolean isNullOrEmpty(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }
    
    /**
     * 取出 StringBuffer 中的值，并清空。
     *
     * @param stringBuffer StringBuffer
     * @return stringBuffer 中的内容
     */
    public static String toStringAndClear(StringBuffer stringBuffer) {
        Preconditions.checkNotNull(stringBuffer, "String buffer is null!");
    
        final String string = stringBuffer.toString();
        stringBuffer.setLength(0);
        return string;
    }
}
