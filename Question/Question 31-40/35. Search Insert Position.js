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
//二分搜索
var searchInsert1 = function(nums, target){
    let l = 0;
    let r = nums.length-1;
    while(l<=r){
        let mid = l + ((r-l)>>1);
        if(nums[mid] === target){
            return mid;
        }else if(nums[mid] > target){
            r = mid - 1;
        }else{
            l = mid + 1;
        }
    }
    return l;
}