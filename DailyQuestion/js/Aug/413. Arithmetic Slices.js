/**
 * @param {number[]} nums
 * @return {number}
 * count = 1+2+....(n-1)+(n-2)
 */
 var numberOfArithmeticSlices = function(nums) {
   //一个数列 至少有三个元素 
   if(nums.length < 3){
     return 0;
   }
   let diff = nums[0] - nums[1];
   let temp = 0;
   let count = 0;
   for(let i=2; i<nums.length; i++){
     if(nums[i-1] - nums[i] === diff){
       temp++;
     }else{
       diff = nums[i-1] - nums[i];
       temp=0;
     }
     count += temp;
   }
   return count;
};