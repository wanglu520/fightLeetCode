/**
 * @param {number[]} w
*/
var Solution = function(w) {
  this.preSums = [w[0]];
  for(let i=1; i<w.length; i++){
    this.preSums[i] = this.preSums[i-1] + w[i];
  }
  this.total = this.preSums[this.preSums.length - 1];
};

/**
 * @return {number}
 */
Solution.prototype.pickIndex = function() {
  const x = Math.floor(Math.random() * this.total) + 1;
  let left = 0, right = this.preSums.length - 1;
  while(left < right){
    let mid = Math.floor((right - left)/2) + left;
    if(this.preSums[mid] < x){
      left = mid+1;
    }else{
      right = mid;
    }
  }
  return left;
};

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */

