/**
 * @param {number[][]} points
 * @return {number}
 */
//计算每个点到其它点的距离，通过map记录相同距离的次数m，m个点选出两个不同元素的排列数m*（m-1）
 var numberOfBoomerangs = function(points) {
    let res = 0;
    for(let p of points){
      const map = new Map();
      for(let q of points){
        const dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
        map.set(dis, map.getOrDefault(dis, 0)+1);
      }
      for(let val of map.values()){
        res += val*(val-1);
      }
    }
    return res;
};
Map.prototype.getOrDefault=function(key, defVal){
  return this.get(key) !== undefined ? this.get(key) : defVal;
}