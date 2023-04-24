package cn.codethink.common.util;

import com.google.common.base.Preconditions;

import java.util.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <h1>集合工具</h1>
 *
 * @author Chuanwise
 */
@SuppressWarnings("unused")
public class Collections {
    private Collections() {
        Throwables.throwNoInstancesException(Collections.class);
    }
    
    /**
     * 判断集合是否为空
     *
     * @param collection 集合
     * @return 当 collection == null 或没有元素时返回 true
     */
    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
    
    /**
     * 将迭代器元素复制到列表中
     *
     * @param iterable 迭代器
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    public static <T> List<T> list(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        
        final List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
    
    /**
     * 将数组元素复制到列表中
     *
     * @param elements 数组
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> List<T> list(T... elements) {
        Preconditions.checkNotNull(elements, "elements");
    
        return new ArrayList<>(Arrays.asList(elements));
    }
    
    /**
     * 将迭代器元素复制到列表中
     *
     * @param iterable 迭代器
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    public static <T> List<T> concurrentList(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        
        final List<T> list = new CopyOnWriteArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
    
    /**
     * 将数组器元素复制到列表中
     *
     * @param elements 数组
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> List<T> concurrentList(T... elements) {
        Preconditions.checkNotNull(elements, "elements");
        
        return new CopyOnWriteArrayList<>(java.util.Arrays.asList(elements));
    }
    
    /**
     * 将迭代器元素复制到列表中
     *
     * @param iterable 迭代器
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    public static <T> List<T> unmodifiableList(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        
        final List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return java.util.Collections.unmodifiableList(list);
    }
    
    /**
     * 将数组元素复制到列表中
     *
     * @param elements 数组
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> List<T> unmodifiableList(T... elements) {
        Preconditions.checkNotNull(elements, "elements");
        
        return java.util.Arrays.asList(elements);
    }
    
    /**
     * 将迭代器元素复制到列表中
     *
     * @param iterable 迭代器
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    public static <T> Set<T> modifiableSet(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        
        final Set<T> set = new HashSet<>();
        iterable.forEach(set::add);
        return set;
    }
    
    /**
     * 将迭代器元素复制到列表中
     *
     * @param iterable 迭代器
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    public static <T> Set<T> concurrentSet(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        
        final Set<T> set = new CopyOnWriteArraySet<>();
        iterable.forEach(set::add);
        return set;
    }
    
    /**
     * 将迭代器元素复制到列表中
     *
     * @param iterable 迭代器
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    public static <T> Set<T> unmodifiableSet(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        
        final Set<T> set = new HashSet<>();
        iterable.forEach(set::add);
        return java.util.Collections.unmodifiableSet(set);
    }
    
    /**
     * 将迭代器元素复制到列表中
     *
     * @param elements 元素
     * @param <T>      集合元素类型
     * @return 复制后的新列表
     */
    @SafeVarargs
    public static <T> Set<T> unmodifiableSet(T... elements) {
        Preconditions.checkNotNull(elements, "elements");
        return java.util.Collections.unmodifiableSet(new HashSet<>(Arrays.asList(elements)));
    }
    
    /**
     * 寻找起始索引之后的某个值
     *
     * @param iterable   集合
     * @param value      目标值
     * @param beginIndex 起始索引
     * @param <T>        集合元素类型
     * @return 当在起始索引后找到目标值后返回其索引，否则返回 -1
     */
    public static <T> int indexOf(Iterable<T> iterable, T value, int beginIndex) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        Preconditions.checkArgument(beginIndex >= 0, "begin index must be greater than or equals to 0!");
        
        int index = -1;
        for (T t : iterable) {
            index++;
            
            if (index < beginIndex) {
                continue;
            }
            
            if (java.util.Objects.equals(t, value)) {
                return index;
            }
        }
    
        if (index >= beginIndex) {
            throw new NoSuchElementException("No element matches after index " + beginIndex);
        }
        
        return -1;
    }
    
    /**
     * 从头寻找某个值
     *
     * @param iterable 集合
     * @param value    目标值
     * @param <T>      集合元素类型
     * @return 当在找到目标值后返回其索引，否则返回 -1
     */
    public static <T> int indexOf(Iterable<T> iterable, T value) {
        return indexOf(iterable, value, 0);
    }
    
    /**
     * 寻找起始索引之后的某个值
     *
     * @param iterable 集合
     * @param filter   筛选器
     * @param <T>      集合元素类型
     * @return 当在起始索引后找到目标值后返回其索引，否则返回 -1
     */
    public static <T> int indexIf(Iterable<T> iterable, Predicate<T> filter, int beginIndex) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkArgument(beginIndex >= 0, "begin index must be greater than or equals to 0!");
        
        int index = -1;
        for (T t : iterable) {
            index++;
            
            if (index < beginIndex) {
                continue;
            }
            
            if (filter.test(t)) {
                return index;
            }
        }
        
        if (index >= beginIndex) {
            throw new NoSuchElementException("No element matches after index " + beginIndex);
        }
        
        return -1;
    }
    
    /**
     * 从头寻找某个值
     *
     * @param iterable 集合
     * @param filter   筛选器
     * @param <T>      集合元素类型
     * @return 当在找到目标值后返回其索引，否则返回 -1
     */
    public static <T> int indexIf(Iterable<T> iterable, Predicate<T> filter) {
        return indexIf(iterable, filter, 0);
    }
    
    /**
     * 寻找起始索引之后的某个值
     *
     * @param list       集合
     * @param value      目标值
     * @param beginIndex 起始索引
     * @param <T>        集合元素类型
     * @return 当在起始索引后找到目标值后返回其索引，否则返回 -1
     */
    public static <T> int indexOf(List<T> list, T value, int beginIndex) {
        Preconditions.checkNotNull(list, "List is null!");
        Preconditions.checkElementIndex(beginIndex, list.size(), "Begin index");
        
        final int size = list.size();
        for (int i = beginIndex; i < size; i++) {
            final T t = list.get(i);
            if (Objects.equals(value, t)) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * 从头寻找某个值
     *
     * @param list  集合
     * @param value 目标值
     * @param <T>   集合元素类型
     * @return 当找到目标值后返回其索引，否则返回 -1
     */
    public static <T> int indexOf(List<T> list, T value) {
        return indexOf(list, value, 0);
    }
    
    /**
     * 寻找起始索引之后的某个值
     *
     * @param list       集合
     * @param filter     筛选器
     * @param beginIndex 起始索引
     * @param <T>        集合元素类型
     * @return 当在起始索引后找到目标值后返回其索引，否则返回 -1
     */
    public static <T> int indexIf(List<T> list, Predicate<T> filter, int beginIndex) {
        Preconditions.checkNotNull(list, "List is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkElementIndex(beginIndex, list.size(), "Begin index");
        
        final int size = list.size();
        for (int i = beginIndex; i < size; i++) {
            final T t = list.get(i);
            if (filter.test(t)) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * 从头寻找某个值
     *
     * @param list   集合
     * @param filter 筛选器
     * @param <T>    集合元素类型
     * @return 当找到目标值后返回其索引，否则返回 -1
     */
    public static <T> int indexIf(List<T> list, Predicate<T> filter) {
        return indexIf(list, filter, 0);
    }
    
    /**
     * 在集合中添加一个新的元素
     *
     * @param collection 集合
     * @param value      元素
     * @param <T>        元素类型
     * @return 如果集合本包含该元素，返回 false，否则添加并返回 true
     */
    public static <T> boolean addIfNotContains(Collection<T> collection, T value) {
        Preconditions.checkNotNull(collection, "Collection is null!");
        
        if (collection.contains(value)) {
            return false;
        } else {
            return collection.add(value);
        }
    }
    
    /**
     * 在集合中添加一些新的元素
     *
     * @param collection 集合
     * @param iterable   迭代器
     * @param <T>        元素类型
     * @return 如果集合本包含该元素，返回 false，否则添加并返回 true
     */
    public static <T> boolean addAllIfNotContains(Collection<T> collection, Iterable<T> iterable) {
        Preconditions.checkNotNull(collection, "Collection is null!");
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        
        boolean added = false;
        for (T t : iterable) {
            if (addIfNotContains(collection, t)) {
                added = true;
            }
        }
        
        return added;
    }
    
    /**
     * 寻找集合中第一个满足要求的对象
     *
     * @param iterable     集合
     * @param filter       筛选器
     * @param defaultValue 默认值
     * @param <T>          集合元素类型
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static <T> T firstIf(Iterable<T> iterable, Predicate<T> filter, T defaultValue) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (T t : iterable) {
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 寻找集合中第一个满足要求的对象
     *
     * @param iterable 集合
     * @param filter   筛选器
     * @param <T>      集合元素类型
     * @return 当在集合中找到满足筛选器的元素时返回元素，否则返回 null
     */
    public static <T> T firstIf(Iterable<T> iterable, Predicate<T> filter) {
        return firstIf(iterable, filter, null);
    }
    
    /**
     * 在列表中从后往前查找第一个满足要求的对象
     *
     * @param list         列表
     * @param filter       筛选器
     * @param beginIndex   最早找到哪个元素
     * @param defaultValue 默认值
     * @param <T>          列表元素类型
     * @return 当在列表中从后往前找到满足筛选器的元素时返回元素，否则返回默认值
     */
    public static <T> T lastOf(List<T> list, Predicate<T> filter, int beginIndex, T defaultValue) {
        Preconditions.checkNotNull(list, "List is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        Preconditions.checkPositionIndex(beginIndex, list.size(), "Begin index");
        
        final int size = list.size();
        for (int i = size - 1; i >= beginIndex; i--) {
            final T t = list.get(i);
            if (filter.test(t)) {
                return t;
            }
        }
        
        return defaultValue;
    }
    
    /**
     * 在列表中从后往前查找第一个满足要求的对象
     *
     * @param list       列表
     * @param filter     筛选器
     * @param beginIndex 最早找到哪个元素
     * @param <T>        列表元素类型
     * @return 当在列表中从后往前找到满足筛选器的元素时返回元素，否则返回 null
     */
    public static <T> T lastOf(List<T> list, Predicate<T> filter, int beginIndex) {
        return lastOf(list, filter, beginIndex, null);
    }
    
    /**
     * 在列表中从后往前查找第一个满足要求的对象
     *
     * @param list   列表
     * @param filter 筛选器
     * @param <T>    列表元素类型
     * @return 当在列表中从后往前找到满足筛选器的元素时返回元素，否则返回 null
     */
    public static <T> T lastOf(List<T> list, Predicate<T> filter) {
        return lastOf(list, filter, 0, null);
    }
    
    /**
     * 检查集合中是否有满足某条件的元素
     *
     * @param collection 集合
     * @param filter     筛选器
     * @param <T>        集合元素类型
     * @return 集合中是否有满足该条件的元素
     */
    public static <T> boolean containsIf(Collection<T> collection, Predicate<T> filter) {
        Preconditions.checkNotNull(collection, "Collection is null!");
        Preconditions.checkNotNull(filter, "Filter is null!");
        
        for (T t : collection) {
            if (filter.test(t)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 将集合元素转化为字符串
     *
     * @param iterable  集合
     * @param function  方法
     * @param delimiter 分隔符
     * @param <T>       集合元素类型
     * @return 代表集合元素的字符串或空串 ""
     */
    public static <T> String joinToString(Iterable<T> iterable, Function<T, String> function, String delimiter) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        
        return Joiner.builder().delimiter(delimiter).build().plusAll(iterable, function).join();
    }
    
    /**
     * 将集合元素转化为字符串
     *
     * @param iterable 集合
     * @param function 方法
     * @param <T>      集合元素类型
     * @return 代表集合元素的字符串或空串 ""
     */
    public static <T> String joinToString(Iterable<T> iterable, Function<T, String> function) {
        return joinToString(iterable, function, ", ");
    }
    
    /**
     * 将集合元素转化为字符串
     *
     * @param iterable  集合
     * @param delimiter 分隔符
     * @param <T>       集合元素类型
     * @return 代表集合元素的字符串或空串 ""
     */
    public static <T> String joinToString(Iterable<T> iterable, String delimiter) {
        return joinToString(iterable, java.util.Objects::toString, delimiter);
    }
    
    /**
     * 将集合元素转化为字符串
     *
     * @param iterable 集合
     * @param <T>      集合元素类型
     * @return 代表集合元素的字符串或空串 ""
     */
    public static <T> String joinToString(Iterable<T> iterable) {
        return joinToString(iterable, java.util.Objects::toString, ", ");
    }
    
    /**
     * 将列表元素的一部分转化为字符串
     *
     * @param list      列表
     * @param function  方法
     * @param begin     区间起始
     * @param end       区间终止
     * @param delimiter 分隔符
     * @param <T>       集合元素类型
     * @return 代表列表元素的字符串或空串 ""
     * @throws IllegalArgumentException 区间不合法
     */
    public static <T> String joinToString(List<T> list, Function<T, String> function, int begin, int end, String delimiter) {
        Preconditions.checkNotNull(list, "List is null!");
        Preconditions.checkNotNull(function, "Function is null!");
        Preconditions.checkNotNull(delimiter, "Delimiter is null!");
        Preconditions.checkPositionIndexes(begin, end, list.size());
    
        if (end == begin) {
            return "";
        }
        if (end == begin + 1) {
            return function.apply(list.get(begin));
        }
        final StringBuilder stringBuilder = new StringBuilder(function.apply(list.get(begin)));
        for (int i = begin + 1; i < end; i++) {
            stringBuilder.append(delimiter).append(function.apply(list.get(i)));
        }
        return stringBuilder.toString();
    }
    
    /**
     * 将列表元素的一部分转化为字符串
     *
     * @param list      列表
     * @param function  方法
     * @param begin     区间起始
     * @param delimiter 分隔符
     * @param <T>       集合元素类型
     * @return 代表列表元素的字符串或空串 ""
     * @throws IllegalArgumentException 区间不合法
     */
    public static <T> String joinToString(List<T> list, Function<T, String> function, int begin, String delimiter) {
        return joinToString(list, function, begin, list.size(), delimiter);
    }
    
    /**
     * 将列表元素的一部分转化为字符串
     *
     * @param list      列表
     * @param begin     区间起始
     * @param end       区间终止
     * @param delimiter 分隔符
     * @param <T>       集合元素类型
     * @return 代表列表元素的字符串或空串 ""
     * @throws IllegalArgumentException 区间不合法
     */
    public static <T> String joinToString(List<T> list, int begin, int end, String delimiter) {
        return joinToString(list, java.util.Objects::toString, begin, end, delimiter);
    }
    
    /**
     * 将列表元素的一部分转化为字符串
     *
     * @param list      列表
     * @param begin     区间起始
     * @param delimiter 分隔符
     * @param <T>       集合元素类型
     * @return 代表列表元素的字符串或空串 ""
     * @throws IllegalArgumentException 区间不合法
     */
    public static <T> String joinToString(List<T> list, int begin, String delimiter) {
        return joinToString(list, java.util.Objects::toString, begin, list.size(), delimiter);
    }
}