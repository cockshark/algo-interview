package com.zhz.datastructures.swordfingeroffer.search_backtracking;

import com.zhz.datastructures.commons.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author zhouhengzhe
 * @description: 从上到下打印二叉树 II
 * @since v1
 */
public class JZOffer_32_II_从上到下打印二叉树_II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode left3 = new TreeNode(15, null, null);
        TreeNode right3 = new TreeNode(7, null, null);
        TreeNode right2 = new TreeNode(20, left3, right3);
        TreeNode left2 = new TreeNode(9, null, null);
        TreeNode root = new TreeNode(3, left2, right2);
        JZOffer_32_II_从上到下打印二叉树_II jZOffer_32_II = new JZOffer_32_II_从上到下打印二叉树_II();
        jZOffer_32_II.levelOrder(root);
    }
}