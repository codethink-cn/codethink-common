package cn.codethink.common.util.function;

import cn.codethink.common.util.Throwables;
import com.google.common.base.Preconditions;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * <h1>可抛出异常消费者</h1>
 *
 * @param <T> 参数 1 类型
 * @param <U> 参数 2 类型
 * @author Chuanwise
 */
@FunctionalInterface
public interface ThrowingBiConsumer<T, U>
    extends BiConsumer<T, U> {
    
    /**
     * 抛出指定异常
     *
     * @param throwable 异常
     * @param <T>       参数 1 类型
     * @param <U>       参数 2 类型
     * @return 可抛出异常消费者
     */
    static <T, U> ThrowingBiConsumer<T, U> rethrow(Throwable throwable) {
        Preconditions.checkNotNull(throwable, "Throwable is null!");
        return (any1, any2) -> {
            throw throwable;
        };
    }
    
    @Override
    default void accept(T t, U u) {
        try {
            accept0(t, u);
        } catch (Throwable throwable) {
            Throwables.rethrow(throwable);
        }
    }
    
    /**
     * 消费对象
     *
     * @param t 参数 1
     * @param u 参数 2
     * @throws Throwable 消费对象过程中的异常
     */
    void accept0(T t, U u) throws Throwable;
}
