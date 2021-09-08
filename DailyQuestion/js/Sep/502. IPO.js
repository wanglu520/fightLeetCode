/**
 * @param {number} k
 * @param {number} w
 * @param {number[]} profits
 * @param {number[]} capital
 * @return {number}
 */
//超时，每次取最大收益需要数组重新排序，数组再去掉最大值
 var findMaximizedCapital = function(k, w, profits, capital) {
  const arr = [];
  const len = profits.length;
  let cur = 0;
  for(let i=0; i<len; i++){
    arr[i] = [capital[i], profits[i]];
  }
  arr.sort((x, y) => x[0] - y[0]);
  const pq = [];
  for(let i=0; i<k; i++){
    //获取当前资本W能投资的项目
    while(cur < len && arr[cur][0] <= w){
      pq.push(arr[cur][1]);
      cur++;
    }
    //排序获取当前能获得的最大收益
    pq.sort((x, y)=>y-x);
    if(pq.length > 0){
      w += pq[0];
      pq.splice(0, 1);
    }else{
      break;
    }
  }
  return w;
};