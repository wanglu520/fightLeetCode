/**
 * @param {string[]} ops
 * @return {number}
 */
 var calPoints = function(ops) {
  let res = 0;
  const len = ops.length;
  const arr = []; 
  for(const op of ops){
      const n = arr.length;
      switch(op){
          case "+":
              arr.push(arr[n-1] + arr[n-2]);
              res += arr[n];
              break;
          case "D":
              arr.push(2 * arr[n-1]);
              res += arr[n];
              break;
          case "C":
              res -= arr.pop();
              break;
          default:
              arr.push(op|0);
              res += arr[n];
              break;
      }
  }
  return res;
};