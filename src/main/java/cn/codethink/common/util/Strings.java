package cn.codethink.util;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author Chuanwise
 */
@SuppressWarnings("all")
public class Strings
        extends StaticUtilities {

    static final Pattern BLANK = Pattern.compile("\\s+");

    /**
     * 判断字符串是否为空
     *
     * @param string 字符串
     * @return 当字符串为 null 或长度为 0 时返回 true
     */
    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
    
    /**
     * 判断字符串是否非空
     *
     * @param string 字符串
     * @return 当字符串不为 null 且长度不为 0 返回 true
     */
    public static boolean nonEmpty(String string) {
        return !isEmpty(string);
    }

    /**
     * 判断字符串是否为空白
     *
     * @param string 字符串
     * @return 当字符串不为空，且全为 ' ' 时返回 true
     */
    public static boolean isBlank(String string) {
        if (!Objects.isNull(string)) {
            return BLANK.matcher(string).matches();
        } else {
            return false;
        }
    }
    
    /**
     * 将一个字符串的内容重复若干次
     *
     * @param string 字符串
     * @param count 重复次数
     * @return 重复后的字符串
     * @throws IllegalArgumentException string 为 null 或 count < 0
     */
    public static String repeat(String string, int count) {
        Preconditions.namedArgumentNonNull(string, "string");
        Preconditions.argument(count >= 0, "count must be bigger than or equals to 0!");
        
        if (count == 0 || string.length() == 0) {
            return "";
        }
        
        final StringBuilder stringBuilder = new StringBuilder(string.length() * count);
        for (int i = 0; i < count; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    /**
     * 计算 2 个字符串的最大公共子序列长度
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 最大公共子序列长度
     */
    public static int maxLongestCommonSubsequenceLength(String str1, String str2) {
        Preconditions.namedArgumentNonNull(str1, "string");
        Preconditions.namedArgumentNonNull(str2, "string");

        int[][] dp = new int[2][str2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
                } else {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }

                maxLength = Math.max(maxLength, dp[i % 2][j]);
            }
        }
        return maxLength;
    }
}
