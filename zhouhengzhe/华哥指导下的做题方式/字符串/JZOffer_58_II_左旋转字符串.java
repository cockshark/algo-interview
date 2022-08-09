package com.zhz.datastructures.swordfingeroffer.character_string;

/**
 * @author zhouhengzhe
 * @description: todo
 * @since v1
 */
public class JZOffer_58_II_左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        JZOffer_58_II_左旋转字符串 other = new JZOffer_58_II_左旋转字符串();
        System.out.println(other.reverseLeftWords("abcdefg", 2));
    }
}
