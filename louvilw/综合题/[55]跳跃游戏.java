//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 动态规划 👍 1879 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        /*55.跳跃游戏
        1、假设一个起跳点的格子是3，那就代表后面三个格子都可以跳
        2、然后后面三个格子都可以作为起跳点
        3、依次尝试就可以判断是否能跳到最后
         */
        int max_i = 0; //初始化当前能达到最远的位置
        //把所有可以到达的格子全都循环一遍
        for (int i = 0; i <= max_i; i++){
            //如果跳跃后的格子最大跳跃距离大于之前的范围，那就更新
            max_i = Math.max(max_i, i + nums[i]);
            //如果最大跳跃距离大于数组长度，那么返回true
            if (max_i >= nums.length - 1) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
