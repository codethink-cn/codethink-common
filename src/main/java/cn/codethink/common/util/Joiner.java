package cn.codethink.common.util;

import java.util.Objects;
import java.util.function.Function;

/**
 * 用于拼接字符串的 joiner
 *
 * @author Chuanwise
 */
public class Joiner {
    
    protected String prefix;
    
    protected String suffix;
    
    protected String delimiter;
    
    protected String emptyString;
    
    protected StringBuilder stringBuilder = new StringBuilder();
    
    protected boolean nullable;
    
    public static Builder builder() {
        return new Builder();
    }
    
    @SuppressWarnings("all")
    public static Joiner newInstance() {
        return builder().build();
    }
    
    public Joiner(String prefix,
                  String suffix,
                  String delimiter,
                  String emptyString,
                  boolean nullable) {
        
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
     * @throws IllegalArgumentException nullable 为 false 且 string 为 null 或空串
     */
    public Joiner plus(String string) {
        Preconditions.argument(nullable || Strings.nonEmpty(string), "string");
    
        if (stringBuilder.length() != 0) {
            stringBuilder.append(delimiter);
        }
        stringBuilder.append(string);
        
        return this;
    }
    
    /**
     * 添加一个元素
     *
     * @param element    元素
     * @param serializer 序列化器
     * @return this
     */
    public <T> Joiner plus(T element, Function<T, String> serializer) {
        Preconditions.argument(nullable || Objects.nonNull(element), "string");
        Preconditions.objectNonNull(serializer, "serializer");
    
        if (stringBuilder.length() != 0) {
            stringBuilder.append(delimiter);
        }
        stringBuilder.append(serializer.apply(element));
    
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param elements   元素
     * @param serializer 序列化器
     * @return this
     */
    public <T> Joiner plusAll(T[] elements, Function<T, String> serializer) {
        Preconditions.objectNonNull(elements, "strings");
        Preconditions.objectNonNull(serializer, "serializer");
    
        for (T element : elements) {
            plus(element, serializer);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param elements 元素
     * @return this
     * @throws NullPointerException elements 为 null
     */
    public <T> Joiner plusAll(T[] elements) {
        return plusAll(elements, Objects::toString);
    }
    
    /**
     * 添加若干元素
     *
     * @param strings    元素
     * @param serializer 序列化器
     * @return this
     * @throws NullPointerException elements 为 null
     * @throws NullPointerException serializer 为 null
     */
    public Joiner plusAll(char[] strings, Function<Character, String> serializer) {
        Preconditions.objectNonNull(strings, "strings");
        Preconditions.objectNonNull(serializer, "serializer");
    
        for (char element : strings) {
            plus(element, serializer);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param bytes      元素
     * @param serializer 序列化器
     * @return this
     * @throws NullPointerException bytes 为 null
     * @throws NullPointerException serializer 为 null
     */
    public Joiner plusAll(byte[] bytes, Function<Byte, String> serializer) {
        Preconditions.objectNonNull(bytes, "bytes");
        Preconditions.objectNonNull(serializer, "serializer");
    
        for (byte element : bytes) {
            plus(element, serializer);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param booleans   元素
     * @param serializer 序列化器
     * @return this
     * @throws NullPointerException booleans 为 null
     * @throws NullPointerException serializer 为 null
     */
    public Joiner plusAll(boolean[] booleans, Function<Boolean, String> serializer) {
        Preconditions.objectNonNull(booleans, "booleans");
        Preconditions.objectNonNull(serializer, "serializer");
    
        for (boolean element : booleans) {
            plus(element, serializer);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param shorts     元素
     * @param serializer 序列化器
     * @return this
     * @throws NullPointerException shorts 为 null
     * @throws NullPointerException serializer 为 null
     */
    public Joiner plusAll(short[] shorts, Function<Short, String> serializer) {
        Preconditions.objectNonNull(shorts, "shorts");
        Preconditions.objectNonNull(serializer, "serializer");
    
        for (short element : shorts) {
            plus(element, serializer);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param ints       元素
     * @param serializer 序列化器
     * @return this
     * @throws NullPointerException ints 为 null
     * @throws NullPointerException serializer 为 null
     */
    public Joiner plusAll(int[] ints, Function<Integer, String> serializer) {
        Preconditions.objectNonNull(ints, "ints");
        Preconditions.objectNonNull(serializer, "serializer");
    
        for (int element : ints) {
            plus(element, serializer);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param longs      元素
     * @param serializer 序列化器
     * @return this
     * @throws NullPointerException longs 为 null
     * @throws NullPointerException serializer 为 null
     */
    public Joiner plusAll(long[] longs, Function<Long, String> serializer) {
        Preconditions.objectNonNull(longs, "longs");
        Preconditions.objectNonNull(serializer, "serializer");
    
        for (long element : longs) {
            plus(element, serializer);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param floats     元素
     * @param serializer 序列化器
     * @return this
     * @throws NullPointerException floats 为 null
     * @throws NullPointerException serializer 为 null
     */
    public Joiner plusAll(float[] floats, Function<Float, String> serializer) {
        Preconditions.objectNonNull(floats, "floats");
        Preconditions.objectNonNull(serializer, "serializer");
    
        for (float element : floats) {
            plus(element, serializer);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param strings    元素
     * @param serializer 序列化器
     * @return this
     * @throws NullPointerException strings 为 null
     * @throws NullPointerException serializer 为 null
     */
    public Joiner plusAll(double[] strings, Function<Double, String> serializer) {
        Preconditions.objectNonNull(strings, "strings");
        Preconditions.objectNonNull(serializer, "serializer");
    
        for (double element : strings) {
            plus(element, serializer);
        }
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param iterable   元素
     * @param serializer 序列化器
     * @return this
     * @throws NullPointerException iterable 为 null
     * @throws NullPointerException serializer 为 null
     */
    public <T> Joiner plusAll(Iterable<T> iterable, Function<T, String> serializer) {
        Preconditions.objectNonNull(iterable, "iterable");
        Preconditions.objectNonNull(serializer, "serializer");
    
        iterable.forEach(x -> plus(x, serializer));
        return this;
    }
    
    /**
     * 添加若干元素
     *
     * @param iterable 元素
     * @return this
     */
    public Joiner plusAll(Iterable<?> iterable) {
        Preconditions.objectNonNull(iterable, "iterable");
    
        return plusAll(iterable, Objects::toString);
    }
    
    /**
     * 合并结果
     *
     * @param emptyString 内容为空时返回的字符串
     * @return 合并后的结果
     * @throws NullPointerException emptyString 为 null
     */
    public String join(String emptyString) {
        Preconditions.objectNonNull(emptyString, "empty string");
    
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
    
    /**
     * Joiner 的构造器
     *
     * @author Chuanwise
     * @see Joiner
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
            Preconditions.objectNonNull(prefix, "prefix");
            
            this.prefix = prefix;
            
            return this;
        }
        
        public Builder suffix(String suffix) {
            Preconditions.objectNonNull(suffix, "suffix");
            
            this.suffix = suffix;
            
            return this;
        }
        
        public Builder delimiter(String delimiter) {
            Preconditions.objectNonNull(delimiter, "delimiter");
            
            this.delimiter = delimiter;
            
            return this;
        }
        
        public Builder emptyString(String emptyString) {
            Preconditions.objectNonNull(emptyString, "empty string");
            
            this.emptyString = emptyString;
            
            return this;
        }
        
        public Builder nullable() {
            this.nullable = true;
            
            return this;
        }
        
        public Builder nonNull() {
            this.nullable = false;
            
            return this;
        }
        
        public Joiner build() {
            return new Joiner(
                prefix,
                suffix,
                delimiter,
                emptyString,
                nullable
            );
        }
    }
}