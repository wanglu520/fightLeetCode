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
 * @return {boolean}
 */
 var findTarget = function(root, k) {
  const set = new Set();
  return dfs(root, set, k)
};
//深度
const dfs = function(root, set, k){
  if(!root){
      return false;
  }
  if(set.has(k - root.val)){
      return true;
  }else{
      set.add(root.val);
      return dfs(root.left, set, k) || dfs(root.right, set, k)
  }
}
//广度
var findTarget = function(root, k) {
  if(!root) return false;
  const set = new Set();
  const queue = [root];
  let index = 0;
  while(index < queue.length){
      let temp = queue[index];
      if(set.has(k - temp.val)){
          return true;
      }
      set.add(temp.val);
      !!temp.left && queue.push(temp.left);
      !!temp.right && queue.push(temp.right);
      index++;
  }
  return false;
};
