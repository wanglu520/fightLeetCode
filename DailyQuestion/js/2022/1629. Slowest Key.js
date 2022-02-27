/**
 * @param {number[]} releaseTimes
 * @param {string} keysPressed
 * @return {character}
 */
 var slowestKey = function(releaseTimes, keysPressed) {
  let res = keysPressed[0];
  let maxTime = releaseTimes[0];
  for(let i=1; i<releaseTimes.length; i++){
      const timeTemp = releaseTimes[i] - releaseTimes[i-1]; 
      if(maxTime < timeTemp || (maxTime === timeTemp && res < keysPressed[i])){
          maxTime = timeTemp;
          res = keysPressed[i];
      }
  }
  return res;
};