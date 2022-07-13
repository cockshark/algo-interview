package com.zhz.SwordOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 限制：
 *
 * @author zhouhengzhe
 */
public class Offer_3_FindRepeatNumber {
    /**
     * 找出数组中重复的数字
     *
     * @param nums 要找重的数组
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        //去重优先选择hashset
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        throw new RuntimeException("无重复数字");
    }
}
