/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
 var licenseKeyFormatting = function(s, k) {
  const len = s.length;
  let res = [], index = 0;
  for(let i = len - 1; i>=0; i--){
      let temp = s[i];
      if(temp === "-"){
          continue;
      }
      index++;
      if(temp >= "a" && temp <="z"){
          temp = temp.toUpperCase();
      }
      res.push(temp);
      //k的倍数加分隔符
      if(index % k === 0){
          res.push("-");
      }
  }
  //处理特殊情况，最后一位是“-”
  if(res.length > 0 && res[res.length - 1] === "-"){
      res.pop();
  }
  return res.reverse().join("");
};
