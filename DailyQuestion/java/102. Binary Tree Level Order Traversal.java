
package DailyQuestion.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> qt = new LinkedList<>();
        qt.offer(root);
        while (!qt.isEmpty()){
            int size = qt.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i < size; i++){
                TreeNode tN = qt.poll();
                list.add(tN.val);
                if(tN.left != null) qt.offer(tN.left);
                if(tN.right != null) qt.offer(tN.right);
            }
            res.add(list);
        }
        return res;
    }
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<TreeNode>> stack = new Stack<>();
        if (root != null){
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            stack.add(list);
        }
        int size = 0;
        while (size < stack.size()){
            size = stack.size();
            List<TreeNode> temp = stack.peek();
            List<TreeNode> list = new ArrayList<>();
            List<Integer> resList = new ArrayList<>();
            for(TreeNode tN : temp){
                resList.add(tN.val);
                if(tN.left != null){
                    list.add(tN.left);
                }
                if(tN.right != null){
                    list.add(tN.right);
                }
            }
            res.add(resList);
            if(list.size() == 0){
                break;
            }
            stack.add(list);
        }
        return res;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}