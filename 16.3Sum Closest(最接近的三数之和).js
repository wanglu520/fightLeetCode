/**
 *Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *Example:
 *Given array nums = [-1, 2, 1, -4], and target = 1.
 *The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
 /**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
let threeSumClosest = function(nums=[], target) {
    let len = nums.length;
    let closestVal = Infinity;
    let sum = "",ret=null;
    nums.sort((a, b)=>a-b);
    for(let i=0; i<len-2;){
        let mid = i+1, end = len - 1;
        while(mid < end){
            sum = nums[i] + nums[mid] + nums[end];
            let tmp = sum - target;
            if(tmp === 0){ return sum}
            if(Math.abs(closestVal) >= Math.abs(tmp)){
                closestVal = tmp;
                ret = sum;
            }
            if(tmp > 0){
              while(nums[end] === nums[--end]){}
            }else{
              while(nums[mid] === nums[++mid]){}
            }
        }
        while(nums[i] === nums[++i]){}
    }
    return ret
};
console.log(threeSumClosest(nums = [1,2,4,8,16,32,64,128], target = 82));