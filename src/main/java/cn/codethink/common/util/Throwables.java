package cn.codethink.common.util;

import com.google.common.base.Preconditions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.NoSuchElementException;

/**
 * <h1>异常工具</h1>
 *
 * @author Chuanwise
 */
public class Throwables {
    private Throwables() {
        throwNoInstancesException(Throwables.class);
    }
    
    /**
     * 抛出工具初始化异常
     *
     * @param instanceClass 工具
     */
    public static void throwNoInstancesException(Class<?> instanceClass) {
        Preconditions.checkNotNull(instanceClass, "Instance class is null!");
        throw new NoSuchElementException("No " + instanceClass.getName() + " instances for you!");
    }
    
    /**
     * 将异常堆栈信息输出到字符串
     *
     * @param throwable 异常
     * @return 堆栈信息字符串
     */
    public static String getStackTrace(Throwable throwable) {
        Preconditions.checkNotNull(throwable, "Throwable is null!");
        
        final StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.getBuffer().toString();
    }
    
    /**
     * 将异常重新抛出
     *
     * @param throwable 异常
     */
    public static void rethrow(Throwable throwable) {
        Preconditions.checkNotNull(throwable, "Throwable is null!");
        rethrow0(throwable);
    }
    
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void rethrow0(Throwable t) throws T {
        throw (T) t;
    }
}