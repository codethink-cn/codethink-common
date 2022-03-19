package cn.codethink.common.util;

import java.util.concurrent.TimeUnit;

/**
 * 执行工具类
 *
 * @author Chuanwise
 */
public class Executors
        extends StaticUtilities {
    
    /**
     * 在某个对象上同步
     *
     * @param object 同步对象
     * @throws InterruptedException 中断异常
     */
    @SuppressWarnings("all")
    public static void await(Object object) throws InterruptedException {
        Preconditions.namedArgumentNonNull(object, "object");
    
        synchronized (object) {
            object.wait();
        }
    }
    
    /**
     * 在某个对象上同步
     *
     * @param object     同步对象
     * @param timeout 超时时间戳
     * @return 是否有其他线程在该对象上 notify
     * @throws InterruptedException 中断异常
     */
    @SuppressWarnings("all")
    public static boolean await(Object object, long timeout) throws InterruptedException {
        Preconditions.namedArgumentNonNull(object, "object");
        Preconditions.argument(timeout >= 0, "time millis must be bigger than or equals to 0!");
        
        if (timeout == 0) {
            await(object);
            return true;
        }
    
        final long deadline = System.currentTimeMillis() + timeout;
        
        synchronized (object) {
            object.wait(timeout);
        }
        
        return System.currentTimeMillis() < deadline;
    }
    
    /**
     * 在某个对象上同步
     *
     * @param object   同步对象
     * @param timeout 超时时长
     * @param timeUnit 时间单位
     * @return 是否有其他线程在该对象上 notify
     * @throws InterruptedException 中断异常
     */
    public static boolean await(Object object, long timeout, TimeUnit timeUnit) throws InterruptedException {
        Preconditions.namedArgumentNonNull(object, "object");
        Preconditions.argument(timeout >= 0, "duration must be bigger than or equals to 0!");
        Preconditions.namedArgumentNonNull(timeUnit, "time unit");
        
        return await(object, timeUnit.toMillis(timeout));
    }
    
    /**
     * 不可打断地在某个对象上同步
     *
     * @param object 同步对象
     */
    @SuppressWarnings("all")
    public static void awaitUninterruptibly(Object object) {
        Preconditions.namedArgumentNonNull(object, "object");
    
        while (true) {
            try {
                await(object);
                return;
            } catch (InterruptedException ignored) {
            }
        }
    }
    
    /**
     * 不可打断地在某个对象上同步
     *
     * @param object   同步对象
     * @param timeout 超时时长
     * @param timeUnit 时间单位
     * @return 是否有其他线程在该对象上 notify
     */
    public static boolean awaitUninterruptibly(Object object, long timeout, TimeUnit timeUnit) {
        Preconditions.namedArgumentNonNull(object, "object");
        Preconditions.argument(timeout >= 0, "duration must be bigger than or equals to 0!");
        Preconditions.namedArgumentNonNull(timeUnit, "time unit");
        
        return awaitUninterruptibly(object, timeout, TimeUnit.MILLISECONDS);
    }
    
    /**
     * 不可打断地在某个对象上同步
     *
     * @param object     同步对象
     * @param timeout 超时时间戳
     * @return 是否有其他线程在该对象上 notify
     */
    public static boolean awaitUninterruptibly(Object object, long timeout) {
        Preconditions.namedArgumentNonNull(object, "object");
        Preconditions.argument(timeout >= 0, "time millis must be bigger than or equals to 0!");
        
        if (timeout == 0) {
            awaitUninterruptibly(object);
            return true;
        }

        final long deadline = System.currentTimeMillis() + timeout;
    
        while (true) {
            try {
                final long remain = deadline - System.currentTimeMillis();
            
                if (remain <= 0) {
                    return false;
                } else {
                    return await(object, remain);
                }
            } catch (InterruptedException ignored) {
            }
        }
    }
}