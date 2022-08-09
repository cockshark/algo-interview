package com.zhz.datastructures.swordfingeroffer.lookup;

/**
 * @author zhouhengzhe
 * @description: 二维数组中的查找
 * @since v1
 */
public class JZOffer_04_二维数组中的查找 {
    /**
     * 双重遍历法
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int i=matrix.length-1;
        int j=0;
        while (i>=0 &&j < matrix[0].length) {
            if (matrix[i][j]>target){
                i--;
            } else if (matrix[i][j]<target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }
}
