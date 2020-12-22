import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.TreeNode;

/**
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *  int val; 
 *  TreeNode left; 
 *  TreeNode right; 
 *  TreeNode(int x) { val = x; } }
 */
class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if(root == null){
          return res;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      Boolean leToRi = true;
      while (!queue.isEmpty()){
          Deque<Integer>  levelList = new LinkedList<>();
          int size = queue.size();
          for(int i=0; i<size; i++){
              TreeNode tempTn = queue.poll();
              if(leToRi){
                  levelList.offerLast(tempTn.val);
              }else {
                  levelList.offerFirst(tempTn.val);
              }
              if(tempTn.left != null){
                  queue.offer(tempTn.left);
              }
              if(tempTn.right != null){
                  queue.offer(tempTn.right);
              }
          }
          leToRi = !leToRi;
          res.add(new ArrayList<>(levelList));
      }
      return res;
  }
}