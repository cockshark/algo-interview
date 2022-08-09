package com.zhz.datastructures.swordfingeroffer.lookup;

/**
 * @author zhouhengzhe
 * @description: 旋转数组的最小数字
 * @since v1
 */
public class JZOffer_11_旋转数组的最小数字 {
    /**
     * 暴力法
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    /**
     * 二分法
     *
     * @param numbers
     * @return
     */
    public int minArray1(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int m = i - (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }


}
