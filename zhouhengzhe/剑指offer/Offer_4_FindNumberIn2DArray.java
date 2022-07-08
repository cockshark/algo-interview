package com.zhz.SwordOffer;

/**
 * 二维数组中的查找
 */
public class Offer_4_FindNumberIn2DArray {
    /**
     * 方法一：暴力破解
     *
     * @param matrix 多维数组
     * @param target 目标值
     * @return true or false
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 二分法
     *
     * @param matrix 多维数组
     * @param target 目标值
     * @return true or false
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            }else if (matrix[i][j]<target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Offer_4_FindNumberIn2DArray findNumberIn2DArray = new Offer_4_FindNumberIn2DArray();
        int[][] arr = new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(arr, 25));
        System.out.println(findNumberIn2DArray.findNumberIn2DArray1(arr, 25));
    }
}
