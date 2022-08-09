package com.zhz.datastructures.swordfingeroffer.lookup;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhengzhe
 * @description: 0～n-1中缺失的数字
 * @since v1
 */
public class JZOffer_53_II_0_n_1中缺失的数字 {
    //暴力遍历法
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    //map
    public int missingNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i,nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
           if (i!=map.get(i)){
               return i;
           }
        }
        return nums.length;
    }
}
