/**
 * @param {number[]} candyType
 * @return {number}
 */
//平分最多获得一半candyType.length/2，种类低于candyType.length/2 取决于种类数
 var distributeCandies = function(candyType) {
  const set = new Set(candyType);
  return Math.min(set.size, candyType.length/2);
};
