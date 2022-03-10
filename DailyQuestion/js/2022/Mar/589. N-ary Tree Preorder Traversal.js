/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number[]}
 */
 var preorder = function(root) {
  const res = [];
  handle(root, res);
  return res;
};

const handle = function(root, res){
  if(root === null){
      return;
  }
  res.push(root.val);
  for(let node of root.children){
      handle(node, res);
  }
}
