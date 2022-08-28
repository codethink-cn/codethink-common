package cn.codethink.common.test;

import cn.codethink.common.util.GenericNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

@SuppressWarnings("all")
public class GenericNumberTest {
    
    @Test
    void testShort() {
    
        short value = 10, plusOne = (short) (value + 1), minusOne = (short) (value - 1);
        final GenericNumber one = GenericNumber.valueOf(value);
    
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((int) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((long) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((float) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((double) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf(value))));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(value))));
    
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((int) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((long) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((float) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((double) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf(minusOne))));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(minusOne))));
        
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((int) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((long) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((float) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((double) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf(plusOne))));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(plusOne))));
    }
    
    @Test
    void testInt() {
    
        int value = 10, plusOne = value + 1, minusOne = value - 1;
        final GenericNumber one = GenericNumber.valueOf(value);
    
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((int) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((long) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((float) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((double) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf(value))));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(value))));
    
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((int) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((long) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((float) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((double) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf(minusOne))));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(minusOne))));
        
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((int) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((long) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((float) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((double) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf(plusOne))));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(plusOne))));
    }
    
    @Test
    void testLong() {
    
        long value = 10, plusOne = value + 1, minusOne = value - 1;
        final GenericNumber one = GenericNumber.valueOf(value);
    
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((int) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((long) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((float) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((double) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf(value))));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(value))));
    
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((int) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((long) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((float) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((double) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf(minusOne))));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(minusOne))));
        
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((int) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((long) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((float) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((double) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf(plusOne))));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(plusOne))));
    }
    
    @Test
    void testFloat() {
    
        float value = 10, plusOne = value + 1, minusOne = value - 1;
        final GenericNumber one = GenericNumber.valueOf(value);
    
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((int) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((long) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((float) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((double) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf((long) value))));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(value))));
    
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((int) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((long) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((float) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((double) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf((long) minusOne))));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(minusOne))));
        
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((int) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((long) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((float) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((double) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf((long) plusOne))));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(plusOne))));
    }
    
    @Test
    void testDouble() {
    
        double value = 10, plusOne = value + 1, minusOne = value - 1;
        final GenericNumber one = GenericNumber.valueOf(value);
    
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((int) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((long) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((float) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf((double) value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf((long) value))));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(value))));
    
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((int) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((long) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((float) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf((double) minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf((long) minusOne))));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(minusOne))));
        
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((int) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((long) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((float) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf((double) plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigInteger.valueOf((long) plusOne))));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(BigDecimal.valueOf(plusOne))));
    }
    
    @Test
    void testBigInteger() {
    
        final BigInteger value = BigInteger.TEN, plusOne = value.add(BigInteger.ONE), minusOne = value.min(BigInteger.ONE);
        final GenericNumber one = GenericNumber.valueOf(value);
    
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value.intValue())));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value.longValue())));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value.floatValue())));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value.doubleValue())));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value)));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(new BigDecimal(value))));
    
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne.intValue())));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne.longValue())));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne.floatValue())));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne.doubleValue())));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne)));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(new BigDecimal(plusOne))));
        
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne.intValue())));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne.longValue())));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne.floatValue())));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne.doubleValue())));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne)));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(new BigDecimal(minusOne))));
    }
    
    @Test
    void testBigDecimal() {
    
        final BigDecimal value = BigDecimal.TEN, plusOne = value.add(BigDecimal.ONE), minusOne = value.min(BigDecimal.ONE);
        final GenericNumber one = GenericNumber.valueOf(value);
    
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value.intValue())));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value.longValue())));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value.floatValue())));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value.doubleValue())));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value.toBigInteger())));
        Assertions.assertEquals(0, one.compareTo(GenericNumber.valueOf(value)));
    
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne.intValue())));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne.longValue())));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne.floatValue())));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne.doubleValue())));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne.toBigInteger())));
        Assertions.assertEquals(-1, one.compareTo(GenericNumber.valueOf(plusOne)));
        
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne.intValue())));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne.longValue())));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne.floatValue())));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne.doubleValue())));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne.toBigInteger())));
        Assertions.assertEquals(1, one.compareTo(GenericNumber.valueOf(minusOne)));
    }
}
