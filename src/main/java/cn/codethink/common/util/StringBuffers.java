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
 * StringBuffer 相关工具
 *
 * @author Chuanwise
 */
public class StringBuffers {
    private StringBuffers() {
        Throwables.throwNoInstancesException(StringBuffers.class);
    }
    
    /**
     * 判断 StringBuffer 是否为空
     *
     * @param stringBuffer StringBuffer
     * @return 当 stringBuffer 为 null 或空串时，返回 true，否则返回 false。
     */
    public static boolean isNullOrEmpty(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }
    
    /**
     * 取出 StringBuffer 中的值，并清空。
     *
     * @param stringBuffer StringBuffer
     * @return stringBuffer 中的内容
     */
    public static String toStringAndClear(StringBuffer stringBuffer) {
        Preconditions.checkNotNull(stringBuffer, "String buffer is null!");
    
        final String string = stringBuffer.toString();
        stringBuffer.setLength(0);
        return string;
    }
}
