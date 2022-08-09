package com.zhz.datastructures.swordfingeroffer.dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author zhouhengzhe
 * @description: 最长不含重复字符的子字符串
 * @since v1
 */
public class JZOffer_48_最长不含重复字符的子字符串 {
    /**
     * 双指针 + 哈希表
     * <p>
     * 哈希表 dic 统计： 指针 j 遍历字符 s ，哈希表统计字符 s[j]最后一次出现的索引 。
     * 更新左指针 i ： 根据上轮左指针 i 和 dic[s[j]] ，每轮更新左边界 i ，保证区间 [i + 1, j] 内无重复字符且最大。
     * i = max(dic[s[j]], i)
     * <p>
     * 更新结果 res ： 取上轮 res 和本轮双指针区间 [i + 1,j]的宽度（即 j - i）中的最大值。
     * res = max(res, j - i)
     * <p>
     * 复杂度分析：
     * 时间复杂度 O(N) ： 其中 NN 为字符串长度，动态规划需遍历计算 dp 列表。
     * 空间复杂度 O(1) ： 字符的 ASCII 码范围为 0 ~ 127 ，哈希表 dic 最多使用 O(128) = O(1) 大小的额外空间
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                // // 更新左指针 i
                i=Math.max(i,map.get(s.charAt(j)));
            }
            // 哈希表记录
            map.put(s.charAt(j), j);
            //
            res = Math.max(res, j - i);

        }
        return 1;
    }

    public static void main(String[] args) {
        int i = JZOffer_48_最长不含重复字符的子字符串.lengthOfLongestSubstring("");
    }
}
