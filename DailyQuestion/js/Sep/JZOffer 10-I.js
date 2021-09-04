/**
 * @param {number} n
 * @return {number}
 */
 const MOD = 1000000007;
 //超时
 var fib = function(n) {
     if(n < 2){
         return n;
     }
     return (fib(n-1) + fib(n-2)) % MOD;
 };
 //通过
 var fib = function(n){
   if(n < 2) return n;
   let a = 0, b = 0, c = 1;
   for(let i = 1; i < n; i++){
     a = b;
     b = c;
     c = (a + b) % MOD;
   }
   return c;
 }