package com.zhz.datastructures.swordfingeroffer.search_backtracking;

import com.zhz.datastructures.commons.TreeNode;

import java.util.*;

/**
 * @author zhouhengzhe
 * @description: 从上到下打印二叉树 III
 * @since v1
 */
public class JZOffer_32_III_从上到下打印二叉树_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (res.size()%2==1){
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}
