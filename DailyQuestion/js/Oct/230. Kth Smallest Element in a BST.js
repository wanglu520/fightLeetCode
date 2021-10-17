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

/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
 var kthSmallest = function(root, k) {
  const myBst = new MyBst(root);
  return myBst.kthSmallest(k);
};
class MyBst{
  constructor(root){
      this.root = root;
      this.nodeNumMap = new Map();
      this.countNodeNum(root);
  }
  kthSmallest(k){
      if(this.getNodeNum(this.root) < k){
          return -1;
      }
      let node = this.root;
      while(node !== null){
          //左边节点必定小于node
          const leftNum = this.getNodeNum(node.left);
          if(leftNum < k - 1){//结果在右边
              k -= leftNum + 1;
              node = node.right;
          }else if(leftNum > k - 1){//结果在左边
              node = node.left;
          }else{
              break;
          }
      }
      return node !== null ? node.val : -1;
  }
  //统计当前节点的子节点个数
  countNodeNum(node){
      if(node === null){
          return 0;
      }
      this.nodeNumMap.set(
          node,
          1 + this.countNodeNum(node.left) + this.countNodeNum(node.right)
      )
      return this.nodeNumMap.get(node);
  }
  getNodeNum(node){
      return this.nodeNumMap.get(node) || 0;
  }
}