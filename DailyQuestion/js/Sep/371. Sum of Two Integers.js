/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
//cur=0时说明a和b 二进制相加没有进一位（例如：2（10）和1（01））此时a+b = a^b;
 var getSum = function(a, b) {
  while(b !== 0){
      const cur = (a & b) << 1;
      a = a ^ b;
      b = cur;
  }
  return a;
};