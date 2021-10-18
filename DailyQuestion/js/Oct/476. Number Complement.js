/**
 * @param {number} num
 * @return {number}
 */
//补数是对该数的二进制表示取反,num 异或 相同位数的二进制都为1的数
 var findComplement = function(num) {
   //temp=长度为num的二进制位数的"1111..."
  const temp = parseInt(new Array(num.toString(2).length+1).join("1"),2);
  return num ^ temp; 
};