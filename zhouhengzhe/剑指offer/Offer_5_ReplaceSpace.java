package com.zhz.SwordOffer;

/**
 * 去掉空格
 */
public class Offer_5_ReplaceSpace {
    /**
     * 方法一：调用jdk的内部方法
     * 替换空格
     * 解释：
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     * @param s 字符串
     * @return 替换空格后的值
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }

    /**
     * 方法二：直接手动写
     * @param s 字符串
     * @return 替换空格后的值
     */
    public String replaceSpace1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        Offer_5_ReplaceSpace offer_5=new Offer_5_ReplaceSpace();
        System.out.println(offer_5.replaceSpace("We are happy."));
        System.out.println(offer_5.replaceSpace1("We are happy."));
    }
}
