//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 249 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        //遍历排序
//        int joker_count  = 0;
//        //先排序
//        Arrays.sort(nums);
//        for (int i = 0; i<4; i++){
//            //小丑数量计算
//            if (nums[i] == 0) joker_count++;
//            //如果有重复的数直接返回fasle
//            else if (nums[i] == nums[i+1]) return false;
//        }
//        //最大数减去最小数如果大于4的话就不是顺子
//        if (nums[4]-nums[joker_count] > 4) return false;
//        return true;
        //set方法
        Set<Integer> repeat  = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums){
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) return false;
            repeat.add(num);
        }
        if (max-min > 4) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
