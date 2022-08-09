package com.zhz.datastructures.swordfingeroffer.search_backtracking;

import com.zhz.datastructures.commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhouhengzhe
 * @description: 从上到下打印二叉树
 * @since v1
 */
public class JZOffer_32_I_从上到下打印二叉树 {
    /**
     * 利用队列+集合的优越性实现
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            res.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return res.stream().mapToInt(Integer::new).toArray();
    }

    public static void main(String[] args) {
        TreeNode left3 = new TreeNode(15, null, null);
        TreeNode right3 = new TreeNode(7, null, null);
        TreeNode right2 = new TreeNode(20, left3, right3);
        TreeNode left2 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, left2, right2);
        JZOffer_32_I_从上到下打印二叉树 jZOffer_32_I = new JZOffer_32_I_从上到下打印二叉树();
        for (int i : jZOffer_32_I.levelOrder(root)) {
            System.out.println(i);
        }
    }

}
