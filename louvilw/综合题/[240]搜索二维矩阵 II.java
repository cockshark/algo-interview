//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 分治 矩阵 👍 1048 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //假设右上角为x，左边的数都少于x，下边的数都大于x，就有三种情况
        //1.x<target，则x左边的数都小于target，排除一整行
        //2.x>target，则x下边的数都大于target，排除一整列
        //3.x=target，返回true

        if (matrix.length == 0 && matrix[0].length == 0) return false;
        //初始化i=0,j=matrix[0].size()-1，矩阵右上角
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++; //排除行
            else if (matrix[i][j] > target) j--; //排除列
        }
        return false;
//        for (int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix[0].length; j++){
//                if (matrix[i][j] == target)
//                    return true;
//            }
//        }
//        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
