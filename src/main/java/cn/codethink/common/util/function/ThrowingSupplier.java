package cn.codethink.common.util.function;

import cn.codethink.common.util.Throwables;
import com.google.common.base.Preconditions;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <h1>可抛出异常生产者</h1>
 *
 * @param <T> 返回类型
 * @author Chuanwise
 */
@FunctionalInterface
public interface ThrowingSupplier<T>
    extends Supplier<T> {
    
    /**
     * 抛出指定异常
     *
     * @param throwable 异常
     * @param <T>       返回类型
     * @return 可抛出异常生产者
     */
    static <T> ThrowingSupplier<T> rethrow(Throwable throwable) {
        Preconditions.checkNotNull(throwable, "Throwable is null!");
        return () -> {
            throw throwable;
        };
    }
    
    @Override
    default T get() {
        try {
            return get0();
        } catch (Throwable throwable) {
            Throwables.rethrow(throwable);
            return null;
        }
    }
    
    /**
     * 消费对象
     *
     * @return 对象
     * @throws Throwable 消费对象过程中的异常
     */
    T get0() throws Throwable;
}