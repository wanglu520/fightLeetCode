/**
 * @param {number[]} nums
 * @return {number[]}
 */
//通过map记录num出现次数。超过num次数len/3标记skip 直接跳过
 var majorityElement = function(nums) {
  const n = Math.floor(nums.length/3);
  const map = new Map();
  const res = [];
  for(const num of nums){
      let val = map.get(num);
      //已记录的数字直接跳过
      if(val === "skip"){
          continue;
      }
      val = (val||0) + 1;
      if(val > n){
          res.push(num);
          val = "skip";
      }
      map.set(num, val);
  }
  return res;
};