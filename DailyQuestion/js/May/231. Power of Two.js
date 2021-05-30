/**
 * @param {number} n
 * @return {boolean}
 */
//如果n为2的幂次方二进制位1000....0,n-1就是01111...1
 var isPowerOfTwo = function(n) {
   return n > 0 && (n & (n-1)) === 0;
};