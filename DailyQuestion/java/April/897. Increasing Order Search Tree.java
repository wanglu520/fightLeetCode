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
  private TreeNode temp;
  public TreeNode increasingBST(TreeNode root) {
      if(root == null){
          return null;
      }
      TreeNode treeNode = new TreeNode(0);
      temp = treeNode;
      bfs(root);
      return treeNode.right;
  }
  public void bfs(TreeNode root){
      if (root.left != null){
          bfs(root.left);
      }
      temp.right = new TreeNode();
      temp = temp.right;
      temp.val = root.val;
      if(root.right != null){
          bfs(root.right);
      }
  }
}