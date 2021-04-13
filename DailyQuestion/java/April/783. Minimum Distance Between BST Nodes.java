package DailyQuestion.java.April;

import Util.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  private int res=Integer.MAX_VALUE;
  private int pre=-1;
  public int minDiffInBST(TreeNode root) {
      dfs(root);
      return res;
  }
  public void dfs(TreeNode root){
      if(root == null){
          return;
      }
      if(root.left != null){
          dfs(root.left);
      }
      if(pre == -1){//节点为非负值
          pre = root.val;
      }else {
          res = Math.min(res, root.val - pre);
          pre = root.val;
      }
      if(root.right != null){
          dfs(root.right);
      }
  }
}