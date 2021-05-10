/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
 var leafSimilar = function(root1, root2) {
    const seq1 = [];
    if(root1){
      dfs(root1, seq1);
    }
    const seq2 = [];
    if(root2){
      dfs(root2, seq2)
    }
    return seq1.toString() === seq2.toString();
};

const dfs = function(tree, seq){
  if(!tree.left && !tree.right){
    seq.push(tree.val)
  }else{
    if(tree.left){
      dfs(tree.left, seq);
    }
    if(tree.right){
      dfs(tree.right, seq)
    }
  }
}