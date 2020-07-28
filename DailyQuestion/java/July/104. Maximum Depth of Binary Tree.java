package DailyQuestion.java.July;

import Util.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    //递归左右树节点
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int len = 1;
        return Math.max(dp(root.right, len),dp(root.left, len));
    }
    public int dp(TreeNode treeNode, int depth){
        //节点为空返回上一个节点深度
        if(treeNode == null){
            return depth;
        }
        depth++;
        return Math.max(dp(treeNode.left, depth), dp(treeNode.right, depth));
    }
    //优化一下递归方法
    public int maxDepth1(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }
}