/**
 * @param {number[]} nums
 * @return {number}
 */
 //相当于每次一个元素-1
 var minMoves = function(nums) {
  const minNum = Math.min(...nums);
  let res = 0;
  for (const num of nums) {
      res += num - minNum;
  }
  return res;
};
