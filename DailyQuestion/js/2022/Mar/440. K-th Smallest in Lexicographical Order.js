/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
 var findKthNumber = function(n, k) {
  let cur = 1;
  k--;
  while(k > 0){
    const steps = getsteps(cur, n);
    //cur开头不能满足，cur++；
    if(steps <= k){
      k -= steps;
      cur++;
    }else{
      cur *= 10;
      k--;
    }
  }
  return cur;
}
//以cur开头小于n的步数
const getsteps = function(cur, k){
  let steps = 0;
  let first = cur;
  let last = cur;
  while(first <= n){
    steps += Math.min(last, n) - first + 1;
    first *= 10;
    last = last * 10 + 9;
  }
  return steps;
}