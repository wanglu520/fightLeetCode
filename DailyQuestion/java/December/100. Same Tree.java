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
  public boolean isSameTree(TreeNode p, TreeNode q) {
      if(p == null && q == null){
          return true;
      }else if(p != null && q != null){
          Queue<TreeNode> queueP = new LinkedList<>();
          Queue<TreeNode> queueQ = new LinkedList<>();
          queueP.offer(p);
          queueQ.offer(q);
          while (!queueP.isEmpty() || !queueQ.isEmpty()){
              if(!queueP.isEmpty() && !queueQ.isEmpty()){
                  TreeNode treeNodeQ = queueQ.poll();
                  TreeNode treeNodeP = queueP.poll();
                  if (treeNodeQ.val != treeNodeP.val){
                      return false;
                  }
                  if(treeNodeP.left == null && treeNodeQ.left != null){
                      return false;
                  }else if(treeNodeP.left != null && treeNodeQ.left == null){
                      return false;
                  }else if(treeNodeP.left != null && treeNodeQ.left != null){
                      queueP.offer(treeNodeP.left);
                      queueQ.offer(treeNodeQ.left);
                  }
                  if(treeNodeP.right == null && treeNodeQ.right != null){
                      return false;
                  }else if(treeNodeP.right != null && treeNodeQ.right == null){
                      return false;
                  }else if(treeNodeP.right != null && treeNodeQ.right != null){
                      queueP.offer(treeNodeP.right);
                      queueQ.offer(treeNodeQ.right);
                  }
              }else {
                  return false;
              }
          }
          return true;
      }else{
          return false;
      }
  }
}