//珠玑妙算游戏（the game of master mind）的玩法如下。 
// 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽
//4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
//注意，“猜中”不能算入“伪猜中”。 
// 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[
//1]为伪猜中的次数。 
// 示例： 
// 输入： solution="RGBY",guess="GGRR"
//输出： [1,1]
//解释： 猜中1次，伪猜中1次。
// 
// 提示： 
// 
// len(solution) = len(guess) = 4 
// solution和guess仅包含"R","G","B","Y"这4种字符 
// 
// Related Topics 哈希表 字符串 计数 👍 36 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] masterMind(String solution, String guess) {
        int right = 0, rightall = 0, j = 0;
        //把正确答案存到StringBuilder
        StringBuilder sb = new StringBuilder(solution);
        for (int i = 0; i < solution.length(); i++){
            if (solution.charAt(i)==guess.charAt(i)) right++; //如果guess和solution相等那就是猜对+1
            j = sb.indexOf(String.valueOf(guess.charAt(i))); //找到guess中每个颜色在solution中出现的位置，没出现则为-1
            if (j != -1) {
                rightall++;
                sb.setCharAt(j,'0'); //用其他字符取代，免得重复计算
            }
        }
        return new int[]{right,rightall-right}; //伪猜对等于总猜对-猜对
    }
}
//leetcode submit region end(Prohibit modification and deletion)
