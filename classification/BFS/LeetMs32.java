package classification.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 执行结果：通过
 * 执行用时 :1 ms, 在所有 Java 提交中击败了99.77%的用户
 * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了100.00%的用户
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<LinkedList<TreeNode>> listTr = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        listTr.add(linkedList);
        for(int i=0; i<listTr.size(); i++){
            LinkedList<TreeNode> curTr = listTr.get(i);//获取当前层级接口
            LinkedList<TreeNode> subLink = new LinkedList<>();//装入树的下一层节点
            LinkedList<Integer> curList = new LinkedList<>();//装入当前层级节点的值
            while (!curTr.isEmpty()){
                TreeNode temptr = curTr.removeFirst();
                if(temptr.left != null){
                    subLink.add(temptr.left);
                }
                if(temptr.right != null){
                    subLink.add(temptr.right);
                }
                if(i % 2 == 0){//偶数正序
                    curList.add(temptr.val);
                }else {//奇数倒序
                    curList.addFirst(temptr.val);
                }
            }
            if(!subLink.isEmpty()){
                listTr.add(subLink);
            }
            if(!subList.isEmpty()){
                list.add(curList);
            }
        }
        return list;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}