/**
 * @param {number[]} chalk
 * @param {number} k
 * @return {number}
 */
//假设数组[1,2,7]和为10，那么1、11、21..这些取模为1的数都落在索引1上，
//所以只需要计算k%数组一个循环总消耗数的余数
 var chalkReplacer = function(chalk, k) {
  let sum = chalk.reduce((a, b)=> a+b, 0);
  let index = 0;
  let num = k % sum;
  while(true){
      num -= chalk[index];
      if(num < 0){
          return index;
      }
      index++;
  }
};