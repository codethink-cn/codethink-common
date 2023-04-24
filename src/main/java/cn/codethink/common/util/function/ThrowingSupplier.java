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