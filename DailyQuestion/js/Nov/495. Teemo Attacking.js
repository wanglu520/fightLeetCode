/**
 * @param {number[]} timeSeries
 * @param {number} duration
 * @return {number}
 */
 var findPoisonedDuration = function(timeSeries, duration) {
  let res = duration;
  let sta = timeSeries[0];
  for(let i=1; i<timeSeries.length; i++){
      res += Math.min(timeSeries[i] - sta, duration);
      sta = timeSeries[i];
  }
  return res;
};