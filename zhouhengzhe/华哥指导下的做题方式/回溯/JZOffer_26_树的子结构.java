package com.zhz.datastructures.swordfingeroffer.search_backtracking;

import com.zhz.datastructures.commons.TreeNode;

/**
 * @author zhouhengzhe
 * @description: 树的子结构
 * @since v1
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2  2
 * / \ / \
 * 3 4 4 3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2  2
 * \  \
 * 3  3
 */
public class JZOffer_26_树的子结构 {
    /*
     * 参考:数据结构与算法的题解比较好懂
     * 死死记住isSubStructure()的定义:判断B是否为A的子结构
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        // 若A与B其中一个为空,立即返回false
        if (A == null || B == null) {
            return false;
        }

        /*
         * B为A的子结构有3种情况,满足任意一种即可:
         *      1.B的子结构起点为A的根节点,此时结果为recur(A,B)
         *      2.B的子结构起点隐藏在A的左子树中,而不是直接为A的根节点,此时结果为isSubStructure(A.left, B)
         *      3.B的子结构起点隐藏在A的右子树中,此时结果为isSubStructure(A.right, B)
         */
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /*
     * 判断B是否为A的子结构,其中B子结构的起点为A的根节点
     */
    private boolean recur(TreeNode A, TreeNode B) {
        // 若B走完了,说明查找完毕,B为A的子结构
        if (B == null) {
            return true;
        }
        // 若B不为空并且A为空或者A与B的值不相等,直接可以判断B不是A的子结构
        if (A == null || A.val != B.val) {
            return false;
        }
        /* 当A与B当前节点值相等,若要判断B为A的子结构
         * 还需要判断B的左子树是否为A左子树的子结构 && B的右子树是否为A右子树的子结构
         * 若两者都满足就说明B是A的子结构,并且该子结构以A根节点为起点
         */
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
