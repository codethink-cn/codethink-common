package cn.codethink.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 *
 * @author Chuanwise
 */
public class Exceptions
        extends StaticUtilities {
    
    /**
     * 将异常堆栈信息输出到字符串
     *
     * @param throwable 异常
     * @return 堆栈信息字符串
     */
    public static String writeStackTrace(Throwable throwable) {
        Preconditions.namedArgumentNonNull(throwable, "throwable");
    
        final StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.getBuffer().toString();
    }
}
