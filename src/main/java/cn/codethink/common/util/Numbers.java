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

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字工具
 *
 * @author Chuanwise
 */
@SuppressWarnings("unused")
public class Numbers {
    private Numbers() {
        Throwables.throwNoInstancesException(Numbers.class);
    }
    
    /**
     * 计算两个数字之间的差值绝对值
     *
     * @param left  数字1
     * @param right 数字2
     * @return 差值绝对值
     */
    public static int delta(int left, int right) {
        return Math.abs(left - right);
    }
    
    /**
     * 计算两个数字之间的差值绝对值
     *
     * @param left  数字1
     * @param right 数字2
     * @return 差值绝对值
     */
    public static byte delta(byte left, byte right) {
        return (byte) Math.abs(left - right);
    }
    
    /**
     * 计算两个数字之间的差值绝对值
     *
     * @param left  数字1
     * @param right 数字2
     * @return 差值绝对值
     */
    public static short delta(short left, short right) {
        return (short) Math.abs(left - right);
    }
    
    /**
     * 计算两个数字之间的差值绝对值
     *
     * @param left  数字1
     * @param right 数字2
     * @return 差值绝对值
     */
    public static long delta(long left, long right) {
        return Math.abs(left - right);
    }
    
    /**
     * 计算两个数字之间的差值绝对值
     *
     * @param left  数字1
     * @param right 数字2
     * @return 差值绝对值
     */
    public static float delta(float left, float right) {
        return Math.abs(left - right);
    }
    
    /**
     * 计算两个数字之间的差值绝对值
     *
     * @param left  数字1
     * @param right 数字2
     * @return 差值绝对值
     */
    public static double delta(double left, double right) {
        return Math.abs(left - right);
    }
    
    /**
     * 判断一个数字是否是整数
     *
     * @param number 数字
     * @return 数字是否是整数
     */
    public static boolean isIntegerNumber(Number number) {
        return number instanceof Byte
            || number instanceof Short
            || number instanceof Integer
            || number instanceof Long
            || number instanceof BigInteger;
    }
    
    /**
     * 判断一个数字是否是小数
     *
     * @param number 数字
     * @return 数字是否是小数
     */
    public static boolean isFloatingNumber(Number number) {
        return number instanceof Float
            || number instanceof Double
            || number instanceof BigDecimal;
    }
    
    /**
     * 判断一个数字是否是大数字
     *
     * @param number 数字
     * @return 数字是否是大数字
     */
    public static boolean isBigNumber(Number number) {
        return number instanceof BigDecimal
            || number instanceof BigInteger;
    }
}