package com.gyf.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
    请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。


    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 */
public class Q48_Solution {

    /**
     * 动态规划：重点是需要维护一个char[j]和第i个字符重复的关系，如果没有重复，则i=-1
     * 动态规划解析：
     * 状态定义： 设动态规划列表 dp ，dp[j] 代表以字符 s[j] 为结尾的 “最长不重复子字符串” 的长度。
     *
     * 转移方程： 固定右边界 j ，设字符 s[j] 左边距离最近的相同字符为 s[i] ，即 s[i] = s[j] 。
     *
     * 1、当 i < 0 ，即 s[j] 左边无相同字符，则 dp[j] = dp[j-1] + 1 ；
     * 2、当 dp[j - 1] < j - i ，说明字符 s[i]在子字符串 dp[j-1] 区间之外 ，则 dp[j] = dp[j - 1] + 1；
     *      解释第2点：先理解dp[j-1]是代表前j-1个字符中，以char[j-1]为结尾的，最长子串长度（即一定要带上j-1这个字符才是子串），dp[j-1]不是前j-1个字符中最长的子串
     *      而j-i是当前字符到达最近的重复字符距离，比如abba，如果j=3,i就是0，此时j-i=3 > dp[j-1]
     *      这说明了当前最长的子串内不含有char[i]这个重复的字符，此例中即当前重复的char[3] == char[0] == a，但是不影响我组ba的子串，所以不能仅用i<0来区分
     * 3、当 dp[j - 1] >= j - i ，说明字符 s[i]在子字符串 dp[j-1] 区间之中 ，则 dp[j] 的左边界由 s[i] 决定，即 dp[j] = j - i；
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int m = 0;
        int i = 0,res = 0;
        for (int j = 0; j < s.length(); j++) {
            i = map.getOrDefault(s.charAt(j), -1);
            if (m < j-i) {
                m = m + 1;
            } else {
                m = j - i;
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, m);
        }
        return res;
    }


    public int lengthOfLongestSubstring2(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }
        int i = -1,res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            // 更新左指针，至少i和s[i+1:j]里的字符串肯定是有重复的，因此只能从i+1开始往后找最大不重复子串
            // 比如说abba，当j=2的时候,i=1，此时s[1]和s[2]重复了。等到j=3时，和a重复的下标为s[0]，即map.get('a') = 0；
            // 但此时i= 1 > 0 ,因此i还是等于1；问题在于为什么取最大的？
            // 因为旧i一定是不满足条件的，是有重复的,新i也是不满足的，区别在于要选择哪个i作为开始的起点，肯定是选两个中最大的一个
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j-i);
        }
        return res;
    }

}
