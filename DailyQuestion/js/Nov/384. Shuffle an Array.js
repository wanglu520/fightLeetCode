/**
 * @param {number[]} nums
 */
 var Solution = function(nums) {
  this.nums = nums;
  this.original = [...nums];
  this.length = nums.length;
};

/**
* @return {number[]}
*/
Solution.prototype.reset = function() {
  this.nums = [...this.original];
  return this.nums;
};

/**
* @return {number[]}
*/
Solution.prototype.shuffle = function() {
  for(let i=0; i<this.length; i++){
      const j = Math.floor(Math.random() * (this.length - i)) + i;
      const temp = this.nums[i];
      this.nums[i] = this.nums[j];
      this.nums[j] = temp;
  }
  return this.nums;
};

/**
* Your Solution object will be instantiated and called as such:
* var obj = new Solution(nums)
* var param_1 = obj.reset()
* var param_2 = obj.shuffle()
*/