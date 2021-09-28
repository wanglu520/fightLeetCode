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
 * @param {number} targetSum
 * @return {number}
 */
//通过hash记录前缀和，然后通过map.get(当前节点的前缀和-targetSum)获取有没有这样的路径
 var pathSum = function(root, targetSum) {
   const map = new Map();
   map.set(0, 1);
   return dfs(root, map, 0, targetSum);
};

const dfs = function(root, map, curSum, targetSum){
  if(root === null){ return 0;}
  //res为本节点的路径条数
  let res = 0;
  //本节点的前缀和
  curSum += root.val;
  //获取路径条数
  res = map.getOrDefault((curSum - targetSum), 0);
  //记录本节点的路径条数
  map.set(curSum, map.getOrDefault(curSum, 0) + 1);
  //分别递归树的左右树枝
  res += dfs(root.left, map, curSum, targetSum);
  res += dfs(root.right, map, curSum, targetSum);
  //回溯时减去当前节点
  map.set(curSum, map.get(curSum)-1);
  return res;
}
//默认值
Map.prototype.getOrDefault=function(key, defVal){
  return this.get(key) !== undefined ? this.get(key) : defVal;
}