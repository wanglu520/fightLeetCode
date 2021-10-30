/**
 * @param {number[]} nums
 * @return {number[]}
 */
//通过哈希表记录次数
 var singleNumber = function(nums) {
   const map = new Map();
   const res = [];
   for(const num of nums){
    map.set(num, (map.get(num) || 0) + 1);
   }
   for(const [key, val] of map.entries()){
     if(val === 1){
       res.push(key);
     }
   }
   return res;
};
/**
 * @param {number[]} nums
 * @return {number[]}
 */
//位运算
 var singleNumber = function(nums) {
  let xorNum = 0;
  //获得两个不相同数字的异或值；
  for(const num of nums){
    xorNum ^= num;
  }
  //找到两个不同数字，二进制位上最低位不相同数的位置
  //妙啊，通过按位与其负数得到最低非0位。负数就是其补码（按位取反+1）
  let diffNum = xorNum & -xorNum;
  // let diffNum = 1;
  // while((xorNum & diffNum) === 0){
  //   diffNum <<= 1;
  // }
  //通过diffNum把数组分成两部分。每个部分最终的结果就是要找的数字
  let num1 = 0, num2 = 0;
  for(const tempNum of nums){
    if(tempNum & diffNum){
      num1 ^= tempNum;
    }else{
      num2 ^= tempNum;
    }
  }
  return [num1, num2]
}