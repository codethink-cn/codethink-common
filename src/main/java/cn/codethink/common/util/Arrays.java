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

import java.util.*;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <h1>数组工具</h1>
 *
 * @author Chuanwise
 */
@SuppressWarnings("unused")
public class Arrays {
    private Arrays() {
        Throwables.throwNoInstancesException(Arrays.class);
    }
    
    /**
     * 对数组拆箱
     *
     * @param array 包装类型数组
     * @return 拆箱后的数组
     */
    public static boolean[] unbox(Boolean[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final boolean[] newArray = new boolean[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 对数组装箱
     *
     * @param array 基本类型数组
     * @return 装箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static Boolean[] box(boolean[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final Boolean[] newArray = new Boolean[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexOf(boolean[] array, boolean value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexOf(boolean[] array, boolean value, int beginIndex) {
        return indexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexOf(boolean[] array, boolean value) {
        return indexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexOf(boolean[] array, boolean value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(boolean[] array, boolean value, int beginIndex) {
        return lastIndexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(boolean[] array, boolean value) {
        return lastIndexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexIf(boolean[] array, Predicate<Boolean> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexIf(boolean[] array, Predicate<Boolean> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexIf(boolean[] array, Predicate<Boolean> filter) {
        return indexIf(array, filter, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexIf(boolean[] array, Predicate<Boolean> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(boolean[] array, Predicate<Boolean> filter, int beginIndex) {
        return lastIndexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(boolean[] array, Predicate<Boolean> filter) {
        return lastIndexIf(array, filter, 0, -1);
    }
    
    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 如果数组为 null 或 length 为 0，返回 false，否则返回 true
     */
    public static boolean isNullOrEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(boolean[] array, boolean value, int beginIndex) {
        return indexOf(array, value, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(boolean[] array, boolean value) {
        return indexOf(array, value) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     * * @throws NullPointerException array 为 null
     * * @throws NullPointerException filter 为 null
     */
    public static boolean containsIf(boolean[] array, Predicate<Boolean> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(boolean[] array, Predicate<Boolean> filter) {
        return indexIf(array, filter) != -1;
    }
    
    /**
     * 对数组拆箱
     *
     * @param array 包装类型数组
     * @return 拆箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static char[] unbox(Character[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final char[] newArray = new char[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 对数组装箱
     *
     * @param array 基本类型数组
     * @return 装箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static Character[] box(char[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final Character[] newArray = new Character[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexOf(char[] array, char value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexOf(char[] array, char value, int beginIndex) {
        return indexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexOf(char[] array, char value) {
        return indexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexOf(char[] array, char value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(char[] array, char value, int beginIndex) {
        return lastIndexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(char[] array, char value) {
        return lastIndexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexIf(char[] array, Predicate<Character> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexIf(char[] array, Predicate<Character> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexIf(char[] array, Predicate<Character> filter) {
        return indexIf(array, filter, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexIf(char[] array, Predicate<Character> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(char[] array, Predicate<Character> filter, int beginIndex) {
        return lastIndexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(char[] array, Predicate<Character> filter) {
        return lastIndexIf(array, filter, 0, -1);
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(char[] array, char value, int beginIndex) {
        return indexOf(array, value, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(char[] array, char value) {
        return indexOf(array, value) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(char[] array, Predicate<Character> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(char[] array, Predicate<Character> filter) {
        return indexIf(array, filter) != -1;
    }
    
    /**
     * 对数组拆箱
     *
     * @param array 包装类型数组
     * @return 拆箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static short[] unbox(Short[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final short[] newArray = new short[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 对数组装箱
     *
     * @param array 基本类型数组
     * @return 装箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static Short[] box(short[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final Short[] newArray = new Short[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexOf(short[] array, short value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexOf(short[] array, short value, int beginIndex) {
        return indexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexOf(short[] array, short value) {
        return indexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexOf(short[] array, short value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(short[] array, short value, int beginIndex) {
        return lastIndexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(short[] array, short value) {
        return lastIndexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexIf(short[] array, Predicate<Short> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexIf(short[] array, Predicate<Short> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexIf(short[] array, Predicate<Short> filter) {
        return indexIf(array, filter, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexIf(short[] array, Predicate<Short> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(short[] array, Predicate<Short> filter, int beginIndex) {
        return lastIndexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(short[] array, Predicate<Short> filter) {
        return lastIndexIf(array, filter, 0, -1);
    }
    
    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 如果数组为 null 或 length 为 0，返回 false，否则返回 true
     */
    public static boolean isNullOrEmpty(short[] array) {
        return array == null || array.length == 0;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(short[] array, short value, int beginIndex) {
        return indexOf(array, value, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(short[] array, short value) {
        return indexOf(array, value) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(short[] array, Predicate<Short> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(short[] array, Predicate<Short> filter) {
        return indexIf(array, filter) != -1;
    }
    
    /**
     * 对数组拆箱
     *
     * @param array 包装类型数组
     * @return 拆箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static int[] unbox(Integer[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 对数组装箱
     *
     * @param array 基本类型数组
     * @return 装箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static Integer[] box(int[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final Integer[] newArray = new Integer[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexOf(int[] array, int value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexOf(int[] array, int value, int beginIndex) {
        return indexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexOf(int[] array, int value) {
        return indexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexOf(int[] array, int value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(int[] array, int value, int beginIndex) {
        return lastIndexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(int[] array, int value) {
        return lastIndexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexIf(int[] array, Predicate<Integer> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexIf(int[] array, Predicate<Integer> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexIf(int[] array, Predicate<Integer> filter) {
        return indexIf(array, filter, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexIf(int[] array, Predicate<Integer> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(int[] array, Predicate<Integer> filter, int beginIndex) {
        return lastIndexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(int[] array, Predicate<Integer> filter) {
        return lastIndexIf(array, filter, 0, -1);
    }
    
    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 如果数组为 null 或 length 为 0，返回 false，否则返回 true
     */
    public static boolean isNullOrEmpty(int[] array) {
        return array == null || array.length == 0;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(int[] array, int value, int beginIndex) {
        return indexOf(array, value, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(int[] array, int value) {
        return indexOf(array, value) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(int[] array, Predicate<Integer> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(int[] array, Predicate<Integer> filter) {
        return indexIf(array, filter) != -1;
    }
    
    /**
     * 对数组拆箱
     *
     * @param array 包装类型数组
     * @return 拆箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static long[] unbox(Long[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final long[] newArray = new long[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 对数组装箱
     *
     * @param array 基本类型数组
     * @return 装箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static Long[] box(long[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final Long[] newArray = new Long[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexOf(long[] array, long value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexOf(long[] array, long value, int beginIndex) {
        return indexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexOf(long[] array, long value) {
        return indexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexOf(long[] array, long value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(long[] array, long value, int beginIndex) {
        return lastIndexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(long[] array, long value) {
        return lastIndexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexIf(long[] array, Predicate<Long> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexIf(long[] array, Predicate<Long> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexIf(long[] array, Predicate<Long> filter) {
        return indexIf(array, filter, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexIf(long[] array, Predicate<Long> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(long[] array, Predicate<Long> filter, int beginIndex) {
        return lastIndexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(long[] array, Predicate<Long> filter) {
        return lastIndexIf(array, filter, 0, -1);
    }
    
    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 如果数组为 null 或 length 为 0，返回 false，否则返回 true
     */
    public static boolean isNullOrEmpty(long[] array) {
        return array == null || array.length == 0;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(long[] array, long value, int beginIndex) {
        return indexOf(array, value, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(long[] array, long value) {
        return indexOf(array, value) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(long[] array, Predicate<Long> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(long[] array, Predicate<Long> filter) {
        return indexIf(array, filter) != -1;
    }
    
    /**
     * 对数组拆箱
     *
     * @param array 包装类型数组
     * @return 拆箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static float[] unbox(Float[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final float[] newArray = new float[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 对数组装箱
     *
     * @param array 基本类型数组
     * @return 装箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static Float[] box(float[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final Float[] newArray = new Float[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexOf(float[] array, float value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexOf(float[] array, float value, int beginIndex) {
        return indexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexOf(float[] array, float value) {
        return indexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexOf(float[] array, float value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(float[] array, float value, int beginIndex) {
        return lastIndexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(float[] array, float value) {
        return lastIndexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexIf(float[] array, Predicate<Float> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexIf(float[] array, Predicate<Float> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexIf(float[] array, Predicate<Float> filter) {
        return indexIf(array, filter, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexIf(float[] array, Predicate<Float> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(float[] array, Predicate<Float> filter, int beginIndex) {
        return lastIndexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(float[] array, Predicate<Float> filter) {
        return lastIndexIf(array, filter, 0, -1);
    }
    
    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 如果数组为 null 或 length 为 0，返回 false，否则返回 true
     */
    public static boolean isNullOrEmpty(float[] array) {
        return array == null || array.length == 0;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(float[] array, float value, int beginIndex) {
        return indexOf(array, value, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(float[] array, float value) {
        return indexOf(array, value) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(float[] array, Predicate<Float> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(float[] array, Predicate<Float> filter) {
        return indexIf(array, filter) != -1;
    }
    
    /**
     * 对数组拆箱
     *
     * @param array 包装类型数组
     * @return 拆箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static double[] unbox(Double[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final double[] newArray = new double[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 对数组装箱
     *
     * @param array 基本类型数组
     * @return 装箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static Double[] box(double[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final Double[] newArray = new Double[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexOf(double[] array, double value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexOf(double[] array, double value, int beginIndex) {
        return indexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexOf(double[] array, double value) {
        return indexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexOf(double[] array, double value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(double[] array, double value, int beginIndex) {
        return lastIndexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(double[] array, double value) {
        return lastIndexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexIf(double[] array, Predicate<Double> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexIf(double[] array, Predicate<Double> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexIf(double[] array, Predicate<Double> filter) {
        return indexIf(array, filter, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexIf(double[] array, Predicate<Double> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(double[] array, Predicate<Double> filter, int beginIndex) {
        return lastIndexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(double[] array, Predicate<Double> filter) {
        return lastIndexIf(array, filter, 0, -1);
    }
    
    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 如果数组为 null 或 length 为 0，返回 false，否则返回 true
     */
    public static boolean isNullOrEmpty(double[] array) {
        return array == null || array.length == 0;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(double[] array, double value, int beginIndex) {
        return indexOf(array, value, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(double[] array, double value) {
        return indexOf(array, value) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(double[] array, Predicate<Double> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(double[] array, Predicate<Double> filter) {
        return indexIf(array, filter) != -1;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static <T> int indexOf(T[] array, T value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (java.util.Objects.equals(array[i], value)) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static <T> int indexOf(T[] array, T value, int beginIndex) {
        return indexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static <T> int indexOf(T[] array, T value) {
        return indexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static <T> int lastIndexOf(T[] array, T value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static <T> int lastIndexOf(T[] array, T value, int beginIndex) {
        return lastIndexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static <T> int lastIndexOf(T[] array, T value) {
        return lastIndexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static <T> int indexIf(T[] array, Predicate<T> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static <T> int indexIf(T[] array, Predicate<T> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static <T> int indexIf(T[] array, Predicate<T> filter) {
        return indexIf(array, filter, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static <T> int lastIndexIf(T[] array, Predicate<T> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static <T> int lastIndexIf(T[] array, Predicate<T> filter, int beginIndex) {
        return lastIndexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static <T> int lastIndexIf(T[] array, Predicate<T> filter) {
        return lastIndexIf(array, filter, 0, -1);
    }
    
    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 如果数组为 null 或 length 为 0，返回 false，否则返回 true
     */
    public static <T> boolean isNullOrEmpty(T[] array) {
        return array == null || array.length == 0;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static <T> boolean contains(T[] array, T value, int beginIndex) {
        return indexOf(array, value, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static <T> boolean contains(T[] array, T value) {
        return indexOf(array, value) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static <T> boolean containsIf(T[] array, Predicate<T> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static <T> boolean containsIf(T[] array, Predicate<T> filter) {
        return indexIf(array, filter) != -1;
    }
    
    /**
     * 将数组元素复制到列表中
     *
     * @param array 数组
     * @param <T>   数组元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> List<T> list(T... array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final List<T> list = new ArrayList<>(array.length);
        list.addAll(java.util.Arrays.asList(array));
        return list;
    }
    
    /**
     * 将数组元素复制到列表中
     *
     * @param array 数组
     * @param <T>   数组元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> List<T> concurrentList(T... array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        return new CopyOnWriteArrayList<>(java.util.Arrays.asList(array));
    }
    
    /**
     * 将数组元素复制到列表中
     *
     * @param array 数组
     * @param <T>   数组元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> List<T> unmodifiableList(T... array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        return java.util.Arrays.asList(array);
    }
    
    /**
     * 将数组中的元素复制到集合中
     *
     * @param array 数组
     * @param <T>   数组元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> Set<T> modifiableSet(T... array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final Set<T> set = new HashSet<>(array.length);
        set.addAll(java.util.Arrays.asList(array));
        return set;
    }
    
    /**
     * 将数组中的元素复制到集合中
     *
     * @param array 数组
     * @param <T>   数组元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> Set<T> concurrentSet(T... array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        return new CopyOnWriteArraySet<>(modifiableSet(array));
    }
    
    /**
     * 将数组中的元素复制到集合中
     *
     * @param array 数组
     * @param <T>   数组元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> Set<T> unmodifiableSet(T... array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        return Collections.unmodifiableSet(modifiableSet(array));
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @param <T>          数组元素类型
     * @return 当在数组中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static <T> T firstIf(T[] array, Predicate<T> filter, T defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (T t : array) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @param <T>    数组元素类型
     * @return 当在数组中找到满足筛选器的元素时返回元素，否则返回 null
     */
    public static <T> T firstIf(T[] array, Predicate<T> filter) {
        return firstIf(array, filter, null);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array        列表
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @param <T>          数组元素类型
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static <T> T lastIf(T[] array, Predicate<T> filter, int beginIndex, T defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkPositionIndex(beginIndex, array.length, "Begin index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            final T t = array[i];
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array      列表
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @param <T>        数组元素类型
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 null
     */
    public static <T> T lastIf(T[] array, Predicate<T> filter, int beginIndex) {
        return lastIf(array, filter, beginIndex, null);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array  列表
     * @param filter 筛选器
     * @param <T>    数组元素类型
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 null
     */
    public static <T> T lastIf(T[] array, Predicate<T> filter) {
        return lastIf(array, filter, 0, null);
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static char firstIf(char[] array, Predicate<Character> filter, char defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (char t : array) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static char firstIf(char[] array, Predicate<Character> filter) {
        return firstIf(array, filter, (char) -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static char lastIf(char[] array, Predicate<Character> filter, int beginIndex, char defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkElementIndex(beginIndex, array.length, "Begin index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            final char t = array[i];
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static char lastIf(char[] array, Predicate<Character> filter, int beginIndex) {
        return lastIf(array, filter, beginIndex, (char) -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static char lastIf(char[] array, Predicate<Character> filter) {
        return lastIf(array, filter, 0, (char) -1);
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static boolean firstIf(boolean[] array, Predicate<Boolean> filter, boolean defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (boolean t : array) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回 false
     */
    public static boolean firstIf(boolean[] array, Predicate<Boolean> filter) {
        return firstIf(array, filter, false);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static boolean lastIf(boolean[] array, Predicate<Boolean> filter, int beginIndex, boolean defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkElementIndex(beginIndex, array.length, "Begin index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            final boolean t = array[i];
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 false
     */
    public static boolean lastIf(boolean[] array, Predicate<Boolean> filter, int beginIndex) {
        return lastIf(array, filter, beginIndex, false);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 false
     */
    public static boolean lastIf(boolean[] array, Predicate<Boolean> filter) {
        return lastIf(array, filter, 0, false);
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static short firstIf(short[] array, Predicate<Short> filter, short defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (short t : array) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static short firstIf(short[] array, Predicate<Short> filter) {
        return firstIf(array, filter, (short) -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static short lastIf(short[] array, Predicate<Short> filter, int beginIndex, short defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkElementIndex(beginIndex, array.length, "Begin index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            final short t = array[i];
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static short lastIf(short[] array, Predicate<Short> filter, int beginIndex) {
        return lastIf(array, filter, beginIndex, (short) -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static short lastIf(short[] array, Predicate<Short> filter) {
        return lastIf(array, filter, 0, (short) -1);
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static int firstIf(int[] array, Predicate<Integer> filter, int defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (int t : array) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static int firstIf(int[] array, Predicate<Integer> filter) {
        return firstIf(array, filter, -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static int lastIf(int[] array, Predicate<Integer> filter, int beginIndex, int defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkElementIndex(beginIndex, array.length, "Begin index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            final int t = array[i];
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static int lastIf(int[] array, Predicate<Integer> filter, int beginIndex) {
        return lastIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static int lastIf(int[] array, Predicate<Integer> filter) {
        return lastIf(array, filter, 0, -1);
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static long firstIf(long[] array, Predicate<Long> filter, long defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (long t : array) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static long firstIf(long[] array, Predicate<Long> filter) {
        return firstIf(array, filter, -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static long lastIf(long[] array, Predicate<Long> filter, int beginIndex, long defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkElementIndex(beginIndex, array.length, "Begin index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            final long t = array[i];
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static long lastIf(long[] array, Predicate<Long> filter, int beginIndex) {
        return lastIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static long lastIf(long[] array, Predicate<Long> filter) {
        return lastIf(array, filter, 0, -1);
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static double firstIf(double[] array, Predicate<Double> filter, double defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (double t : array) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static double firstIf(double[] array, Predicate<Double> filter) {
        return firstIf(array, filter, -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static double lastIf(double[] array, Predicate<Double> filter, int beginIndex, double defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkElementIndex(beginIndex, array.length, "Begin index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            final double t = array[i];
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static double lastIf(double[] array, Predicate<Double> filter, int beginIndex) {
        return lastIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static double lastIf(double[] array, Predicate<Double> filter) {
        return lastIf(array, filter, 0, -1);
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static float firstIf(float[] array, Predicate<Float> filter, float defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (float t : array) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static float firstIf(float[] array, Predicate<Float> filter) {
        return firstIf(array, filter, (float) -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static float lastIf(float[] array, Predicate<Float> filter, int beginIndex, float defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkElementIndex(beginIndex, array.length, "Begin index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            final float t = array[i];
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static float lastIf(float[] array, Predicate<Float> filter, int beginIndex) {
        return lastIf(array, filter, beginIndex, (float) -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static float lastIf(float[] array, Predicate<Float> filter) {
        return lastIf(array, filter, 0, (float) -1);
    }
    
    /**
     * 将数组转化为字符串
     *
     * @param array     数组
     * @param function  转化为字符串的工具
     * @param delimiter 分隔符
     * @param <T>       数组元素类型
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static <T> String joinToString(T[] array, Function<T, String> function, String delimiter) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(array, function).join();
    }
    
    /**
     * 将数组转化为字符串，默认分隔符为 ", "
     *
     * @param array    数组
     * @param function 转化为字符串的工具
     * @param <T>      数组元素类型
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static <T> String joinToString(T[] array, Function<T, String> function) {
        return joinToString(array, function, ", ");
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}
     *
     * @param array     数组
     * @param delimiter 分隔符
     * @param <T>       数组元素类型
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static <T> String joinToString(T[] array, String delimiter) {
        return joinToString(array, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}，分隔符是 ", "
     *
     * @param array 数组
     * @param <T>   数组元素类型
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static <T> String joinToString(T[] array) {
        return joinToString(array, java.util.Objects::toString, ", ");
    }
    
    /**
     * 将数组转化为字符串
     *
     * @param array     数组
     * @param function  转化为字符串的工具
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(boolean[] array, Function<Boolean, String> function, String delimiter) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(array, function).join();
    }
    
    /**
     * 将数组转化为字符串，默认分隔符为 ", "
     *
     * @param array    数组
     * @param function 转化为字符串的工具
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(boolean[] array, Function<Boolean, String> function) {
        return joinToString(array, function, ", ");
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}
     *
     * @param array     数组
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(boolean[] array, String delimiter) {
        return joinToString(array, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}，分隔符是 ", "
     *
     * @param array 数组
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(boolean[] array) {
        return joinToString(array, java.util.Objects::toString, ", ");
    }
    
    /**
     * 将数组转化为字符串
     *
     * @param array     数组
     * @param function  转化为字符串的工具
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(char[] array, Function<Character, String> function, String delimiter) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(array, function).join();
    }
    
    /**
     * 将数组转化为字符串，默认分隔符为 ", "
     *
     * @param array    数组
     * @param function 转化为字符串的工具
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(char[] array, Function<Character, String> function) {
        return joinToString(array, function, ", ");
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}
     *
     * @param array     数组
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(char[] array, String delimiter) {
        return joinToString(array, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}，分隔符是 ", "
     *
     * @param array 数组
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(char[] array) {
        return joinToString(array, java.util.Objects::toString, ", ");
    }
    
    /**
     * 将数组转化为字符串
     *
     * @param array     数组
     * @param function  转化为字符串的工具
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(short[] array, Function<Short, String> function, String delimiter) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(array, function).join();
    }
    
    /**
     * 将数组转化为字符串，默认分隔符为 ", "
     *
     * @param array    数组
     * @param function 转化为字符串的工具
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(short[] array, Function<Short, String> function) {
        return joinToString(array, function, ", ");
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}
     *
     * @param array     数组
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(short[] array, String delimiter) {
        return joinToString(array, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}，分隔符是 ", "
     *
     * @param array 数组
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(short[] array) {
        return joinToString(array, java.util.Objects::toString, ", ");
    }
    
    /**
     * 将数组转化为字符串
     *
     * @param array     数组
     * @param function  转化为字符串的工具
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(int[] array, Function<Integer, String> function, String delimiter) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(array, function).join();
    }
    
    /**
     * 将数组转化为字符串，默认分隔符为 ", "
     *
     * @param array    数组
     * @param function 转化为字符串的工具
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(int[] array, Function<Integer, String> function) {
        return joinToString(array, function, ", ");
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}
     *
     * @param array     数组
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(int[] array, String delimiter) {
        return joinToString(array, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}，分隔符是 ", "
     *
     * @param array 数组
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(int[] array) {
        return joinToString(array, java.util.Objects::toString, ", ");
    }
    
    /**
     * 将数组转化为字符串
     *
     * @param array     数组
     * @param function  转化为字符串的工具
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(long[] array, Function<Long, String> function, String delimiter) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(array, function).join();
    }
    
    /**
     * 将数组转化为字符串，默认分隔符为 ", "
     *
     * @param array    数组
     * @param function 转化为字符串的工具
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(long[] array, Function<Long, String> function) {
        return joinToString(array, function, ", ");
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}
     *
     * @param array     数组
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(long[] array, String delimiter) {
        return joinToString(array, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}，分隔符是 ", "
     *
     * @param array 数组
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(long[] array) {
        return joinToString(array, java.util.Objects::toString, ", ");
    }
    
    /**
     * 将数组转化为字符串
     *
     * @param array     数组
     * @param function  转化为字符串的工具
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(float[] array, Function<Float, String> function, String delimiter) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(array, function).join();
    }
    
    /**
     * 将数组转化为字符串，默认分隔符为 ", "
     *
     * @param array    数组
     * @param function 转化为字符串的工具
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(float[] array, Function<Float, String> function) {
        return joinToString(array, function, ", ");
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}
     *
     * @param array     数组
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(float[] array, String delimiter) {
        return joinToString(array, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}，分隔符是 ", "
     *
     * @param array 数组
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(float[] array) {
        return joinToString(array, java.util.Objects::toString, ", ");
    }
    
    /**
     * 将数组转化为字符串
     *
     * @param array     数组
     * @param function  转化为字符串的工具
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(double[] array, Function<Double, String> function, String delimiter) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(array, function).join();
    }
    
    /**
     * 将数组转化为字符串，默认分隔符为 ", "
     *
     * @param array    数组
     * @param function 转化为字符串的工具
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(double[] array, Function<Double, String> function) {
        return joinToString(array, function, ", ");
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}
     *
     * @param array     数组
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(double[] array, String delimiter) {
        return joinToString(array, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}，分隔符是 ", "
     *
     * @param array 数组
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(double[] array) {
        return joinToString(array, java.util.Objects::toString, ", ");
    }
    
    /**
     * 对数组拆箱
     *
     * @param array 包装类型数组
     * @return 拆箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static byte[] unbox(Byte[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final byte[] newArray = new byte[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 对数组装箱
     *
     * @param array 基本类型数组
     * @return 装箱后的数组
     * @throws IllegalArgumentException 包装类型数组是 null
     */
    public static Byte[] box(byte[] array) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        final Byte[] newArray = new Byte[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexOf(byte[] array, byte value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexOf(byte[] array, byte value, int beginIndex) {
        return indexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexOf(byte[] array, byte value) {
        return indexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param value        值
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexOf(byte[] array, byte value, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param value      值
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(byte[] array, byte value, int beginIndex) {
        return lastIndexOf(array, value, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array 数组
     * @param value 值
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexOf(byte[] array, byte value) {
        return lastIndexOf(array, value, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int indexIf(byte[] array, Predicate<Byte> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = beginIndex; i < array.length; i++) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int indexIf(byte[] array, Predicate<Byte> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int indexIf(byte[] array, Predicate<Byte> filter) {
        return indexIf(array, filter, 0, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   起始索引
     * @param defaultIndex 默认索引
     * @return 在起始索引后找到时返回其索引，否则返回默认索引
     */
    public static int lastIndexIf(byte[] array, Predicate<Byte> filter, int beginIndex, int defaultIndex) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        if (array.length == 0) {
            return defaultIndex;
        }
        Preconditions.checkElementIndex(beginIndex, array.length, "start index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            if (filter.test(array[i])) {
                return i;
            }
        }
        
        return defaultIndex;
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @return 在起始索引后找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(byte[] array, Predicate<Byte> filter, int beginIndex) {
        return lastIndexIf(array, filter, beginIndex, -1);
    }
    
    /**
     * 在数组中查找一个值
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 找到时返回其索引，否则返回 -1
     */
    public static int lastIndexIf(byte[] array, Predicate<Byte> filter) {
        return lastIndexIf(array, filter, 0, -1);
    }
    
    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return 如果数组为 null 或 length 为 0，返回 false，否则返回 true
     */
    public static boolean isNullOrEmpty(byte[] array) {
        return array == null || array.length == 0;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(byte[] array, byte value, int beginIndex) {
        return indexOf(array, value, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean contains(byte[] array, byte value) {
        return indexOf(array, value) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array      数组
     * @param beginIndex 起始索引
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(byte[] array, Predicate<Byte> filter, int beginIndex) {
        return indexIf(array, filter, beginIndex) != -1;
    }
    
    /**
     * 判断数组是否包含某个元素
     *
     * @param array 数组
     * @return 如果数组包含该元素，返回 true，否则返回 false
     */
    public static boolean containsIf(byte[] array, Predicate<Byte> filter) {
        return indexIf(array, filter) != -1;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static byte firstIf(byte[] array, Predicate<Byte> filter, byte defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (byte t : array) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找数组中第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static byte firstIf(byte[] array, Predicate<Byte> filter) {
        return firstIf(array, filter, (byte) -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array        数组
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static byte lastIf(byte[] array, Predicate<Byte> filter, int beginIndex, byte defaultValue) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkElementIndex(beginIndex, array.length, "Begin index");
        
        for (int i = array.length - 1; i >= beginIndex; i--) {
            final byte t = array[i];
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array      数组
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static byte lastIf(byte[] array, Predicate<Byte> filter, int beginIndex) {
        return lastIf(array, filter, beginIndex, (byte) -1);
    }
    
    /**
     * 在数组中从后往前查找第一个满足要求的对象
     *
     * @param array  数组
     * @param filter 筛选器
     * @return 当在数组中从后往前找到满足筛选器的元素时返回元素，否则返回 -1
     */
    public static byte lastIf(byte[] array, Predicate<Byte> filter) {
        return lastIf(array, filter, 0, (byte) -1);
    }
    
    
    /**
     * 将数组转化为字符串
     *
     * @param array     数组
     * @param function  转化为字符串的工具
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(byte[] array, Function<Byte, String> function, String delimiter) {
        Preconditions.checkNotNull(array, "Array is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(array, function).join();
    }
    
    /**
     * 将数组转化为字符串，默认分隔符为 ", "
     *
     * @param array    数组
     * @param function 转化为字符串的工具
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(byte[] array, Function<Byte, String> function) {
        return joinToString(array, function, ", ");
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}
     *
     * @param array     数组
     * @param delimiter 分隔符
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(byte[] array, String delimiter) {
        return joinToString(array, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将数组转化为字符串，默认方法是 {@link Objects#toString()}，分隔符是 ", "
     *
     * @param array 数组
     * @return 代表数组内容的字符串，或空字符串 ""
     */
    public static String joinToString(byte[] array) {
        return joinToString(array, java.util.Objects::toString, ", ");
    }
}