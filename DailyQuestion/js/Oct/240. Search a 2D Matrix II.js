/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
  for (const row of matrix) {
      const index = search(row, target);
      if (index >= 0) {
          return true;
      }
  }
  return false;
};

const search = (nums, target) => {
  let low = 0, high = nums.length - 1;
  while (low <= high) {
      const mid = Math.floor((high - low) / 2) + low;
      const num = nums[mid];
      if (num === target) {
          return mid;
      } else if (num > target) {
          high = mid - 1;
      } else {
          low = mid + 1;
      }
  }
  return -1;
}
