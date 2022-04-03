/**
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
 var nextGreatestLetter = function(letters, target) {
  let right = letters.length - 1;
  if(target >= letters[right]){
      return letters[0];
  }
  let left = 0;
  while(left < right){
      const mid = left + (right - left) / 2 | 0;
      if(target < letters[mid]){
          right = mid;
      }else{
          left = mid + 1;
      }
  }
  return letters[left];
};