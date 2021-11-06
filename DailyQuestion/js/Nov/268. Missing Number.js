/**
 * @param {number[]} nums
 * @return {number}
 */
//排序
 var missingNumber = function(nums) {
  nums.sort((a, b)=>a-b)
  for(let i = 0; i < nums.length; i++){
      if(nums[i] != i){
          return i;
      }
  }
  return nums.length;
};

/**
 * @param {number[]} nums
 * @return {number}
 */
 //位运算 按位异或1^1=0
 var missingNumber = function(nums) {
  let missNum = nums.length;
  for(let i=0; i<nums.length; i++){
      missNum ^= nums[i] ^ i;
  }
  return missNum;
};