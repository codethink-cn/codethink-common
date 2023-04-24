package cn.codethink.common.util.function;

import cn.codethink.common.util.Throwables;
import com.google.common.base.Preconditions;

import java.util.function.Function;

/**
 * <h1>可抛出异常函数</h1>
 *
 * @param <T> 参数类型
 * @param <R> 返回类型
 * @author Chuanwise
 */
@FunctionalInterface
public interface ThrowingFunction<T, R>
    extends Function<T, R> {
    
    /**
     * 抛出指定异常
     *
     * @param throwable 异常
     * @param <T>       参数类型
     * @param <R>       返回类型
     * @return 可抛出异常消费者
     */
    static <T, R> ThrowingFunction<T, R> rethrow(Throwable throwable) {
        Preconditions.checkNotNull(throwable, "Throwable is null!");
        return any -> {
            throw throwable;
        };
    }
    
    @Override
    default R apply(T t) {
        try {
            return apply0(t);
        } catch (Throwable throwable) {
            Throwables.rethrow(throwable);
            return null;
        }
    }
    
    /**
     * 执行
     *
     * @param t 参数
     * @return 返回值
     * @throws Throwable 执行过程中的异常
     */
    R apply0(T t) throws Throwable;
}