/**
 *Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *Note:
 *The solution set must not contain duplicate quadruplets.
 *Example:
 *Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *A solution set is:
 *[
 *[-1,  0, 0, 1],
 *[-2, -1, 1, 2],
 *[-2,  0, 0, 2]
 *]
 *给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *注意：
 *答案中不可以包含重复的四元组。
 *示例：
 *给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *满足要求的四元组集合为：
 *[
 *[-1,  0, 0, 1],
 *[-2, -1, 1, 2],
 *[-2,  0, 0, 2]
 *]
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
let fourSum = function(nums, target) {
    nums.sort((a, b)=>a-b);
    const len = nums.length - 1;
    for(let i = 0; i <= len -2;){
        let midLe = i+1, mdiRi = len-1, end=len;
    }

};

let nums = [1, 0, -1, 0, -2, 2];//[ -2, -1, 0, 0, 1, 2 ]
console.log(nums.sort((a,b)=>a-b));