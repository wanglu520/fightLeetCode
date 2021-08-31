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