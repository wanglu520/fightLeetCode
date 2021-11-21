/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node|null} root
 * @return {number}
 */
 var maxDepth = function(root) {
  if(root === null){
      return 0;
  }
  let maxCount = 0;
  for(const child of root.children){
      maxCount = Math.max(maxCount, maxDepth(child))
  }
  return maxCount + 1;
};