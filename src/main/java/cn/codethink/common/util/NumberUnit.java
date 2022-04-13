package cn.codethink.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 数字单位工具
 *
 * @author Thyme-Chen
 */
@SuppressWarnings("all")
public enum NumberUnit {
    /** 个位 */
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

    /** 十位 */
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

    /** 百位 */
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

    /** 千位 */
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

    /** 百万位 */
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

    /** 十亿位 */
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

    /** 兆位 */
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

    // 单位
    private static final BigDecimal C = BigDecimal.valueOf(1);      // 1
    private static final BigDecimal C0 = BigDecimal.valueOf(10);    // 十
    private static final BigDecimal C1 = C0.multiply(C0);           // 百
    private static final BigDecimal C2 = C1.multiply(C0);           // 千
    private static final BigDecimal C3 = C2.multiply(C2);           // 万
    private static final BigDecimal C4 = C3.multiply(C2);           // 亿
    private static final BigDecimal C5 = C4.multiply(C2);           // 兆

    /** 内部方法 */
    static BigDecimal x(long number, BigDecimal b) {
        return b.multiply(BigDecimal.valueOf(number));
    }

    /**
     * 转为个位
     *
     * @param  number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toNumber(long number);

    /**
     * 转为十位
     *
     * @param  number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toTen(long number);

    /**
     * 转为百位
     *
     * @param  number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toHundred(long number);

    /**
     * 转为千位
     *
     * @param  number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toThousand(long number);

    /**
     * 转为百万位
     *
     * @param  number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toMillion(long number);

    /**
     * 转为十亿位
     *
     * @param  number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toBillion(long number);

    /**
     * 转为兆位
     *
     * @param  number 多少个单位
     * @return 转换后的数字
     */
    public abstract BigDecimal toTrillion(long number);
}
