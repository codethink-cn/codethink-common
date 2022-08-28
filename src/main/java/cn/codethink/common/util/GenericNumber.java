package cn.codethink.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <h1>通用数字</h1>
 *
 * <p>只关心数学值的数字</p>
 *
 * @author Chuanwise
 */
public class GenericNumber
    extends Number
    implements Comparable<GenericNumber> {
    
    public static GenericNumber ONE = new GenericNumber(1);
    
    public static GenericNumber ZERO = new GenericNumber(0);
    
    public static GenericNumber TEN = new GenericNumber(10);
    
    public static GenericNumber valueOf(Number number) {
        return new GenericNumber(number);
    }
    
    private final Number number;
    
    private GenericNumber(Number number) {
        Preconditions.objectNonNull(number, "number");
        
        while (number instanceof GenericNumber) {
            number = ((GenericNumber) number).number;
        }
        this.number = number;
    }
    
    @Override
    public int intValue() {
        return number.intValue();
    }
    
    @Override
    public long longValue() {
        return number.longValue();
    }
    
    @Override
    public float floatValue() {
        return number.floatValue();
    }
    
    @Override
    public double doubleValue() {
        return number.doubleValue();
    }
    
    @Override
    public int compareTo(GenericNumber number) {
        Preconditions.objectNonNull(number, "compilation subject");
    
        return Numbers.compare(this.number, number.number);
    }
}