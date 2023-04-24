package cn.codethink.common.util;

import com.google.common.base.Preconditions;

import java.util.Objects;
import java.util.function.Function;

/**
 * 用于拼接字符串的 joiner
 *
 * @author Chuanwise
 */
@SuppressWarnings("unused")
public class Joiner {
    
    /**
     * 前缀
     */
    private final String prefix;
    
    /**
     * 后缀
     */
    private final String suffix;
    
    /**
     * 分隔符
     */
    private final String delimiter;
    
    /**
     * 空字符串
     */
    private final String emptyString;
    
    /**
     * 字符串缓存
     */
    private final StringBuilder stringBuilder = new StringBuilder();
    
    /**
     * 元素可空
     */
    private final boolean nullable;
    
    /**
     * Joiner 的构造器
     */
    public static class Builder {
        
        protected String prefix = "";
        
        protected String suffix = "";
        
        protected String delimiter = ", ";
        
        protected String emptyString = "";
        
        protected boolean nullable;
        
        Builder() {
        }
        
        public Builder prefix(String prefix) {
            Preconditions.checkNotNull(prefix, "prefix");
            
            this.prefix = prefix;
            
            return this;
        }
        
        public Builder suffix(String suffix) {
            Preconditions.checkNotNull(suffix, "suffix");
            
            this.suffix = suffix;
            
            return this;
        }
        
        public Builder delimiter(String delimiter) {
            Preconditions.checkNotNull(delimiter, "delimiter");
            
            this.delimiter = delimiter;
            
            return this;
        }
        
        public Builder emptyString(String emptyString) {
            Preconditions.checkNotNull(emptyString, "empty string");
            
            this.emptyString = emptyString;
            
            return this;
        }
        
        public Builder nullable(boolean nullable) {
            this.nullable = nullable;
            
            return this;
        }
        
        public Joiner build() {
            return new Joiner(prefix, suffix, delimiter, emptyString, nullable);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    @SuppressWarnings("all")
    public static Joiner newInstance() {
        return builder().build();
    }
    
    public Joiner(String prefix, String suffix, String delimiter, String emptyString, boolean nullable) {
        
        this.prefix = prefix;
        this.suffix = suffix;
        this.delimiter = delimiter;
        this.emptyString = emptyString;
        this.nullable = nullable;
    }
    
    /**
     * 添加一个字符串
     *
     * @param string 字符串
     * @return this
     */
    public Joiner plus(String string) {
        Preconditions.checkArgument(nullable || Objects.nonNull(string), "String isn't nullable, but got null!");
    
        if (stringBuilder.length() != 0) {
            stringBuilder.append(delimiter);
        }
        stringBuilder.append(string);
        
        return this;
    }
    
    /**
     * 添加一个元素
     *
     * @param element  元素
     * @param function 方法
     * @return this
     */
    public <T> Joiner plus(T element, Function<T, String> function) {
        Preconditions.checkArgument(nullable || Objects.nonNull(element), "Element isn't nullable, but got null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        if (stringBuilder.length() != 0) {
            stringBuilder.append(delimiter);
        }
        stringBuilder.append(function.apply(element));
    
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param elements 元素
     * @param function 方法
     * @return this
     */
    public <T> Joiner plusAll(T[] elements, Function<T, String> function) {
        Preconditions.checkNotNull(elements, "Elements are null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        for (T element : elements) {
            plus(element, function);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param elements 元素
     * @return this
     */
    public <T> Joiner plusAll(T[] elements) {
        return plusAll(elements, Objects::toString);
    }
    
    /**
     * 添加若干元素
     *
     * @param chars    元素
     * @param function 方法
     * @return this
     */
    public Joiner plusAll(char[] chars, Function<Character, String> function) {
        Preconditions.checkNotNull(chars, "Chars are null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        for (char element : chars) {
            plus(element, function);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param bytes    元素
     * @param function 方法
     * @return this
     */
    public Joiner plusAll(byte[] bytes, Function<Byte, String> function) {
        Preconditions.checkNotNull(bytes, "Bytes are null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        for (byte element : bytes) {
            plus(element, function);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param booleans 元素
     * @param function 方法
     * @return this
     */
    public Joiner plusAll(boolean[] booleans, Function<Boolean, String> function) {
        Preconditions.checkNotNull(booleans, "Booleans are null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        for (boolean element : booleans) {
            plus(element, function);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param shorts   元素
     * @param function 方法
     * @return this
     */
    public Joiner plusAll(short[] shorts, Function<Short, String> function) {
        Preconditions.checkNotNull(shorts, "Shorts are null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        for (short element : shorts) {
            plus(element, function);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param integers 元素
     * @param function 方法
     * @return this
     */
    public Joiner plusAll(int[] integers, Function<Integer, String> function) {
        Preconditions.checkNotNull(integers, "Integers are null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        for (int element : integers) {
            plus(element, function);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param longs    元素
     * @param function 方法
     * @return this
     */
    public Joiner plusAll(long[] longs, Function<Long, String> function) {
        Preconditions.checkNotNull(longs, "Longs are null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        for (long element : longs) {
            plus(element, function);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param floats   元素
     * @param function 方法
     * @return this
     */
    public Joiner plusAll(float[] floats, Function<Float, String> function) {
        Preconditions.checkNotNull(floats, "Floats are null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        for (float element : floats) {
            plus(element, function);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param doubles  元素
     * @param function 方法
     * @return this
     */
    public Joiner plusAll(double[] doubles, Function<Double, String> function) {
        Preconditions.checkNotNull(doubles, "Doubles are null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        for (double element : doubles) {
            plus(element, function);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param iterable 元素
     * @param function 方法
     * @return this
     */
    public <T> Joiner plusAll(Iterable<T> iterable, Function<T, String> function) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
        Preconditions.checkNotNull(function, "Function is null!");
    
        iterable.forEach(x -> plus(x, function));
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param iterable 元素
     * @return this
     */
    public Joiner plusAll(Iterable<?> iterable) {
        Preconditions.checkNotNull(iterable, "Iterable is null!");
    
        return plusAll(iterable, Objects::toString);
    }
    
    /**
     * 合并结果
     *
     * @param emptyString 内容为空时返回的字符串
     * @return 合并后的结果
     */
    public String join(String emptyString) {
        Preconditions.checkNotNull(emptyString, "Empty string is null!");
    
        if (stringBuilder.length() == 0) {
            return emptyString;
        }
        
        return prefix + stringBuilder + suffix;
    }
    
    /**
     * 合并结果
     *
     * @return 合并后的结果
     */
    public String join() {
        return join(emptyString);
    }
}