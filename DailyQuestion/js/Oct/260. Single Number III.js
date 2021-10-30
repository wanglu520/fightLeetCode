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
