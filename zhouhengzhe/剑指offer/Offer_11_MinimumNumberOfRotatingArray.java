package com.zhz.SwordOffer;

/**
 * 旋转数组中的最小数字
 */
public class Offer_11_MinimumNumberOfRotatingArray {
    /**
     * 方法一：暴力遍历法：O(n)
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int res = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                res = numbers[i + 1];
                break;
            }
        }
        return res;
    }

    /**
     * 方法二：二分查找
     */
    public int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }


    public static void main(String[] args) {
        Offer_11_MinimumNumberOfRotatingArray offer_12_minimumNumberOfRotatingArray = new Offer_11_MinimumNumberOfRotatingArray();
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.println(offer_12_minimumNumberOfRotatingArray.minArray(arr));
    }
}
