package cn.codethink.common.util;

import com.google.common.base.Preconditions;

import java.util.concurrent.TimeUnit;

/**
 * 对象工具
 *
 * @author Chuanwise
 */
@SuppressWarnings("unused")
public class Objects {
    private Objects() {
        Throwables.throwNoInstancesException(Objects.class);
    }
    
    /**
     * 在某个对象上同步
     *
     * @param object 同步对象
     * @throws InterruptedException 中断异常
     */
    @SuppressWarnings("all")
    public static void await(Object object) throws InterruptedException {
        Preconditions.checkNotNull(object, "Object is null!");
        
        synchronized (object) {
            object.wait();
        }
    }
    
    /**
     * 在某个对象上同步
     *
     * @param object  同步对象
     * @param timeout 超时时间戳
     * @return 是否有其他线程在该对象上 notify
     * @throws InterruptedException 中断异常
     */
    @SuppressWarnings("all")
    public static boolean await(Object object, long timeout) throws InterruptedException {
        Preconditions.checkNotNull(object, "Object is null!");
        Preconditions.checkArgument(timeout >= 0, "Timeout must be greater than or equals to 0!");
        
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
     * @param timeout  超时时长
     * @param timeUnit 时间单位
     * @return 是否有其他线程在该对象上 notify
     * @throws InterruptedException 中断异常
     */
    public static boolean await(Object object, long timeout, TimeUnit timeUnit) throws InterruptedException {
        Preconditions.checkNotNull(object, "Object is null!");
        Preconditions.checkArgument(timeout >= 0, "Duration must be greater than or equals to 0!");
        Preconditions.checkNotNull(timeUnit, "Time unit is null!");
        
        return await(object, timeUnit.toMillis(timeout));
    }
    
    /**
     * 不可打断地在某个对象上同步
     *
     * @param object 同步对象
     */
    @SuppressWarnings("all")
    public static void awaitUninterruptibly(Object object) {
        Preconditions.checkNotNull(object, "Object is null!");
        
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
     * @param timeout  超时时长
     * @param timeUnit 时间单位
     * @return 是否有其他线程在该对象上 notify
     */
    public static boolean awaitUninterruptibly(Object object, long timeout, TimeUnit timeUnit) {
        Preconditions.checkNotNull(object, "Object is null!");
        Preconditions.checkArgument(timeout >= 0, "Duration must be greater than or equals to 0!");
        Preconditions.checkNotNull(timeUnit, "Time unit");
        
        return awaitUninterruptibly(object, timeUnit.toMillis(timeout));
    }
    
    /**
     * 不可打断地在某个对象上同步
     *
     * @param object  同步对象
     * @param timeout 超时时间戳
     * @return 是否有其他线程在该对象上 notify
     */
    public static boolean awaitUninterruptibly(Object object, long timeout) {
        Preconditions.checkNotNull(object, "Object is null!");
        Preconditions.checkArgument(timeout >= 0, "Timeout must be greater than or equals to 0!");
        
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
    
    /**
     * 安全地将一个对象转化为某种类型的引用
     *
     * @param instance    对象
     * @param targetClass 目标类型
     * @param <T>         目标类型
     * @return 转换成功后的对象，或 null
     */
    @SuppressWarnings("unchecked")
    public static <T> T safeCast(Object instance, Class<T> targetClass) {
        Preconditions.checkNotNull(targetClass, "Target class");
        
        if (targetClass.isInstance(instance)) {
            return (T) instance;
        } else {
            return null;
        }
    }
}