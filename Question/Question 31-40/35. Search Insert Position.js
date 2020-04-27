/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target){
	let index = 0;
	if(nums.length === 0){
		return index;
	}
	
	for(let num of nums){
		if(num === target || num > target){
			return index;
		}
		index++;
	}
	return index;
}