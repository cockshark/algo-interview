package com.zhz.SwordOffer;


import com.zhz.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 重建二叉树
 */
public class Offer_7_BuildTree {

    /**
     * 重建二叉树
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (Objects.nonNull(node)) {
                if (node.val != inorder[inorderIndex]) {
                    node.left = new TreeNode(preorderVal);
                    stack.push(node.left);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                        node = stack.pop();
                        inorderIndex++;
                    }
                    node.right = new TreeNode(preorderVal);
                    stack.push(node.right);
                }
            }
        }
        return root;
    }
}
