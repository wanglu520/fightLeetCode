/**
 * @param {number[][]} mat
 * @param {number} k
 * @return {number[]}
 */
 var kWeakestRows = function(mat, k) {
  let res = [];
  let count = [];//[[索引，战斗力]]
  for(let i = 0; i<mat.length; i++){
    count[i] = [i, 0];
    for(let j = 0; j < mat[i].length; j++){
        if(mat[i][j] === 0){
            break;
        }
        count[i][1]++;
    }
  }
  count.sort((a,b)=>{
      if(a[1] === b[1]){//战斗力相同比索引
          return a[0] - b[0];
      }
      return a[1] - b[1];
  })
  for(let i=0; i < k; i++){
      res.push(count[i][0]);
  }
  return res;
};