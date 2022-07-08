package com.zhz.SwordOffer;

import com.zhz.utils.TreeNode;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 */
public class JZOffer_32_I_从上到下打印二叉树 {

    /**
     * 广度优先遍历算法（BFS）
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
            TreeNode poll = queue.poll();
            res.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return res.stream().mapToInt(Integer::new).toArray();
    }
}
