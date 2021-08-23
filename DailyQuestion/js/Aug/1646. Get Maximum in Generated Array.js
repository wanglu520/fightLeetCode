/**
 * @param {number} n
 * @return {number}
 */
 var getMaximumGenerated = function(n) {
  if(n < 2){
    return n;
  }
  const nums = [0, 1];
  let maxNum = 1;
  for(let i=2; i <= n; i++){
    const index = i/2|0;
    nums[i] = nums[index];
    //偶数i%2=0，奇数i%2=1
    if(i % 2 === 1){
      nums[i] += nums[index+1]
    }
    maxNum = Math.max(maxNum, nums[i]);
  }
  return maxNum;
};