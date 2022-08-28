package cn.codethink.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字工具类
 *
 * @author Chuanwise
 */
@SuppressWarnings("all")
public class Numbers {
    
    private Numbers() {
        Exceptions.throwUtilClassInitializeException(Numbers.class);
    }
    
    private static final Pattern OCT = Pattern.compile("[\\+\\-]?0(?<number>[0-7]+)");
    
    private static final Pattern HEX = Pattern.compile("[\\+\\-]?0[Xx](?<number>[0-9A-Fa-f]+)");
    
    private static final Pattern BIN = Pattern.compile("[\\+\\-]?0[Bb](?<number>[0-1]+)");
    
    private static final Pattern INT = Pattern.compile("[\\+\\-]?(?<number>[0-9]+)");
    
    private static final char[] CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    
    /**
     * 字符串解析为 Integer
     *
     * @param string 字符串
     * @return 如解析成功，返回数字，否则返回 null
     * @throws NullPointerException string 为空串
     */
    @SuppressWarnings("all")
    public static Integer parseInt(String string) {
        Preconditions.objectNonEmpty(string, "empty string");
        
        final String number;
        final int base;
        
        do {
            final Matcher hexMatcher = HEX.matcher(string);
            if (hexMatcher.matches()) {
                number = hexMatcher.group("number");
                base = 16;
                break;
            }
            
            final Matcher octMatcher = OCT.matcher(string);
            if (octMatcher.matches()) {
                number = octMatcher.group("number");
                base = 8;
                break;
            }
            
            final Matcher binMatcher = BIN.matcher(string);
            if (binMatcher.matches()) {
                number = binMatcher.group("number");
                base = 2;
                break;
            }
            
            final Matcher intMatcher = INT.matcher(string);
            if (intMatcher.matches()) {
                number = intMatcher.group("number");
                base = 2;
                break;
            }
            
            return null;
        } while (false);
        
        int value = 0;
        for (int i = 0; i < number.length(); i++) {
            final char ch = number.charAt(i);
            value *= base;
            
            final int chIndex = Arrays.indexOf(CHARS, ch);
            Preconditions.element(chIndex != -1, "不支持的进制：" + base);
            value += chIndex;
        }
        
        return value;
    }
    
    /**
     * 字符串解析为 Long
     *
     * @param string 字符串
     * @return 如解析成功，返回数字，否则返回 null
     */
    @SuppressWarnings("all")
    public static Long parseLong(String string) {
        Preconditions.objectNonEmpty(string, "empty string");
        
        final String number;
        final int base;
        
        do {
            final Matcher hexMatcher = HEX.matcher(string);
            if (hexMatcher.matches()) {
                number = hexMatcher.group("number");
                base = 16;
                break;
            }
            
            final Matcher octMatcher = OCT.matcher(string);
            if (octMatcher.matches()) {
                number = octMatcher.group("number");
                base = 8;
                break;
            }
            
            final Matcher binMatcher = BIN.matcher(string);
            if (binMatcher.matches()) {
                number = binMatcher.group("number");
                base = 2;
                break;
            }
            
            final Matcher intMatcher = INT.matcher(string);
            if (intMatcher.matches()) {
                number = intMatcher.group("number");
                base = 10;
                break;
            }
            
            return null;
        } while (false);
        
        long value = 0;
        for (int i = 0; i < number.length(); i++) {
            final char ch = number.charAt(i);
            value *= base;
            
            final int chIndex = Arrays.indexOf(CHARS, ch);
            Preconditions.element(chIndex != -1, "不支持的进制：" + base);
            value += chIndex;
        }
        
        return value;
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
    
    /**
     * 将 short 数字和抽象数字比较
     *
     * @param value  数字
     * @param number 比较目标
     * @return 数字是否比目标大
     * @throws NullPointerException number 为 null
     */
    public static int compare(short value, Number number) {
        Preconditions.objectNonNull(number, "number");
        
        // big number
        if (number instanceof BigInteger) {
            final BigInteger bigInteger = (BigInteger) number;
            return -bigInteger.compareTo(BigInteger.valueOf(value));
        }
        if (number instanceof BigDecimal) {
            final BigDecimal bigDecimal = (BigDecimal) number;
            return -bigDecimal.compareTo(BigDecimal.valueOf(value));
        }
        
        // generic number
        if (number instanceof GenericNumber) {
            final GenericNumber genericNumber = (GenericNumber) number;
            return -genericNumber.compareTo(GenericNumber.valueOf(value));
        }
        
        // base number
        if (number instanceof Short) {
            return Short.compare(value, number.shortValue());
        }
        if (number instanceof Integer) {
            return Integer.compare(value, number.intValue());
        }
        if (number instanceof Long) {
            return Long.compare(value, number.longValue());
        }
        if (number instanceof Float) {
            return Float.compare(value, number.floatValue());
        }
        if (number instanceof Double) {
            return Double.compare(value, number.doubleValue());
        }
        
        throw new IllegalArgumentException("illegal number class: " + number.getClass().getName());
    }
    
    /**
     * 将 int 数字和抽象数字比较
     *
     * @param value  数字
     * @param number 比较目标
     * @return 数字是否比目标大
     * @throws NullPointerException number 为 null
     */
    public static int compare(int value, Number number) {
        Preconditions.objectNonNull(number, "number");
        
        // big number
        if (number instanceof BigInteger) {
            final BigInteger bigInteger = (BigInteger) number;
            return -bigInteger.compareTo(BigInteger.valueOf(value));
        }
        if (number instanceof BigDecimal) {
            final BigDecimal bigDecimal = (BigDecimal) number;
            return -bigDecimal.compareTo(BigDecimal.valueOf(value));
        }
        
        // generic number
        if (number instanceof GenericNumber) {
            final GenericNumber genericNumber = (GenericNumber) number;
            return -genericNumber.compareTo(GenericNumber.valueOf(value));
        }
        
        // base number
        if (number instanceof Short) {
            return Integer.compare(value, number.shortValue());
        }
        if (number instanceof Integer) {
            return Integer.compare(value, number.intValue());
        }
        if (number instanceof Long) {
            return Long.compare(value, number.longValue());
        }
        if (number instanceof Float) {
            return Float.compare(value, number.floatValue());
        }
        if (number instanceof Double) {
            return Double.compare(value, number.doubleValue());
        }
        
        throw new IllegalArgumentException("illegal number class: " + number.getClass().getName());
    }
    
    /**
     * 将 long 数字和抽象数字比较
     *
     * @param value  数字
     * @param number 比较目标
     * @return 数字是否比目标大
     * @throws NullPointerException number 为 null
     */
    public static int compare(long value, Number number) {
        Preconditions.objectNonNull(number, "number");
        
        // big number
        if (number instanceof BigInteger) {
            final BigInteger bigInteger = (BigInteger) number;
            return -bigInteger.compareTo(BigInteger.valueOf(value));
        }
        if (number instanceof BigDecimal) {
            final BigDecimal bigDecimal = (BigDecimal) number;
            return -bigDecimal.compareTo(BigDecimal.valueOf(value));
        }
        
        // generic number
        if (number instanceof GenericNumber) {
            final GenericNumber genericNumber = (GenericNumber) number;
            return -genericNumber.compareTo(GenericNumber.valueOf(value));
        }
        
        // base number
        if (number instanceof Short) {
            return Long.compare(value, number.shortValue());
        }
        if (number instanceof Integer) {
            return Long.compare(value, number.intValue());
        }
        if (number instanceof Long) {
            return Long.compare(value, number.longValue());
        }
        if (number instanceof Float) {
            return Float.compare(value, number.floatValue());
        }
        if (number instanceof Double) {
            return Double.compare(value, number.doubleValue());
        }
        
        throw new IllegalArgumentException("illegal number class: " + number.getClass().getName());
    }
    
    /**
     * 将 float 数字和抽象数字比较
     *
     * @param value  数字
     * @param number 比较目标
     * @return 数字是否比目标大
     * @throws NullPointerException number 为 null
     */
    public static int compare(float value, Number number) {
        Preconditions.objectNonNull(number, "number");
        
        // big number
        if (number instanceof BigInteger) {
            final BigInteger bigInteger = (BigInteger) number;
    
            final long longValue;
            if (Math.floor(value) == value) {
                longValue = (long) value;
                return -bigInteger.compareTo(BigInteger.valueOf(longValue));
            } else if (value < Long.MAX_VALUE) {
                longValue = (long) value + 1;
                return -bigInteger.compareTo(BigInteger.valueOf(longValue));
            } else {
                return -bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE));
            }
        }
        if (number instanceof BigDecimal) {
            final BigDecimal bigDecimal = (BigDecimal) number;
            return -bigDecimal.compareTo(BigDecimal.valueOf(value));
        }
        
        // generic number
        if (number instanceof GenericNumber) {
            final GenericNumber genericNumber = (GenericNumber) number;
            return -genericNumber.compareTo(GenericNumber.valueOf(value));
        }
        
        // base number
        if (number instanceof Short) {
            return Double.compare(value, number.shortValue());
        }
        if (number instanceof Integer) {
            return Double.compare(value, number.intValue());
        }
        if (number instanceof Long) {
            return Double.compare(value, number.longValue());
        }
        if (number instanceof Float) {
            return Double.compare(value, number.floatValue());
        }
        if (number instanceof Double) {
            return Double.compare(value, number.doubleValue());
        }
        
        throw new IllegalArgumentException("illegal number class: " + number.getClass().getName());
    }
    
    /**
     * 将 double 数字和抽象数字比较
     *
     * @param value  数字
     * @param number 比较目标
     * @return 数字是否比目标大
     * @throws NullPointerException number 为 null
     */
    public static int compare(double value, Number number) {
        Preconditions.objectNonNull(number, "number");
        
        // big number
        if (number instanceof BigInteger) {
            final BigInteger bigInteger = (BigInteger) number;
    
            final long longValue;
            if (Math.floor(value) == value) {
                longValue = (long) value;
                return -bigInteger.compareTo(BigInteger.valueOf(longValue));
            } else if (value < Long.MAX_VALUE) {
                longValue = (long) value + 1;
                return -bigInteger.compareTo(BigInteger.valueOf(longValue));
            } else {
                return -bigInteger.compareTo(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE));
            }
        }
        if (number instanceof BigDecimal) {
            final BigDecimal bigDecimal = (BigDecimal) number;
            return -bigDecimal.compareTo(BigDecimal.valueOf(value));
        }
        
        // generic number
        if (number instanceof GenericNumber) {
            final GenericNumber genericNumber = (GenericNumber) number;
            return -genericNumber.compareTo(GenericNumber.valueOf(value));
        }
        
        // base number
        if (number instanceof Short) {
            return Double.compare(value, number.shortValue());
        }
        if (number instanceof Integer) {
            return Double.compare(value, number.intValue());
        }
        if (number instanceof Long) {
            return Double.compare(value, number.longValue());
        }
        if (number instanceof Float) {
            return Double.compare(value, number.floatValue());
        }
        if (number instanceof Double) {
            return Double.compare(value, number.doubleValue());
        }
        
        throw new IllegalArgumentException("illegal number class: " + number.getClass().getName());
    }
    
    /**
     * 将 BigInteger 数字和抽象数字比较
     *
     * @param value  数字
     * @param number 比较目标
     * @return 数字是否比目标大
     * @throws NullPointerException value 为 null
     * @throws NullPointerException number 为 null
     */
    public static int compare(BigInteger value, Number number) {
        Preconditions.objectNonNull(number, "value");
        Preconditions.objectNonNull(number, "number");
        
        // big number
        if (number instanceof BigInteger) {
            final BigInteger bigInteger = (BigInteger) number;
            return -bigInteger.compareTo(value);
        }
        if (number instanceof BigDecimal) {
            final BigDecimal bigDecimal = (BigDecimal) number;
            
            BigInteger targetBigInteger;
            try {
                targetBigInteger = bigDecimal.toBigIntegerExact();
            } catch (ArithmeticException exception) {
                targetBigInteger = bigDecimal.toBigInteger().add(BigInteger.ONE);
            }
            
            return value.compareTo(targetBigInteger);
        }
        
        // generic number
        if (number instanceof GenericNumber) {
            final GenericNumber genericNumber = (GenericNumber) number;
            return -genericNumber.compareTo(GenericNumber.valueOf(value));
        }
        
        // base number
        if (number instanceof Short) {
            return value.compareTo(BigInteger.valueOf(number.shortValue()));
        }
        if (number instanceof Integer) {
            return value.compareTo(BigInteger.valueOf(number.intValue()));
        }
        if (number instanceof Long) {
            return value.compareTo(BigInteger.valueOf(number.longValue()));
        }
        if (number instanceof Float) {
            
            final long longValue;
            if (number.longValue() == number.floatValue()) {
                longValue = number.longValue();
            } else {
                longValue = number.longValue() + 1;
            }
            return value.compareTo(BigInteger.valueOf(longValue));
        }
        if (number instanceof Double) {
    
            final BigDecimal bigDecimal = BigDecimal.valueOf(number.doubleValue());
    
            BigInteger targetBigInteger;
            try {
                targetBigInteger = bigDecimal.toBigIntegerExact();
            } catch (ArithmeticException exception) {
                targetBigInteger = bigDecimal.toBigInteger().add(BigInteger.ONE);
            }
    
            return value.compareTo(targetBigInteger);
        }
        
        throw new IllegalArgumentException("illegal number class: " + number.getClass().getName());
    }
    
    /**
     * 将 BigDecimal 数字和抽象数字比较
     *
     * @param value  数字
     * @param number 比较目标
     * @return 数字是否比目标大
     * @throws NullPointerException value 为 null
     * @throws NullPointerException number 为 null
     */
    public static int compare(BigDecimal value, Number number) {
        Preconditions.objectNonNull(number, "value");
        Preconditions.objectNonNull(number, "number");
        
        // big number
        if (number instanceof BigInteger) {
            final BigInteger bigInteger = (BigInteger) number;
            return value.compareTo(new BigDecimal(bigInteger));
        }
        if (number instanceof BigDecimal) {
            final BigDecimal bigDecimal = (BigDecimal) number;
            return value.compareTo(bigDecimal);
        }
        
        // generic number
        if (number instanceof GenericNumber) {
            final GenericNumber genericNumber = (GenericNumber) number;
            return -genericNumber.compareTo(GenericNumber.valueOf(value));
        }
        
        // base number
        if (number instanceof Short) {
            return value.compareTo(BigDecimal.valueOf(number.shortValue()));
        }
        if (number instanceof Integer) {
            return value.compareTo(BigDecimal.valueOf(number.intValue()));
        }
        if (number instanceof Long) {
            return value.compareTo(BigDecimal.valueOf(number.longValue()));
        }
        if (number instanceof Float) {
            return value.compareTo(BigDecimal.valueOf(number.floatValue()));
        }
        if (number instanceof Double) {
            return value.compareTo(BigDecimal.valueOf(number.doubleValue()));
        }
        
        throw new IllegalArgumentException("illegal number class: " + number.getClass().getName());
    }
    
    /**
     * 比较抽象数字
     *
     * @param subject 数字
     * @param target  比较目标
     * @return 数字是否比目标大
     * @throws NullPointerException subject 为 null
     * @throws NullPointerException target 为 null
     */
    public static int compare(Number subject, Number target) {
        Preconditions.objectNonNull(subject, "subject");
        Preconditions.objectNonNull(target, "target");
    
        // big number
        if (subject instanceof BigInteger) {
            final BigInteger bigInteger = (BigInteger) subject;
            return compare(bigInteger, target);
        }
        if (subject instanceof BigDecimal) {
            final BigDecimal bigDecimal = (BigDecimal) subject;
            return compare(bigDecimal, target);
        }
    
        // generic number
        if (subject instanceof GenericNumber) {
            final GenericNumber genericNumber = (GenericNumber) subject;
            return genericNumber.compareTo(GenericNumber.valueOf(subject));
        }
    
        // base number
        if (subject instanceof Short) {
            return compare(subject.shortValue(), target);
        }
        if (subject instanceof Integer) {
            return compare(subject.intValue(), target);
        }
        if (subject instanceof Long) {
            return compare(subject.longValue(), target);
        }
        if (subject instanceof Float) {
            return compare(subject.floatValue(), target);
        }
        if (subject instanceof Double) {
            return compare(subject.doubleValue(), target);
        }
    
        throw new IllegalArgumentException("illegal subject number class: " + subject.getClass().getName());
    }
}