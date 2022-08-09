package com.zhz.datastructures.swordfingeroffer.character_string;

/**
 * @author zhouhengzhe
 * @description: 替换空格
 * @since v1
 */
public class JZOffer_05_替换空格 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public String replaceSpace1(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (' '==s.charAt(i)){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        JZOffer_05_替换空格 jZOffer_05=new JZOffer_05_替换空格();
        System.out.println(jZOffer_05.replaceSpace1("We are happy."));
    }
}
