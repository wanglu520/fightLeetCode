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
  public int deepestLeavesSum(TreeNode root) {
      if(root == null){
          return 0;
      }
      Map<String, Integer> map = new HashMap<String, Integer>(){{
         put("maxDeep", 0);
         put("sum", 0);
      }};
      dfs(root, map, 0);
      return map.get("sum");
  }
  public void dfs(TreeNode root, Map<String, Integer> map, Integer deep){
      if(root.left == null && root.right == null){
          if(map.get("maxDeep") == deep){
              map.put("sum", map.get("sum") + root.val);
          }else if(map.get("maxDeep") < deep){
              map.put("maxDeep", deep);
              map.put("sum", root.val);
          }
          return;
      }
      if (root.left != null){
        dfs(root.left, map, deep+1);
      }
      if (root.right != null){
        dfs(root.right, map, deep+1);
      }
  }
}