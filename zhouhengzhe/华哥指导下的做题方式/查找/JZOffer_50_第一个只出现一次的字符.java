package com.zhz.datastructures.swordfingeroffer.lookup;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhengzhe
 * @description: 第一个只出现一次的字符
 * @since v1
 */
public class JZOffer_50_第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        JZOffer_50_第一个只出现一次的字符 o = new JZOffer_50_第一个只出现一次的字符();
        System.out.println(o.firstUniqChar("leetcode"));
    }
}
