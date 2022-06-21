//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 哈希表 矩阵 👍 69 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //用boolean数组去标记是否为0
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        //遍历数组所有数
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                //如果值为0，那么就标记
                if (matrix[i][j] == 0){
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (row[i] || col[j])
                    matrix[i][j] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
