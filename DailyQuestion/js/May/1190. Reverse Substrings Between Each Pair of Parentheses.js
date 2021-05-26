var reverseParentheses = function(s) {
  const arr = [];
  let res = "";
  for(const ch of s){
    if(ch === "("){
      arr.push(res);
      res = "";
    }else if(ch === ")"){
      res = res.split("").reverse().join("");
      res = arr[arr.length - 1] + res;
      arr.pop();
    }else{
      res += ch;
    }
  }
  return res;
};