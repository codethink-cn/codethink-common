package cn.codethink.common.util.function;

import cn.codethink.common.util.Throwables;
import com.google.common.base.Preconditions;

import java.util.function.Consumer;

/**
 * <h1>可抛出异常消费者</h1>
 *
 * @param <T> 参数类型
 * @author Chuanwise
 */
@FunctionalInterface
public interface ThrowingConsumer<T>
    extends Consumer<T> {
    
    /**
     * 抛出指定异常
     *
     * @param throwable 异常
     * @param <T>       参数类型
     * @return 可抛出异常消费者
     */
    static <T> ThrowingConsumer<T> rethrow(Throwable throwable) {
        Preconditions.checkNotNull(throwable, "Throwable is null!");
        return any -> {
            throw throwable;
        };
    }
    
    /**
     * 抛出参数
     *
     * @param <T> 参数类型
     * @return 可抛出异常消费者
     */
    static <T extends Throwable> ThrowingConsumer<T> rethrow() {
        return throwable -> {
            throw throwable;
        };
    }
    
    @Override
    default void accept(T t) {
        try {
            accept0(t);
        } catch (Throwable throwable) {
            Throwables.rethrow(throwable);
        }
    }
    
    /**
     * 消费对象
     *
     * @param t 对象
     * @throws Throwable 消费对象过程中的异常
     */
    void accept0(T t) throws Throwable;
}
