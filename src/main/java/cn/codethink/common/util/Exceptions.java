package cn.codethink.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 *
 * @author Chuanwise
 */
public class Exceptions {
    
    private Exceptions() {
        throwUtilClassInitializeException(Exceptions.class);
    }
    
    /**
     * 抛出工具类初始化异常
     *
     * @param utilClass 工具类
     * @throws NullPointerException utilClass 为 null
     * @throws UnsupportedOperationException 工具类初始化异常
     */
    public static void throwUtilClassInitializeException(Class<?> utilClass) {
        Preconditions.objectNonNull(utilClass, "utility class");
        throw new UnsupportedOperationException("can not invoke the constructor of an utility class: " + utilClass.getName() + "!");
    }
    
    /**
     * 将异常堆栈信息输出到字符串
     *
     * @param cause 异常
     * @return 堆栈信息字符串
     * @throws NullPointerException cause 为 null
     */
    public static String readStackTrace(Throwable cause) {
        Preconditions.objectNonNull(cause, "cause");
        
        final StringWriter stringWriter = new StringWriter();
        cause.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.getBuffer().toString();
    }
    
    /**
     * 将异常重新抛出
     *
     * @param cause 异常
     * @throws Exception 重新抛出的异常
     * @throws NullPointerException cause 为 null
     */
    public static void rethrow(Throwable cause) throws Exception {
        Preconditions.objectNonNull(cause, "cause");
        
        if (cause instanceof RuntimeException) {
            throw (RuntimeException) cause;
        }
        if (cause instanceof Exception) {
            throw (Exception) cause;
        }
        if (cause instanceof Error) {
            throw (Error) cause;
        }
        
        throw new Exception(cause);
    }
}
