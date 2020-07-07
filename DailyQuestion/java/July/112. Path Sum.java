package DailyQuestion.java.July;

import Util.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return  helper(root,0,sum);
    }
    public boolean helper(TreeNode root,int cur,int sum)
    {
        if(root==null)
            return false;
        cur=cur+root.val;
        if(root.left==null&&root.right==null)
        {
            return cur==sum;
        }else
        {
            return helper(root.left,cur,sum)|| helper(root.right,cur,sum);
        }
    }
}