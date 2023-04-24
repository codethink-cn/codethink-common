/*
 * Copyright 2023 CodeThink Technologies and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.codethink.common.util.function;

import cn.codethink.common.util.Throwables;
import com.google.common.base.Preconditions;

import java.util.function.BiConsumer;

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
