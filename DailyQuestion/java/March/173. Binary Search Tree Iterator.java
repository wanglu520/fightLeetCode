package DailyQuestion.java.March;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Util.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BSTIterator {
  private List<Integer> list;
  private Iterator<Integer> iterator;
  public BSTIterator(TreeNode root) {
      list = new ArrayList<>();
      traverse(root);
      iterator = list.iterator();
  }

  public int next() {
      return iterator.next();
  }

  public boolean hasNext() {
      return iterator.hasNext();
  }
//中序遍历树
  private void traverse(TreeNode root){
      if(root.left != null){
          traverse(root.left);
      }
      list.add(root.val);
      if(root.right != null){
          traverse(root.right);
      }
  }
}

/**
* Your BSTIterator object will be instantiated and called as such:
* BSTIterator obj = new BSTIterator(root);
* int param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/