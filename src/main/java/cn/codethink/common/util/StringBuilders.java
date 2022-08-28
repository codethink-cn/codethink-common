package cn.codethink.common.util;

import java.util.Objects;

/**
 * StringBuilder 相关工具
 *
 * @author Chuanwise
 */
public class StringBuilders {
    
    private StringBuilders() {
        Exceptions.throwUtilClassInitializeException(StringBuilders.class);
    }
    
    /**
     * 判断 StringBuilder 是否为空
     *
     * @param stringBuilder StringBuilder
     * @return 当 stringBuilder 为 null 或空串时，返回 true，否则返回 false。
     */
    public static boolean isEmpty(StringBuilder stringBuilder) {
        
        return Objects.isNull(stringBuilder) || stringBuilder.length() == 0;
    }
    
    /**
     * 取出 StringBuilder 中的值，并清空。
     *
     * @param stringBuilder StringBuilder
     * @return stringBuilder 中的内容
     * @throws NullPointerException stringBuilder 为 null 时
     */
    public static String toStringAndClear(StringBuilder stringBuilder) {
        Preconditions.objectNonNull(stringBuilder, "string builder");
    
        final String string = stringBuilder.toString();
        stringBuilder.setLength(0);
        return string;
    }
    
    /**
     * 取出 StringBuffer 中的值，并清空。
     *
     * @param stringBuffer StringBuffer
     * @return stringBuffer 中的内容
     * @throws NullPointerException StringBuffer 为 null 时
     */
    public static String toStringAndClear(StringBuffer stringBuffer) {
        Preconditions.objectNonNull(stringBuffer, "string buffer");
        final String string = stringBuffer.toString();
        stringBuffer.setLength(0);
        return string;
    }
}
