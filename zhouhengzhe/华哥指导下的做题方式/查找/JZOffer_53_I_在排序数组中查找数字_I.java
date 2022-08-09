package com.zhz.datastructures.swordfingeroffer.lookup;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhengzhe
 * @description: 在排序数组中查找数字 I
 * @since v1
 */
public class JZOffer_53_I_在排序数组中查找数字_I {
    /**
     * map遍历
     * @param nums   数组
     * @param target 目标数字
     * @return 在排序数组中查找数字的出现次数
     */
    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map.get(target) == null ? 0 : map.get(target);
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        return helper(nums,target)-helper(nums,target-1);
    }

    private int helper (int[] nums, int tar) {
        int left= 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= tar) left = mid + 1;
            else right = mid-1;
        }
        return left;
    }
}
