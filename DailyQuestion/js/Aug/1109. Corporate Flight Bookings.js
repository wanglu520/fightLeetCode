/**
 * @param {number[][]} bookings
 * @param {number} n
 * @return {number[]}
 */
//暴力
 var corpFlightBookings = function(bookings, n) {
  const answer = new Array(n).fill(0);
  for(let booking of bookings){
      const first = booking[0], last = booking[1], seat = booking[2];
      for(let i = first; i<=last; i++){
          answer[i-1] += seat;
      }
  }
  return answer;
};
//差分 [1,2,10],[2,3,20]
//10 0 -10
//   20 0 
//answer=[10, 10+20=30, 10+(-10)+20=20] 
var corpFlightBookings = function(bookings, n) {
  const answer = new Array(n).fill(0);
  for(let booking of bookings){
    answer[booking[0] - 1] += booking[2];
    if(booking[1] < n){
      answer[booking[1]] -= booking[2]
    }
  }
  for(let i=1; i<n; i++){
    answer[i] += answer[i-1];
  }
  return answer;
}