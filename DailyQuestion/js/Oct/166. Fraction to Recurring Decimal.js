/**
 * @param {number} numerator
 * @param {number} denominator
 * @return {string}
 */
 var fractionToDecimal = function(numerator, denominator) {
  //可整除
  if(numerator % denominator === 0){
      return "" + Math.floor(numerator/denominator);
  }
  const sb = [];
  //负数情况
  if(numerator < 0 ^ denominator < 0){
      sb.push("-");
  }
  numerator = Math.abs(numerator);
  denominator = Math.abs(denominator);
  //整数部分
  sb.push(Math.floor(numerator/denominator));
  sb.push(".");
  //hash表记录余数,key=余数，val=小数的索引
  const map = new Map();
  let index = 0;
  //小数部分用余数长除法计算
  const decimals = [];
  let decimal = numerator % denominator;
  while(decimal !== 0 && !map.has(decimal)){
      map.set(decimal, index);
      decimal *= 10;
      decimals.push(Math.floor(decimal / denominator));
      decimal %= denominator;
      index++;
  }
  //余数不为0，有循环
  if(decimal !== 0){
      const myIndex = map.get(decimal);
      //插入括号
      decimals.splice(myIndex, 0, "(");
      decimals.push(")");
  }
  //拼接小数部分
  sb.push(decimals.join(""))
  return sb.join("");
};