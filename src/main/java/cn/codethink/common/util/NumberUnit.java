package cn.codethink.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 数字单位工具
 *
 * @author Thyme-Chen
 */
@SuppressWarnings("unused")
public enum NumberUnit {
    /**
     * 个位
     */
    NUMBER {
        public BigDecimal toNumber(long number) {
            return BigDecimal.valueOf(number);
        }
    
        public BigDecimal toTen(long number) {
            return BigDecimal.valueOf(number).divide(C0.divide(C, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    
        public BigDecimal toHundred(long number) {
            return BigDecimal.valueOf(number).divide(C1.divide(C, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    
        public BigDecimal toThousand(long number) {
            return BigDecimal.valueOf(number).divide(C2.divide(C, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    
        public BigDecimal toMillion(long number) {
            return BigDecimal.valueOf(number).divide(C3.divide(C, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    
        public BigDecimal toBillion(long number) {
            return BigDecimal.valueOf(number).divide(C4.divide(C, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    
        public BigDecimal toTrillion(long number) {
            return BigDecimal.valueOf(number).divide(C5.divide(C, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    },
    
    /**
     * 十位
     */
    TEN {
        public BigDecimal toNumber(long number) {
            return x(number, C0.divide(C, RoundingMode.DOWN));
        }
        
        public BigDecimal toTen(long number) {
            return BigDecimal.valueOf(number);
        }
        
        public BigDecimal toHundred(long number) {
            return BigDecimal.valueOf(number).divide(C1.divide(C0, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toThousand(long number) {
            return BigDecimal.valueOf(number).divide(C2.divide(C0, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toMillion(long number) {
            return BigDecimal.valueOf(number).divide(C3.divide(C0, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toBillion(long number) {
            return BigDecimal.valueOf(number).divide(C4.divide(C0, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toTrillion(long number) {
            return BigDecimal.valueOf(number).divide(C5.divide(C0, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    },
    
    /**
     * 百位
     */
    HUNDRED {
        public BigDecimal toNumber(long number) {
            return x(number, C1.divide(C, RoundingMode.DOWN));
        }
        
        public BigDecimal toTen(long number) {
            return x(number, C1.divide(C0, RoundingMode.DOWN));
        }
        
        public BigDecimal toHundred(long number) {
            return BigDecimal.valueOf(number);
        }
        
        public BigDecimal toThousand(long number) {
            return BigDecimal.valueOf(number).divide(C2.divide(C1, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toMillion(long number) {
            return BigDecimal.valueOf(number).divide(C3.divide(C1, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toBillion(long number) {
            return BigDecimal.valueOf(number).divide(C4.divide(C1, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toTrillion(long number) {
            return BigDecimal.valueOf(number).divide(C5.divide(C1, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    },
    
    /**
     * 千位
     */
    THOUSAND {
        public BigDecimal toNumber(long number) {
            return x(number, C2.divide(C, RoundingMode.DOWN));
        }
        
        public BigDecimal toTen(long number) {
            return x(number, C2.divide(C0, RoundingMode.DOWN));
        }
        
        public BigDecimal toHundred(long number) {
            return x(number, C2.divide(C1, RoundingMode.DOWN));
        }
        
        public BigDecimal toThousand(long number) {
            return BigDecimal.valueOf(number);
        }
        
        public BigDecimal toMillion(long number) {
            return BigDecimal.valueOf(number).divide(C3.divide(C2, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toBillion(long number) {
            return BigDecimal.valueOf(number).divide(C4.divide(C2, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toTrillion(long number) {
            return BigDecimal.valueOf(number).divide(C5.divide(C2, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    },
    
    /**
     * 百万位
     */
    MILLION {
        public BigDecimal toNumber(long number) {
            return x(number, C3.divide(C, RoundingMode.DOWN));
        }
        
        public BigDecimal toTen(long number) {
            return x(number, C3.divide(C0, RoundingMode.DOWN));
        }
        
        public BigDecimal toHundred(long number) {
            return x(number, C3.divide(C1, RoundingMode.DOWN));
        }
        
        public BigDecimal toThousand(long number) {
            return x(number, C3.divide(C2, RoundingMode.DOWN));
        }
        
        public BigDecimal toMillion(long number) {
            return BigDecimal.valueOf(number);
        }
        
        public BigDecimal toBillion(long number) {
            return BigDecimal.valueOf(number).divide(C4.divide(C3, RoundingMode.DOWN), RoundingMode.DOWN);
        }
        
        public BigDecimal toTrillion(long number) {
            return BigDecimal.valueOf(number).divide(C5.divide(C3, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    },
    
    /**
     * 十亿位
     */
    BILLION {
        public BigDecimal toNumber(long number) {
            return x(number, C4.divide(C, RoundingMode.DOWN));
        }
        
        public BigDecimal toTen(long number) {
            return x(number, C4.divide(C0, RoundingMode.DOWN));
        }
        
        public BigDecimal toHundred(long number) {
            return x(number, C4.divide(C1, RoundingMode.DOWN));
        }
        
        public BigDecimal toThousand(long number) {
            return x(number, C4.divide(C2, RoundingMode.DOWN));
        }
        
        public BigDecimal toMillion(long number) {
            return x(number, C4.divide(C3, RoundingMode.DOWN));
        }
        
        public BigDecimal toBillion(long number) {
            return BigDecimal.valueOf(number);
        }
        
        public BigDecimal toTrillion(long number) {
            return BigDecimal.valueOf(number).divide(C5.divide(C4, RoundingMode.DOWN), RoundingMode.DOWN);
        }
    },
    
    /**
     * 兆位
     */
    TRILLION {
        public BigDecimal toNumber(long number) {
            return x(number, C5.divide(C, RoundingMode.DOWN));
        }
        
        public BigDecimal toTen(long number) {
            return x(number, C5.divide(C0, RoundingMode.DOWN));
        }
        
        public BigDecimal toHundred(long number) {
            return x(number, C5.divide(C1, RoundingMode.DOWN));
        }
        
        public BigDecimal toThousand(long number) {
            return x(number, C5.divide(C2, RoundingMode.DOWN));
        }
        
        public BigDecimal toMillion(long number) {
            return x(number, C5.divide(C3, RoundingMode.DOWN));
        }
        
        public BigDecimal toBillion(long number) {
            return x(number, C5.divide(C4, RoundingMode.DOWN));
        }
        
        public BigDecimal toTrillion(long number) {
            return BigDecimal.valueOf(number);
        }
    };
/*
    JING {
        public BigDecimal toTen(long d) {
            return C6.multiply(BigDecimal.valueOf(d));
        }
    },

    GAI {
        public BigDecimal toTen(long d) {
            return C7.multiply(BigDecimal.valueOf(d));
        }
    },

    ZI {
        public BigDecimal toTen(long d) {
            return C8.multiply(BigDecimal.valueOf(d));
        }
    },

    RANG {
        public BigDecimal toTen(long d) {
            return C9.multiply(BigDecimal.valueOf(d));
        }
    },

    GOU {
        public BigDecimal toTen(long d) {
            return C10.multiply(BigDecimal.valueOf(d));
        }
    },

    JIAN {
        public BigDecimal toTen(long d) {
            return C11.multiply(BigDecimal.valueOf(d));
        }
    },

    ZHENG {
        public BigDecimal toTen(long d) {
            return C12.multiply(BigDecimal.valueOf(d));
        }
    },

    ZAI {
        public BigDecimal toTen(long d) {
            return C13.multiply(BigDecimal.valueOf(d));
        }
    },

    JI {
        public BigDecimal toTen(long d) {
            return C14.multiply(BigDecimal.valueOf(d));
        }
    },

    HENGHESHA {
        public BigDecimal toTen(long d) {
            return C15.multiply(BigDecimal.valueOf(d));
        }
    },

    ASENGQI {
        public BigDecimal toTen(long d) {
            return C16.multiply(BigDecimal.valueOf(d));
        }
    },

    NAYOUTA {
        public BigDecimal toTen(long d) {
            return C17.multiply(BigDecimal.valueOf(d));
        }
    },

    BUKESIYI {
        public BigDecimal toTen(long d) {
            return C18.multiply(BigDecimal.valueOf(d));
        }
    },

    WULIANG {
        public BigDecimal toTen(long d) {
            return C19.multiply(BigDecimal.valueOf(d));
        }
    },

    DASHU {
        public BigDecimal toTen(long d) {
            return C20.multiply(BigDecimal.valueOf(d));
        }
    };
*/
    
    // 单位
    private static final BigDecimal C = BigDecimal.valueOf(1);      // 1
    private static final BigDecimal C0 = BigDecimal.valueOf(10);    // 十
    private static final BigDecimal C1 = C0.multiply(C0);           // 百
    private static final BigDecimal C2 = C1.multiply(C0);           // 千
    private static final BigDecimal C3 = C2.multiply(C2);           // 万
    private static final BigDecimal C4 = C3.multiply(C2);           // 亿
    private static final BigDecimal C5 = C4.multiply(C2);           // 兆
    
/*
    private static final BigDecimal C6 = C5.multiply(C3);           // 京
    private static final BigDecimal C7 = C6.multiply(C3);           // 垓
    private static final BigDecimal C8 = C7.multiply(C3);           // 秭
    private static final BigDecimal C9 = C8.multiply(C3);           // 穰
    private static final BigDecimal C10 = C9.multiply(C3);          // 沟
    private static final BigDecimal C11 = C10.multiply(C3);         // 涧
    private static final BigDecimal C12 = C11.multiply(C3);         // 正
    private static final BigDecimal C13 = C12.multiply(C3);         // 载
    private static final BigDecimal C14 = C13.multiply(C3);         // 极
    private static final BigDecimal C15 = C14.multiply(C3);         // 恒河沙
    private static final BigDecimal C16 = C15.multiply(C3);         // 阿僧祗
    private static final BigDecimal C17 = C16.multiply(C3);         // 那由他
    private static final BigDecimal C18 = C17.multiply(C3);         // 不可思议
    private static final BigDecimal C19 = C18.multiply(C3);         // 无量
    private static final BigDecimal C20 = C19.multiply(C3);         // 大数
*/
    
    /**
     * 内部方法
     */
    static BigDecimal x(long number, BigDecimal b) {
        return b.multiply(BigDecimal.valueOf(number));
    }
    
    /**
     * 转为个位
     *
     * @param number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toNumber(long number);
    
    /**
     * 转为十位
     *
     * @param number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toTen(long number);
    
    /**
     * 转为百位
     *
     * @param number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toHundred(long number);
    
    /**
     * 转为千位
     *
     * @param number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toThousand(long number);
    
    /**
     * 转为百万位
     *
     * @param number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toMillion(long number);
    
    /**
     * 转为十亿位
     *
     * @param number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toBillion(long number);
    
    /**
     * 转为兆位
     *
     * @param number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toTrillion(long number);
}