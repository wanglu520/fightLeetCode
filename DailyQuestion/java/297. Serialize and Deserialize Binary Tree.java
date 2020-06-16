
package DailyQuestion.java;

import java.util.LinkedList;
import java.util.Queue;

import Util.TreeNode;

/**
 * Definition for a binary tree node.
 *  public class TreeNode { 
 *      public int val; 
 *      public TreeNode left; 
 *      public TreeNode right; 
 *      public TreeNode(int x) { val = x; } }
 */
class Codec {

    // Encodes a tree to a single string.
    //通过队列先进先出，每次先放入左边在放入右边。
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            TreeNode temp  = que.poll();
            if(temp == null){//没有分支的添加字符串null
                sb.append("null,");
            }else {
                sb.append(temp.val);
                sb.append(",");
                que.offer(temp.left);
                que.offer(temp.right);
            }
        }
        //去掉末尾的字符串null
        return sb.toString().replaceAll("(null,)*$","").replaceAll(",$","]");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //把字符串通过","切割成字符串数组；
        String[] tempArr = data.replaceAll("\\[|\\]","").split(",");
        int len = tempArr.length;
        //如果数组为空，返回null
        if (len == 0 || "".equals(tempArr[0])){
            return null;
        }
        int count = 1;
        TreeNode root = new TreeNode(Integer.parseInt(tempArr[0]));
        //通过队列先进先出，如果值为空 先入左边  在入右边。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty() && count < len){
            TreeNode temp = queue.poll();
            String leftVal = tempArr[count++];
            if(!"null".equals(leftVal)){
                TreeNode tempLeft = new TreeNode(Integer.parseInt(leftVal));
                temp.left = tempLeft;
                queue.offer(tempLeft);
            }
            if(count < len){
                String rightVal = tempArr[count++];
                if(!"null".equals(rightVal)){
                    TreeNode tempRight = new TreeNode(Integer.parseInt(rightVal));
                    temp.right = tempRight;
                    queue.offer(tempRight);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));