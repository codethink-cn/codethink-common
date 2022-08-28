package cn.codethink.common.util;

/**
 * 参数工具类
 *
 * @author Chuanwise
 */
public class Arguments {
    
    private Arguments() {
        Exceptions.throwUtilClassInitializeException(Arguments.class);
    }
    
    /**
     * 替换所有的 {}
     *
     * @param format 格式串
     * @param arguments 参数
     * @return 替换后的参数
     * @throws NullPointerException format 为 null
     * @throws NullPointerException arguments 为 null
     */
    public static String format(String format, Object... arguments) {
        Preconditions.objectNonNull(format, "format");
        Preconditions.objectNonNull(arguments, "arguments");
        
        final int length = format.length();
        if (length < 2) {
            return format;
        }
        
        final StringBuilder stringBuilder = new StringBuilder(length);
        
        int state = 0;
        final int normalState = 0;
        final int afterLeftState = 1;
        
        int argumentIndex = 0;
        
        for (int i = 0; i < length; i++) {
            final char ch = format.charAt(i);
            
            switch (state) {
                case normalState:
                    if (ch == '{') {
                        state = afterLeftState;
                    } else {
                        stringBuilder.append(ch);
                    }
                    break;
                case afterLeftState:
                    if (ch == '}') {
                        Preconditions.argument(Indexes.isLegal(argumentIndex, arguments.length), "lack argument(s)");
                        final Object argument = arguments[argumentIndex++];
                        stringBuilder.append(argument);
                    } else {
                        stringBuilder.append('{');
                        stringBuilder.append(ch);
                    }
                    state = normalState;
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        
        switch (state) {
            case normalState:
                break;
            case afterLeftState:
                stringBuilder.append('{');
                break;
            default:
                throw new IllegalStateException();
        }
        Preconditions.argument(argumentIndex == arguments.length, "to many argument(s)");
        
        return stringBuilder.toString();
    }
}