/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  private int res;
  public int rangeSumBST(TreeNode root, int low, int high) {
      res = 0;
      bfs(root, low, high);
      return res;
  }
  public void bfs(TreeNode root, int low, int high){
      if(root == null){
          return;
      }
      bfs(root.left, low, high);
      if(root.val>=low && root.val <= high){
          res += root.val;
      }
      bfs(root.right, low, high);
  }
}