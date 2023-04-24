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

package cn.codethink.common.util;

import com.google.common.base.Preconditions;

import java.util.Objects;

/**
 * StringBuilder 相关工具
 *
 * @author Chuanwise
 */
public class StringBuilders {
    private StringBuilders() {
        Throwables.throwNoInstancesException(StringBuilders.class);
    }
    
    /**
     * 判断 StringBuilder 是否为空
     *
     * @param stringBuilder StringBuilder
     * @return 当 stringBuilder 为 null 或空串时，返回 true，否则返回 false。
     */
    public static boolean isNullOrEmpty(StringBuilder stringBuilder) {
        return stringBuilder == null || stringBuilder.length() == 0;
    }
    
    /**
     * 取出 StringBuilder 中的值，并清空。
     *
     * @param stringBuilder StringBuilder
     * @return stringBuilder 中的内容
     */
    public static String toStringAndClear(StringBuilder stringBuilder) {
        Preconditions.checkNotNull(stringBuilder, "String builder is null!");
    
        final String string = stringBuilder.toString();
        stringBuilder.setLength(0);
        return string;
    }
}
