//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 1118 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res; //如果数组为空，则返回结果
        //上下左右赋值
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true){
            for (int i = left; i <= right; i++) res.add(matrix[up][i]); //向右移动到最右
            if (++up > down) break; //重新设定上边界，若上边界大于下边界，则遍历完成
            for (int i = up; i <= down; i++) res.add(matrix[i][right]); //向下移动到最后
            if (--right < left) break; //重新设定右边界，若右边界小于左边界，则遍历完成
            for (int i = right; i >= left; i--) res.add(matrix[down][i]); //向左移动到最后
            if (--down < up) break; //重新设定下边界，若下边界小于上边界，则遍历完成
            for (int i = down; i >= up; i--) res.add(matrix[i][left]); //向上遍历到最后
            if (++left > right) break; //重新设定左边界，若左边界大于右边界，则遍历完成
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
