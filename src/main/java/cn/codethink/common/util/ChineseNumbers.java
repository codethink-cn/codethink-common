package cn.codethink.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 中文数字格式
 *
 * @author ThymeChen
 */
@SuppressWarnings("all")
public class ChineseNumbers
        extends StaticUtilities {
    private static BigDecimal decimal = new BigDecimal("0");

    // 单位，10000的n次方
    private static final BigDecimal MILLION     = new BigDecimal("10000");      // 万
    private static final BigDecimal BILLION     = MILLION.multiply(MILLION);        // 亿
    private static final BigDecimal TRILLION    = BILLION.multiply(MILLION);        // 兆
    private static final BigDecimal JING        = TRILLION.multiply(MILLION);       // 京
    private static final BigDecimal GAI         = JING.multiply(MILLION);           // 垓
    private static final BigDecimal ZI          = GAI.multiply(MILLION);            // 秭
    private static final BigDecimal RANG        = ZI.multiply(MILLION);             // 穰
    private static final BigDecimal GOU         = RANG.multiply(MILLION);           // 沟
    private static final BigDecimal JIAN        = GOU.multiply(MILLION);            // 涧
    private static final BigDecimal ZHENG       = JIAN.multiply(MILLION);           // 正
    private static final BigDecimal ZAI         = ZHENG.multiply(MILLION);          // 载
    private static final BigDecimal JI          = ZAI.multiply(MILLION);            // 极
    private static final BigDecimal HENGHESHA   = JI.multiply(MILLION);             // 恒河沙
    private static final BigDecimal ASENGQI     = HENGHESHA.multiply(MILLION);      // 阿僧祗
    private static final BigDecimal NAYOUTA     = ASENGQI.multiply(MILLION);        // 那由他
    private static final BigDecimal BUKESIYI    = NAYOUTA.multiply(MILLION);        // 不可思议
    private static final BigDecimal WULIANG     = BUKESIYI.multiply(MILLION);       // 无量
    private static final BigDecimal DASHU       = WULIANG.multiply(MILLION);        // 大数

    private static final Pattern UNIT = Pattern.compile("(负|万|萬|亿|兆|京|垓|秭|穰|沟|涧|正|载|极|恒河沙|阿僧祗|那由他|不可思议|无量|大数)");
    
    /**
     * 获取中文数字中所有千位（以 10000 的 n 次方分割）
     *
     * @param number 分割后的 几千几百几十几
     * @param originNumber 原始输入
     * @return int 转换后的3位整数
     * @throws IllegalArgumentException 返回第一个错误的参数
     */
    private static int parseThousand(String number, String originNumber) {
        int num = 0;

        int perNum = 1, count = 1;

        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ignored) {

        }

        String[] strings = number.split("");
        for (String str : strings) {
            switch (str) {
                case "〇":
                case "零":
                case "0": {
                    break;
                }
                case "壹":
                case "一":
                case "1": {
                    if (count == strings.length) {
                        num += 1;
                    }
                    perNum = 1;
                    break;
                }
                case "貳":
                case "兩":
                case "二":
                case "两":
                case "2": {
                    if (count == strings.length) {
                        num += 2;
                    }
                    perNum = 2;
                    break;
                }
                case "叄":
                case "三":
                case "3": {
                    if (count == strings.length) {
                        num += 3;
                    }
                    perNum = 3;
                    break;
                }
                case "肆":
                case "四":
                case "4": {
                    if (count == strings.length) {
                        num += 4;
                    }
                    perNum = 4;
                    break;
                }
                case "伍":
                case "五":
                case "5": {
                    if (count == strings.length) {
                        num += 5;
                    }
                    perNum = 5;
                    break;
                }
                case "陆":
                case "六":
                case "6": {
                    if (count == strings.length) {
                        num += 6;
                    }
                    perNum = 6;
                    break;
                }
                case "柒":
                case "七":
                case "7": {
                    if (count == strings.length) {
                        num += 7;
                    }
                    perNum = 7;
                    break;
                }
                case "捌":
                case "八":
                case "8": {
                    if (count == strings.length) {
                        num += 8;
                    }
                    perNum = 8;
                    break;
                }
                case "玖":
                case "九":
                case "9": {
                    if (count == strings.length) {
                        num += 9;
                    }
                    perNum = 9;
                    break;
                }
                case "拾":
                case "十": {
                    num = num + perNum * 10;
                    break;
                }
                case "佰":
                case "百": {
                    num = num + perNum * 100;
                    break;
                }
                case "仟":
                case "千": {
                    num = num + perNum * 1000;
                    break;
                }
                default: {
                    int in = originNumber.indexOf(str);
                    String s;
                    if (in == 0) {
                        if (originNumber.length() == 1) {
                            s = originNumber.replaceFirst(str, ">" + str + "<");
                        } else {
                            s = originNumber.replaceFirst(str, ">" + str + "< ");
                        }
                    } else {
                        if (in < originNumber.length()) {
                            s = originNumber.replaceFirst(str, " >" + str + "< ");
                        } else {
                            s = originNumber.replaceFirst(str, " >" + str + "<");
                        }
                    }

                    throw new IllegalArgumentException("Illegal argument near index " + (in + 1) + " : \n" + s);
                }
            }
            count += 1;
        }
        return num;
    }

    /**
     * 将所有获取的千位组合为数字
     *
     * @param strings 以万为进制分割而成的数组
     * @param unit    以万为进制分割出的单位
     * @return BigDecimal 组合成的数字
     * @throws IllegalArgumentException 返回第一个错误的参数
     */
    private static BigDecimal parseUnit(String number, String[] strings, List<String> unit) {
        BigDecimal num = BigDecimal.valueOf(0);
        int index = 0;
        for (String str : strings) {
            if (index < unit.size()) {
                switch (unit.get(index)) {
                    case "万":
                    case "萬": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(MILLION);
                        } else {
                            num = num.add(MILLION.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "亿": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(BILLION);
                        } else {
                            num = num.add(BILLION.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "兆": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(TRILLION);
                        } else {
                            num = num.add(TRILLION.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "京": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(JING);
                        } else {
                            num = num.add(JING.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "垓": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(GAI);
                        } else {
                            num = num.add(GAI.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "秭": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(ZI);
                        } else {
                            num = num.add(ZI.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "穰": {
                        if (Strings.isBlank(str))
                            num = num.multiply(RANG);
                        else
                            num = num.add(RANG.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        break;
                    }
                    case "沟": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(GOU);
                        } else {
                            num = num.add(GOU.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "涧": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(JIAN);
                        } else {
                            num = num.add(JIAN.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "正": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(ZHENG);
                        } else {
                            num = num.add(ZHENG.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "载": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(ZAI);
                        } else {
                            num = num.add(ZAI.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "极": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(JI);
                        } else {
                            num = num.add(JI.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "恒河沙": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(HENGHESHA);
                        } else {
                            num = num.add(HENGHESHA.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "阿僧祗": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(ASENGQI);
                        } else {
                            num = num.add(ASENGQI.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "那由他": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(NAYOUTA);
                        } else {
                            num = num.add(NAYOUTA.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "不可思议": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(BUKESIYI);
                        } else {
                            num = num.add(BUKESIYI.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "无量": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(WULIANG);
                        } else {
                            num = num.add(WULIANG.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                    case "大数": {
                        if (Strings.isBlank(str)) {
                            num = num.multiply(DASHU);
                        } else {
                            num = num.add(DASHU.multiply(BigDecimal.valueOf(parseThousand(str, number))));
                        }
                        break;
                    }
                }
            } else {
                num = num.add(BigDecimal.valueOf(parseThousand(str, number)));
            }

            index += 1;
        }
        return num;
    }

    /**
     * 中文数字转 int ，越界或转换失败时返回传入的默认值 defaultValue
     *
     * @param number       中文数字
     * @param defaultValue 默认值
     * @return int 成功时返回转换后的数字，越界时返回传入的默认值 defaultValue
     * @throws IllegalArgumentException 返回第一个错误的参数
     */
    public static int ChineseToInt(String number, int defaultValue) {
        ChineseToNumber(number);
        if (decimal.compareTo(BigDecimal.valueOf(0)) < 0) {
            return decimal.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) < 0 ? defaultValue : decimal.intValue();
        } else {
            return decimal.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0 ? defaultValue : decimal.intValue();
        }
    }

    /**
     * 中文数字转 long ，越界或转换失败时返回传入的默认值 defaultValue
     *
     * @param number       中文数字
     * @param defaultValue 默认值
     * @return long 成功时返回转换后的数字，越界时返回传入的默认值 defaultValue
     * @throws IllegalArgumentException 返回第一个错误的参数
     */
    public static long ChineseToLong(String number, long defaultValue) {
        ChineseToNumber(number);
        if (decimal.compareTo(BigDecimal.valueOf(0)) < 0) {
            return decimal.compareTo(BigDecimal.valueOf(Long.MIN_VALUE)) < 0 ? defaultValue : decimal.longValue();
        } else {
            return decimal.compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0 ? defaultValue : decimal.longValue();
        }
    }

    /**
     * 中文数字转阿拉伯数字，支持无穷大
     *
     * @param number 中文数字
     * @return BigDecimal 转化后的数字
     * @throws IllegalArgumentException 返回第一个错误的参数
     */
    public static BigDecimal ChineseToNumber(String number) {
        Preconditions.namedArgumentNonEmpty(number, "string");

        decimal = BigDecimal.valueOf(0);
        try {
            decimal = new BigDecimal(number);
            return decimal;
        } catch (NumberFormatException ignored) {

        }

        List<String> unit = new ArrayList<>();
        Matcher matcher = UNIT.matcher(number);
        while (matcher.find()) {
            unit.add(matcher.group());
        }
        String[] units = number.split(UNIT.pattern());   // 切割出来的千位

        if (number.length() > 2 && unit.size() > 1) {
            if (unit.get(unit.size() - 1).matches(UNIT.pattern())
                    && unit.get(unit.size() - 2).matches(UNIT.pattern())) {
                decimal = parseUnit(number, units, unit);

                // 多单位处理
                ListIterator<String> iterator = unit.listIterator();
                int i = 1;
                // 逆序遍历
                while (iterator.hasNext())
                    iterator.next();
                while (iterator.hasPrevious() && i <= unit.size() - units.length) {
                    switch (iterator.previous()) {
                        case "万":
                        case "萬":
                            decimal = decimal.multiply(MILLION);
                            break;
                        case "亿":
                            decimal = decimal.multiply(BILLION);
                            break;
                        case "兆":
                            decimal = decimal.multiply(TRILLION);
                            break;
                        case "京":
                            decimal = decimal.multiply(JING);
                            break;
                        case "垓":
                            decimal = decimal.multiply(GAI);
                            break;
                        case "秭":
                            decimal = decimal.multiply(ZI);
                            break;
                        case "穰":
                            decimal = decimal.multiply(RANG);
                            break;
                        case "沟":
                            decimal = decimal.multiply(GOU);
                            break;
                        case "涧":
                            decimal = decimal.multiply(JIAN);
                            break;
                        case "正":
                            decimal = decimal.multiply(ZHENG);
                            break;
                        case "载":
                            decimal = decimal.multiply(ZAI);
                            break;
                        case "极":
                            decimal = decimal.multiply(JI);
                            break;
                        case "恒河沙":
                            decimal = decimal.multiply(HENGHESHA);
                            break;
                        case "阿僧祗":
                            decimal = decimal.multiply(ASENGQI);
                            break;
                        case "那由他":
                            decimal = decimal.multiply(NAYOUTA);
                            break;
                        case "不可思议":
                            decimal = decimal.multiply(BUKESIYI);
                            break;
                        case "无量":
                            decimal = decimal.multiply(WULIANG);
                            break;
                        case "大数":
                            decimal = decimal.multiply(DASHU);
                            break;
                    }
                    i += 1;
                }
            } else {
                decimal = parseUnit(number, units, unit);
            }
        } else {
            decimal = parseUnit(number, units, unit);
        }

        long unitCount = unit.stream().filter(s -> s.equals("负")).count();
        return (unitCount % 2 == 1) ? decimal = decimal.multiply(new BigDecimal("-1")) : decimal;
    }
}
