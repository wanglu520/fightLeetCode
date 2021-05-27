/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
 var hammingDistance = function(x, y) {
   //去掉相同位置上是1的
   let temp = x ^ y;
   let res = 0;
   while(temp !== 0){
     res += temp & 1;
     temp >>= 1
   }
   return res;
};