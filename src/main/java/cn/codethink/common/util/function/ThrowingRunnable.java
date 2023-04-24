package cn.codethink.common.util.function;

import cn.codethink.common.util.Throwables;
import com.google.common.base.Preconditions;

import java.util.function.Consumer;

/**
 * <h1>可抛出异常动作</h1>
 *
 * @author Chuanwise
 */
@FunctionalInterface
public interface ThrowingRunnable
    extends Runnable {
    
    /**
     * 抛出指定异常
     *
     * @param throwable 异常
     * @return 可抛出异常消费者
     */
    static ThrowingRunnable rethrow(Throwable throwable) {
        Preconditions.checkNotNull(throwable, "Throwable is null!");
        return () -> {
            throw throwable;
        };
    }
    
    @Override
    default void run() {
        try {
            run0();
        } catch (Throwable throwable) {
            Throwables.rethrow(throwable);
        }
    }
    
    /**
     * 执行
     *
     * @throws Throwable 执行过程中的异常
     */
    void run0() throws Throwable;
}
