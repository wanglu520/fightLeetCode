/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
 //二叉搜索树 left<root<right
 var kthSmallest = function(root, k) {
  const stack  = [];
  while(root !== null || stack.length){
      while(root !== null){
          stack.push(root);
          root = root.left;
      }
      //最左边的数最小
      root = stack.pop();
      if(--k === 0){
          break;
      }
      root = root.right;
  }
  return root.val;
};