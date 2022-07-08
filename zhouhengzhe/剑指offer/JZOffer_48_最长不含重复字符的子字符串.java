package com.zhz.SwordOffer;

import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 */
public class JZOffer_48_最长不含重复字符的子字符串 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left=-1;
        int res=0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))){
                left=Math.max(map.get(s.charAt(right)),left);
            }
            map.put(s.charAt(right),right);
            res=Math.max(res,right-left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(JZOffer_48_最长不含重复字符的子字符串.lengthOfLongestSubstring("bbbbbs"));
    }
}
