/**
 * @param {number} n
 * @param {number[][]} flights
 * @param {number} src
 * @param {number} dst
 * @param {number} k
 * @return {number}
 */
//存在互相飞的循环的，超时了
 let min;
 var findCheapestPrice = function(n, flights, src, dst, k) {
   min = -1;
   const map = {};
   for(let flight of flights){
     if(map[flight[0]] === undefined){
     map[flight[0]] = [];
     }
     map[flight[0]].push(flight);
   }
   if(!!map[src]){
     backT(map, src, dst, k, 0, 0);
   }
   return min;
 };
 
 const backT = (map, src, dst, k, price, count)=>{
   if(count > k || (min != -1 && price >= min) || !map[src]){
     return;
   }
   for(let arr of map[src]){
     const temp = arr[2] + price;
     if(arr[1] === dst){
       min = min=== -1 ? temp : Math.min(min, temp);
       continue;
     }
     backT(map, arr[1], dst, k, temp, ++count);
     --count;
   }
 }
 //Bellman Ford
 var findCheapestPrice = function(n, flights, src, dst, k) {
   const dist = new Array(100).fill(Number.MAX_SAFE_INTEGER);
   dist[src] = 0;
   for(let i =0; i<k+1; i++){
     const clone = [...dist];
     for(let f of flights){
       const x = f[0], y = f[1], p = f[2];
       dist[y] = Math.min(dist[y], clone[x]+p);
     }
   }
   return dist[dist] === Number.MAX_SAFE_INTEGER ? -1 : dist[dst];
 }