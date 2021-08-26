/**
 * @param {number[]} people
 * @param {number} limit
 * @return {number}
 */
 var numRescueBoats = function(people, limit) {
  people.sort((a,b)=>a-b);
  let s = 0, end = people.length-1, sum=0;
  while(s <= end){
      if(people[s] + people[end] <= limit){
          s++;
      }
      end--;
      sum++;
  }
  return sum;
};
