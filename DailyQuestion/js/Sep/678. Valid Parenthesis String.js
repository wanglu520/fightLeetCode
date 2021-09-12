/**
 * @param {string} s
 * @return {boolean}
 */
//栈，先匹配右括号，再考虑剩余的左括号和*是否有效
 var checkValidString = function(s) {
  let len = -1;
  //arr保存（和*，arrLeftIndex保存（索引，arrStarIndex保存*索引
  const arr=[], arrLeftIndex=[], arrStarIndex=[];
  for(let str of s){
      if(str === "("){
          arr.push(str);
          arrLeftIndex.push(++len);
      }else if(str === "*"){
          arr.push(str);
          arrStarIndex.push(++len);
      }else if(str === ")"){
          //有（先匹配
          if(arrLeftIndex.length > 0){
              arr[arrLeftIndex.pop()] = "";
          }else if(arrStarIndex.length > 0){//用*匹配
              arr[arrStarIndex.pop()] = "";
          }else{//（和*都么有就不是有效的
              return false;
          }
      }
  }
  if(arrLeftIndex.length === 0){
      return true;
  }
  let count = 0;
  //用上面思想，匹配剩余的（和*是否构成有效的
  while(len >= 0){
      const temp = arr[len--];
      if(temp === "*"){
          count++;
      }else if(temp === "("){
          if(count > 0){
              count--;
          }else{
              return false;
          }
      }
  }
  return true;
};
//栈，优化上面方法
var checkValidString = function(s) {
  let len = -1;
  //arrLeftIndex保存（索引，arrStarIndex保存*索引
  const arrLeftIndex=[], arrStarIndex=[];
  for(let str of s){
      if(str === "("){
          arrLeftIndex.push(++len);
      }else if(str === "*"){
          arrStarIndex.push(++len);
      }else if(str === ")"){
          //有（先匹配
          if(arrLeftIndex.length > 0){
              arrLeftIndex.pop();
          }else if(arrStarIndex.length > 0){//用*匹配
              arrStarIndex.pop();
          }else{//（和*都么有就不是有效的
              return false;
          }
      }
  }
  while(arrLeftIndex.length && arrStarIndex.length){
    const leftInde = arrLeftIndex.pop();
    const starIndex = arrStarIndex.pop();
    //(的索引比*的大，说明（右侧没有与之匹配的
    if(leftInde > starIndex){
      return false;
    }
  }
  return arrLeftIndex.length === 0;
};