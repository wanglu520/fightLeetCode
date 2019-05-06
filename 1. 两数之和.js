/* 
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// 0.22 seconds
var nums = [3,2,4], target = 6;
var twoSum = function(nums, target) {
    for(let i = 0; nums.length > i; i++){
        let val = nums[i];
        nums.splice(i,1,"seat");
        let index = nums.indexOf(target - val);
        if(index > -1){
            return [i, index];
        }
    }
    return []
};
//test
var twoSum1 = function(nums, target) {
    var copyNums = [...nums];
    for(var i=0; i<nums.length; i++){
        copyNums.splice(i,1,"seat");
        var findIndex = copyNums.findIndex((val)=>val === (target - nums[i]));
        if(findIndex > -1){
            return [i,findIndex];
        }
    }
};
console.log(twoSum(nums, target));