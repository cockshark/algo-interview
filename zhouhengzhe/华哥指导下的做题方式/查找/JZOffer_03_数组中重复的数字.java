package com.zhz.datastructures.swordfingeroffer.lookup;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouhengzhe
 * @description: 数组中重复的数字
 * @since v1
 */
public class JZOffer_03_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }
}
